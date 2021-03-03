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

Retrieved from: http://en.literateprograms.org/Levenshtein_distance_(Java)?oldid=18625
*/

public class EditDistance {
  public static void main(String[] args) {
    EditDistance distance = new EditDistance();
    System.out.println(distance.compute("vintner", "writers"));
    System.out.println(distance.compute("vintners", "writers"));
    System.out.println(distance.compute("vintners", ""));
    System.out.println(distance.compute("", ""));
  }

  public int compute(String s1, String s2) {
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        dp[i][j] = i == 0 ? j : j == 0 ? i : 0;
        if (i > 0 && j > 0) {
          if (s1.charAt(i - 1) == s2.charAt(j - 1))
            dp[i][j] = dp[i - 1][j - 1];
          else
            dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1));
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }
}
