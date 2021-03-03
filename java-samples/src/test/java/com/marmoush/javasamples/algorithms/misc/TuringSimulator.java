package com.marmoush.javasamples.algorithms.misc;
/* The authors of this work have released all rights to it and placed it
in the public domain under the Creative Commons CC0 1.0 waiver
(http://creativecommons.org/publicdomain/zero/1.0/).

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

Retrieved from: http://en.literateprograms.org/Turing_machine_simulator_(Java)?oldid=12337
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum Direction {
  LEFT,
  RIGHT
};

enum MySymbol {
  A("a"),
  B("b"),
  BLANK("#");

  private final String ch;

  MySymbol(String s) {
    ch = s;
  }

  public static List<MySymbol> parseString(String s) {
    List<MySymbol> result = new ArrayList<MySymbol>();
    for (int i = 0; i < s.length(); i++) {
      switch (s.charAt(i)) {
        case 'a':
          result.add(A);
          break;
        case 'b':
          result.add(B);
          break;
        default:
          assert false;
      }
    }
    return result;
  }

  public String toString() {
    return ch;
  }
}

class ControlState<Symbol> {
  public final String name;
  public final boolean accepting;
  public final Map<Symbol, TransitionResult<Symbol>> transitions = new HashMap<Symbol, TransitionResult<Symbol>>();

  public ControlState(String n, boolean a) {
    name = n;
    accepting = a;
  }

  public String toString() {
    return name;
  }
}

class TransitionResult<Symbol> {
  public final ControlState<Symbol> controlState;
  public final Symbol writeSymbol;
  public final Direction dir;

  public TransitionResult(ControlState<Symbol> c, Symbol s, Direction d) {
    controlState = c;
    writeSymbol = s;
    dir = d;
  }
}

class TuringMachine<Symbol> {
  public final ControlState<Symbol> initialControlState;
  public final Symbol blankSymbol;

  public TuringMachine(ControlState<Symbol> x, Symbol b) {
    initialControlState = x;
    blankSymbol = b;
  }
}

public class TuringSimulator<Symbol> {
  public static final int TRACE_TAPE_CHARS = 60;

  public final TuringMachine<Symbol> machine;
  public final List<Symbol> tape;
  public ControlState<Symbol> controlState;
  public int headPosition = 0; // Initially at left end

  public TuringSimulator(TuringMachine<Symbol> m, List<Symbol> inputString) {
    machine = m;
    controlState = machine.initialControlState;
    tape = new ArrayList<Symbol>(inputString);
  }

  public static void main(String[] args) {
    ControlState<MySymbol> s0 = new ControlState<MySymbol>("start", false);
    ControlState<MySymbol> s1 = new ControlState<MySymbol>("scan_right", false);
    ControlState<MySymbol> s2 = new ControlState<MySymbol>("reverse", false);
    ControlState<MySymbol> s3 = new ControlState<MySymbol>("scan_left", false);
    ControlState<MySymbol> s4 = new ControlState<MySymbol>("check", false);
    ControlState<MySymbol> s5 = new ControlState<MySymbol>("finish", true);

    s0.transitions.put(MySymbol.BLANK, new TransitionResult<MySymbol>(s4, MySymbol.BLANK, Direction.RIGHT));
    s0.transitions.put(MySymbol.A, new TransitionResult<MySymbol>(s1, MySymbol.BLANK, Direction.RIGHT));
    s4.transitions.put(MySymbol.BLANK, new TransitionResult<MySymbol>(s5, MySymbol.BLANK, Direction.RIGHT));
    s1.transitions.put(MySymbol.A, new TransitionResult<MySymbol>(s1, MySymbol.A, Direction.RIGHT));
    s1.transitions.put(MySymbol.B, new TransitionResult<MySymbol>(s1, MySymbol.B, Direction.RIGHT));
    s1.transitions.put(MySymbol.BLANK, new TransitionResult<MySymbol>(s2, MySymbol.BLANK, Direction.LEFT));
    s2.transitions.put(MySymbol.B, new TransitionResult<MySymbol>(s3, MySymbol.BLANK, Direction.LEFT));
    s3.transitions.put(MySymbol.A, new TransitionResult<MySymbol>(s3, MySymbol.A, Direction.LEFT));
    s3.transitions.put(MySymbol.B, new TransitionResult<MySymbol>(s3, MySymbol.B, Direction.LEFT));
    s3.transitions.put(MySymbol.BLANK, new TransitionResult<MySymbol>(s0, MySymbol.BLANK, Direction.RIGHT));

    TuringMachine<MySymbol> machine = new TuringMachine<MySymbol>(s0, MySymbol.BLANK);

    if (args.length < 1) {
      System.err.println("Syntax: java TuringSimulator <input string>");
      System.exit(-1);
    }
    List<MySymbol> input = MySymbol.parseString(args[0]);
    TuringSimulator<MySymbol> sim = new TuringSimulator<MySymbol>(machine, input);
    sim.run();
  }

  public void run() {
    trace();
    while (!controlState.accepting) {
      TransitionResult<Symbol> next = controlState.transitions.get(currentSymbol());
      if (next == null) {
        System.out.println("invalid transition");
        break;
      }
      update(next.controlState, next.dir, next.writeSymbol);
      trace();
    }
  }

  public void trace() {
    for (int i = -17; i < TRACE_TAPE_CHARS; i++) {
      if (i >= headPosition) {
        System.out.print("v"); // points down
        break;
      }
      System.out.print(" ");
    }
    System.out.println();

    System.out.printf("%15s: ", controlState);

    for (int i = 0; i < TRACE_TAPE_CHARS; i++) {
      System.out.print(tapeAt(i));
    }
    System.out.println();
  }

  public Symbol currentSymbol() {
    return tapeAt(headPosition);
  }

  public void update(ControlState<Symbol> newControlState, Direction dir, Symbol writeSymbol) {
    controlState = newControlState;
    if (headPosition < tape.size())
      tape.set(headPosition, writeSymbol);
    else
      if (headPosition == tape.size())
        tape.add(writeSymbol);
      else
        assert false;

    switch (dir) {
      case LEFT:
        assert headPosition > 0;
        headPosition--;
        break;
      case RIGHT:
        headPosition++;
        break;
    }
  }

  public Symbol tapeAt(int pos) {
    return (pos < tape.size()) ? tape.get(pos) : machine.blankSymbol;
  }
}
