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

Retrieved from: http://en.literateprograms.org/Selection_sort_(Java)?oldid=11987
*/

import java.util.Comparator;
import java.util.Random;

class SelectionSortExample {
  public static <T extends Comparable<? super T>> void selectionSortGeneric(T[] a) {
    for (int sortedSize = 0; sortedSize < a.length; sortedSize++) {
      int minElementIndex = sortedSize;
      T minElementValue = a[sortedSize];
      for (int i = sortedSize + 1; i < a.length; i++) {
        if (a[i].compareTo(minElementValue) < 0) {
          minElementIndex = i;
          minElementValue = a[i];
        }
      }
      a[minElementIndex] = a[sortedSize];
      a[sortedSize] = minElementValue;
    }
  }

  public static <T> void selectionSortGeneric(T[] a, Comparator<? super T> comparer) {
    for (int sortedSize = 0; sortedSize < a.length; sortedSize++) {
      int minElementIndex = sortedSize;
      T minElementValue = a[sortedSize];
      for (int i = sortedSize + 1; i < a.length; i++) {
        if (comparer.compare(a[i], minElementValue) < 0) {
          minElementIndex = i;
          minElementValue = a[i];
        }
      }
      a[minElementIndex] = a[sortedSize];
      a[sortedSize] = minElementValue;
    }
  }

  public static void main(String[] args) {
    int length = Integer.parseInt(args[0]);
    int[] a = new int[length];
    Random r = new Random();

    for (int i = 0; i < length; i++) {
      a[i] = r.nextInt();
    }

    long start = System.currentTimeMillis();
    selectionSortIntArray(a);
    System.out.println("Sort time in ms: " + (System.currentTimeMillis() - start));

    for (int i = 1; i < length; i++) {
      if (a[i] < a[i - 1]) {
        System.out.println("ERROR");
        return;
      }
    }
  }

  public static void selectionSortIntArray(int[] a) {
    for (int sortedSize = 0; sortedSize < a.length; sortedSize++) {
      int minElementIndex = sortedSize;
      int minElementValue = a[sortedSize];
      for (int i = sortedSize + 1; i < a.length; i++) {
        if (a[i] < minElementValue) {
          minElementIndex = i;
          minElementValue = a[i];
        }
      }
      a[minElementIndex] = a[sortedSize];
      a[sortedSize] = minElementValue;
    }
  }
}
