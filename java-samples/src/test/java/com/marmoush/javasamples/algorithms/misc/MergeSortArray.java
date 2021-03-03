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

Retrieved from: http://en.literateprograms.org/Merge_sort_(Java)?oldid=18559
*/

class MergeSortArray {
  private static final int minMergeSortListSize = 60;

  public static void mergeSortArray(int[] a, int start, int end) {
    int[] temp = new int[end - start];
    int i1, i2, tempi, middle;

    if ((end - start) < minMergeSortListSize) {
      /* Use insertion sort for small datasets. */
      for (int i = start; i < end; i++) {
        int j, v = a[i];
        for (j = i - 1; j >= start && a[j] > v; j--)
          a[j + 1] = a[j];
        a[j + 1] = v;
      }
      return;
    }
    middle = start + (end - start) / 2;
    mergeSortArray(a, start, middle);
    mergeSortArray(a, middle, end);
    i1 = start;
    i2 = middle;
    tempi = 0;
    while (i1 < middle && i2 < end)
      if (a[i1] <= a[i2])
        temp[tempi++] = a[i1++];
      else
        temp[tempi++] = a[i2++];
    while (i1 < middle)
      temp[tempi++] = a[i1++];
    while (i2 < end)
      temp[tempi++] = a[i2++];
    System.arraycopy(temp, 0, a, start, end - start);
  }

  public static void main(String[] argv) {
    int size = Integer.parseInt(argv[0]);
    int[] a = new int[size];
    java.util.Random rand = new java.util.Random(System.currentTimeMillis());
    for (int i = 0; i < size; i++) {
      a[i] = rand.nextInt() % size;
    }
    mergeSortArray(a, 0, size);
    for (int i = 1; i < size; i++) {
      if (!(a[i - 1] <= a[i])) {
        System.out.println("ERROR");
        System.exit(-1);
      }
    }
    System.out.println("SUCCESS");
    System.exit(0);
  }
}
