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

Retrieved from: http://en.literateprograms.org/Longest_common_extension_(Java)?oldid=12080
*/

public class SimpleLongestCommonExtension {

  public void testGetLongestCommonExtension() {
    int res = longestCommonExtension("zsdabcdefghj", 3, "abcdezas", 0);
    //        assertEquals(5, res);
  }

  public static int longestCommonExtension(String t1, int i1, String t2, int i2) {
    int res = 0;
    for (int i = i1; i < t1.length() && i2 < t2.length(); i++, i2++) {
      if (t1.charAt(i) == t2.charAt(i2))
        res++;
      else
        return res;
    }
    return res;
  }
}
