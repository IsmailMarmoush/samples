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

Retrieved from: http://en.literateprograms.org/Permutations_with_repetition_(Java)?oldid=11971
*/

import java.util.ArrayList;
import java.util.List;

public class PermutationsWithRepetition {
  private String a;
  private int n;

  public PermutationsWithRepetition(String a, int n) {
    this.a = a;
    this.n = n;
  }

  public static void main(String[] args) {

    PermutationsWithRepetition gen = new PermutationsWithRepetition("abc", 3);
    List<String> v = gen.getVariations();
    for (String s : v) {
      System.out.println(s);
    }
  }

  public List<String> getVariations() {
    int l = a.length();
    int permutations = (int) Math.pow(l, n);
    char[][] table = new char[permutations][n];

    for (int x = 0; x < n; x++) {
      int t2 = (int) Math.pow(l, x);
      for (int p1 = 0; p1 < permutations; ) {
        for (int al = 0; al < l; al++) {
          for (int p2 = 0; p2 < t2; p2++) {
            table[p1][x] = a.charAt(al);
            p1++;
          }
        }
      }
    }

    List<String> result = new ArrayList<String>();
    for (char[] permutation : table) {
      result.add(new String(permutation));
    }
    return result;
  }
}
