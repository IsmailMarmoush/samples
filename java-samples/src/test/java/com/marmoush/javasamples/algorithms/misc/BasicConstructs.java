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

Retrieved from: http://en.literateprograms.org/Basic_constructs_(Java)?oldid=13238
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BasicConstructs {

  public static void main(String[] args) throws Exception {
    BasicConstructs bc = new BasicConstructs();

    if (args.length < 1) {
      System.err.println("ERROR: Wrong number of arguments");
      bc.usage();
    }

    for (int i = 0; i < args.length; i++) {
      if ("loops".equals(args[i]))
        bc.loops();
      else
        if ("io".equals(args[i]))
          bc.io();
        else {
          System.err.println("ERROR: Unexpected command line argument: " + args[i]);
          bc.usage();
        }
    }

    System.exit(0);
  }

  private void usage() {
    System.err.println("Usage java BasicConstructs loops|io");
    System.exit(1);
  }

  public void loops() {
    System.out.println("For loop");
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
    }
    System.out.println();

    System.out.println("While loop");
    int j = 0;
    while (j < 10) {
      System.out.println(j);
      j++;
    }
    System.out.println();

    System.out.println("Do-while loop");
    int k = 0;
    do {
      System.out.println(k);
      k++;
    }
    while (k < 10);
    System.out.println();
  }

  void io() throws IOException {
    String line = null;

    System.out.println("Standard I/O");
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Type a line of text (enter with Return): ");
    line = in.readLine();
    System.out.println("You entered: " + line);
    System.out.println();

    try {
      BufferedReader fin = new BufferedReader(new FileReader("input.txt"));
      line = fin.readLine();
      if (line == null)
        throw new EOFException("Unexpected End of File encountered while reading \"input.txt\"");
      fin.close();
    } catch (IOException e) {
      System.err.println("ERROR: Cannot read \"input.txt\"");
      throw e;
    }

    try {
      PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
      fout.println(line);
      fout.close();
    } catch (IOException e) {
      System.err.println("ERROR: Cannot write to \"output.txt\"");
      throw e;
    }
  }
}
