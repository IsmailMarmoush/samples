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

Retrieved from: http://en.literateprograms.org/Counting_sort_(Java)?oldid=11981
*/

import java.util.Arrays;
import java.util.Random;

public class CountingSort {
  public static void main(String[] args) {
    int listSize = Integer.parseInt(args[0]);
    int numValues = Integer.parseInt(args[1]);

    // Generate list of random values
    int[] a = new int[listSize];
    Random r = new Random();
    for (int i = 0; i < a.length; i++) {
      a[i] = r.nextInt(numValues);
    }

    // Copy list to new array
    int[] a2 = new int[listSize];
    System.arraycopy(a, 0, a2, 0, listSize);

    // Sort the two arrays
    sort(a);
    Arrays.sort(a2);

    // Compare the two arrays
    for (int i = 0; i < listSize; i++) {
      if (a[i] != a2[i]) {
        System.out.println("Error: Results do not match.");
        return;
      }
    }
    System.out.println("Sort successful");
  }

  /* Sorts array a where each element is between 0 and numValues-1. */
  public static void sort(int[] a) {
    if (a.length == 0)
      return;

    int max = a[0], min = a[0];
    for (int i = 1; i < a.length; i++) {
      if (a[i] > max)
        max = a[i];
      else
        if (a[i] < min)
          min = a[i];
    }
    int numValues = max - min + 1;
    int[] counts = new int[numValues];
    for (int i = 0; i < a.length; i++) {
      counts[a[i] - min]++;
    }
    int outputPos = 0;
    for (int i = 0; i < numValues; i++) {
      for (int j = 0; j < counts[i]; j++) {
        a[outputPos] = i + min;
        outputPos++;
      }
    }
  }
}
