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

Retrieved from: http://en.literateprograms.org/Rot13_(Java)?oldid=19204
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rot13 {

  public static void main(String[] args) throws IOException {

    String input = ""; // data to be encoded

    if (args.length <= 3) {
      int argNumber = 0;
      while (argNumber < args.length) {
        if ("-e".equals(args[argNumber])) {
          argNumber++;
          input = args[argNumber];
          argNumber++;
        } else
          if ("-h".equals(args[argNumber])) {
            System.err.println(usage());
            System.exit(0);
          } else {
            System.err.println("Error: unexpected argument " + args[argNumber]);
            System.err.println(usage());
            System.exit(1);
          }
      }
    } else {
      System.err.println("Error: Too many arguments.\n" + usage());
      System.exit(1);
    }

    if (input.length() == 0) {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String s;
      while ((s = in.readLine()) != null) {
        input += s + "\n";
      }
    }

    System.out.println(encode(input));

    System.exit(0);
  }

  private static String usage() {
    return "Usage: java -cp cyphers.jar uk.literateprograms.cyphers.Rot13 [-h] [-e \"text to be encoded\"] [< plaintext] [> cyphertext]\n" +
           "where arguments are:\n" + "-e encode text on the command line\n" + "-h print this message";
  }

  /**
   * Encode plain text using the Rot13 algorithm.
   *
   * @param plainText the plain text message.
   * @return the plain text message encoded using the Rot13 algorithm.
   */
  public static String encode(String plainText) {
    // deal with the case that method is called with null argument
    String encodedMessage = "";
    if (plainText == null)
      return plainText;
    for (int i = 0; i < plainText.length(); i++) {
      char c = plainText.charAt(i);
      if (c >= 'a' && c <= 'm')
        c += 13;
      else
        if (c >= 'n' && c <= 'z')
          c -= 13;
        else
          if (c >= 'A' && c <= 'M')
            c += 13;
          else
            if (c >= 'N' && c <= 'Z')
              c -= 13;

      encodedMessage += c;
    }
    return encodedMessage;
  }
}
