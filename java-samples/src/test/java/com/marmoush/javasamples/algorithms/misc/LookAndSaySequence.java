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

Retrieved from: http://en.literateprograms.org/Look_and_say_sequence_(Java)?oldid=12074
*/

import java.util.Arrays;

public class LookAndSaySequence {
  public static void main(String[] args) {
    String[] seq = look_and_say("3", 10);
    System.out.println(Arrays.toString(seq));
  }

  public static String[] look_and_say(String seed, int len) {
    String[] seq = new String[len];
    seq[0] = seed;

    for (int i = 1; i < len; i++) {
      String val = seq[i - 1];

      StringBuilder nextval = new StringBuilder();
      for (int ix = 0; ix < val.length(); ) {
        char ch = val.charAt(ix);
        int n;
        for (n = 1; ++ix < val.length() && val.charAt(ix) == ch; n++)
          ;
        nextval.append(n).append(ch);
      }
      seq[i] = nextval.toString();
    }

    return seq;
  }
}
