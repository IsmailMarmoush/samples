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

Retrieved from: http://en.literateprograms.org/Quicksort_(Java)?oldid=16417
*/

public class Quicksort {

  static <T extends Comparable<? super T>> void quicksort(T[] array) {

    quicksort(array, 0, array.length - 1);
  }

  static <T extends Comparable<? super T>> void quicksort(T[] array, int left0, int right0) {

    int left = left0;
    int right = right0 + 1;
    T pivot, temp;

    pivot = array[left0];

    do {

      do
        left++;
      while (left <= right0 && array[left].compareTo(pivot) < 0);

      do
        right--;
      while (array[right].compareTo(pivot) > 0);

      if (left < right) {
        temp = array[left];
        array[left] = array[right];
        array[right] = temp;
      }
    }
    while (left <= right);

    temp = array[left0];
    array[left0] = array[right];
    array[right] = temp;

    if (left0 < right)
      quicksort(array, left0, right);
    if (left < right0)
      quicksort(array, left, right0);
  }

  public void integerSorting() {

    Integer[] array = {5, 3, 4, 2, 1};
    quicksort(array);
    Integer[] correct = {1, 2, 3, 4, 5};
    //        assertArrayEquals(correct, array);

  }

  //    @Test
  public void floatSorting() {
    Float[] array = {1.8F, 3.6F, 4F, 5F, 2F};
    quicksort(array);
    Float[] correct = {1.8F, 2F, 3.6F, 4F, 5F};
    //        assertArrayEquals(correct, array);
  }

  public void stringSorting() {
    String[] array = {"Batman", "Spiderman", "Anthony", "Zoolander"};
    quicksort(array);
    String[] correct = {"Anthony", "Batman", "Spiderman", "Zoolander"};
    //        assertArrayEquals(correct, array);
  }
}
