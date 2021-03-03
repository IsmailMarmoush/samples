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

Retrieved from: http://en.literateprograms.org/Bubble_sort_(Java)?oldid=19026
*/

import java.util.Random;

class BubbleSortExample {
  public static <T extends Comparable<? super T>> void bubble_sort_generic(T[] array) {
    int right_border = array.length - 1;

    do {
      int last_exchange = 0;

      for (int i = 0; i < right_border; i++) {
        if (array[i].compareTo(array[i + 1]) > 0) {
          T temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;

          last_exchange = i;
        }
      }

      right_border = last_exchange;
    }
    while (right_border > 0);
  }

  public static void main(String[] args) {
    // create test array and fill it with random values
    int[] array = new int[1024];
    Random rnd = new Random();
    for (int i = 0; i < array.length; i++)
      array[i] = rnd.nextInt();

    // sort our array
    bubble_sort(array);

    // check if it really sorted now
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i] > array[i + 1]) {
        System.out.println("something wrong");
        return;
      }
    }

    System.out.println("array sorted");
  }

  public static void bubble_sort(int[] array) {
    int right_border = array.length - 1;

    do {
      int last_exchange = 0;

      for (int i = 0; i < right_border; i++) {
        if (array[i] > array[i + 1]) {
          int temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;

          last_exchange = i;
        }
      }

      right_border = last_exchange;
    }
    while (right_border > 0);
  }
}
