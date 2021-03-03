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

Retrieved from: http://en.literateprograms.org/Finite_automaton_string_search_algorithm_(Java)?oldid=14960
*/

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class State<E> {
  private static int nextStateNum = 0;
  public final BitSet positions;
  public final Map<E, State<E>> transitions = new HashMap<E, State<E>>();
  private final int num = nextStateNum++;
  public boolean finale;

  public State(BitSet bs) {
    positions = bs;
  }

  public String toString() {
    return Integer.toString(num);
  }
}

public class DFAStringSearch<E> {
  // maps the set of string positions a state represents to the state
  private final Map<BitSet, State<E>> stateMap = new HashMap<BitSet, State<E>>();
  // list of states in order of creation
  private final List<State<E>> states = new ArrayList<State<E>>();

  public State<E> initialState;

  public DFAStringSearch(E[] pattern) {
    BitSet initialPos = new BitSet();
    initialPos.set(0);
    initialState = getState(initialPos);
    for (int i = 0; i < states.size(); i++) {
      State<E> s = states.get(i);
      for (int j = s.positions.nextSetBit(0); j >= 0; j = s.positions.nextSetBit(j + 1)) {
        if (j == pattern.length) {
          s.finale = true;
          break;
        }
        E cNext = pattern[j];
        if (!s.transitions.containsKey(cNext))
          fillTransitionTableEntry(pattern, s, cNext);
      }
    }
  }

  public State<E> getState(BitSet s) {
    if (stateMap.containsKey(s))
      return stateMap.get(s);
    else {
      State<E> st = new State<E>(s);
      stateMap.put(s, st);
      states.add(st);
      return st;
    }
  }

  private void fillTransitionTableEntry(E[] pattern, State<E> s, E cNext) {
    BitSet newPositions = new BitSet();
    newPositions.set(0);
    for (int i = s.positions.nextSetBit(0); i >= 0 && i < pattern.length; i = s.positions.nextSetBit(i + 1)) {
      if (pattern[i].equals(cNext))
        newPositions.set(i + 1);
    }
    s.transitions.put(cNext, getState(newPositions));
    System.err.println("Adding edge " + s + " -" + cNext + "-> " + s.transitions.get(cNext));
  }

  public static void main(String[] args) {
    Character[] a = str2charArray(args[0]), b = str2charArray(args[1]);
    DFAStringSearch<Character> foo = new DFAStringSearch<Character>(a);
    int result = foo.search(a, b);
    if (result == -1)
      System.out.println("No match found.");
    else {
      System.out.println("Matched at position " + result + ":");
      System.out.println(args[1].substring(0, result) + "|" + args[1].substring(result));
    }
  }

  private static Character[] str2charArray(String str) {
    Character[] result = new Character[str.length()];
    for (int i = 0; i < str.length(); i++)
      result[i] = str.charAt(i);
    return result;
  }

  public int search(E[] searchFor, E[] searchIn) {
    State<E> curState = initialState;
    int curPos;
    for (curPos = 0; curPos < searchIn.length && !curState.finale; curPos++) {
      curState = curState.transitions.get(searchIn[curPos]);
      if (curState == null)
        curState = initialState;
    }
    if (curState.finale)
      return curPos - searchFor.length;
    else
      return -1;
  }
}
