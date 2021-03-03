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

Retrieved from: http://en.literateprograms.org/Insertion_sort_(Java)?oldid=19164
*/

import java.util.Comparator;
import java.util.Random;

class InsertionSort14 {
  public static void insertionSort(Object[] a) {
    for (int i = 0; i < a.length; i++) {
      /* Insert a[i] into the sorted sublist */
      Object v = a[i];
      int j;
      for (j = i - 1; j >= 0; j--) {
        if (((Comparable) a[j]).compareTo(v) <= 0)
          break;
        a[j + 1] = a[j];
      }
      a[j + 1] = v;
    }
  }

  public static void insertionSort(Object[] a, Comparator c) {
    for (int i = 0; i < a.length; i++) {
      /* Insert a[i] into the sorted sublist */
      Object v = a[i];
      int j;
      for (j = i - 1; j >= 0; j--) {
        if (c.compare(a[j], v) <= 0)
          break;
        a[j + 1] = a[j];
      }
      a[j + 1] = v;
    }
  }

  public static void main(String[] args) {
    int size = Integer.parseInt(args[0]);
    Random rand = new Random();
    int[] a = new int[size];
    for (int i = 0; i < size; i++) {
      a[i] = rand.nextInt(size);
    }
    insertionSort(a);
    for (int i = 1; i < size; i++) {
      if (a[i] < a[i - 1]) {
        System.out.println("ERROR");
      }
    }
  }

  public static void insertionSort(int[] a) {
    for (int i = 0; i < a.length; i++) {
      /* Insert a[i] into the sorted sublist */
      int v = a[i];
      int j;
      for (j = i - 1; j >= 0; j--) {
        if (a[j] <= v)
          break;
        a[j + 1] = a[j];
      }
      a[j + 1] = v;
    }
  }
}
