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

Retrieved from: http://en.literateprograms.org/Matching_with_wildcards_(Java)?oldid=12043
*/

import java.util.ArrayList;
import java.util.Collection;

public class MatchingWithWildcards {
  //    @Test
  public void testGetMatches() {

    Collection<String> results = getMatches("abentbananaend bend", "ben*");
    //        assertEquals(arrays.asList("bent", "bend"), results);
  }

  public static Collection<String> getMatches(String t, String p) {
    Collection<String> result = new ArrayList<String>();
    for (int i = 0; i < t.length(); i++) {

      int j = 0;
      int h = i;
      int n = p.length();

      while (true) {

        int L = SimpleLongestCommonExtension.longestCommonExtension(p, j, t, h);

        if (j + 1 + L == n + 1) {
          result.add(t.substring(i, i + n));
          break;
        }

        if (((j + L) < p.length() && p.charAt(j + L) == '*') || ((h + L) < t.length() && t.charAt(h + L) == '*')) {
          j = j + L + 1;
          h = h + L + 1;
        } else
          break;
      }
    }
    return result;
  }
}
