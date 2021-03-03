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

Retrieved from: http://en.literateprograms.org/Subarray_with_Sum_Divisible_by_Length_of_Array_(Java)?oldid=12497
*/

import java.util.Arrays;

public class SubarraySumDivisible {
  public static void main(String[] args) {
    // TODO: parse this from the user or generate randomly
    int[] a = {63, 92, 51, 92, 39, 15, 43, 89, 36, 69, 40, 16, 23, 2, 29, 91, 57, 43, 55, 22};
    computeSubarray(a);
  }

  public static void computeSubarray(int[] a) {
    int[] b = new int[a.length + 1];
    b[0] = 0;
    for (int i = 0; i < a.length; i++)
      b[i + 1] = (b[i] + a[i]) % a.length;
    int[] c = new int[a.length];
    Arrays.fill(c, -1);
    for (int i = 0; i < b.length; i++) {
      int pos = b[i];
      if (c[pos] < 0)
        c[pos] = i;
      else {
        int begin = c[pos], end = i;
        int sum = 0;
        for (int j = begin; j < end; j++)
          sum += a[j];

        System.out.println("found solution: subarray from index " + begin + " (inclusive) to " + end + " (exclusive)");
        System.out.println("has sum = " + sum + ", which is divisible by length of array " + a.length);

        return;
      }
    }
    // you are not supposed to get here
    System.err.println("You broke math.");
    System.exit(1);
  }
}
