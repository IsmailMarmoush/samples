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

Retrieved from: http://en.literateprograms.org/Binary_search_(Java)?oldid=19020
*/

import java.util.List;

public class BinarySearch {
  static <T extends Comparable<? super T>> int search(T value, List<T> values) {
    int n = values.size();
    int mid, left, right;
    T midVal;
    left = 0;
    right = n - 1;

    do {
      mid = (left + right) / 2;
      midVal = values.get(mid);
      if (value.compareTo(values.get(mid)) < 0)
        right = mid - 1;
      else
        if (value.compareTo(values.get(mid)) > 0)
          left = mid + 1;
        else
          return mid;
    }
    while (left <= right);

    return (value.compareTo(midVal) < 0) ? -mid : -(mid + 1);
  }

  //    @Test
  //    public void testStringSearch() {
  //
  //        assertEquals(-1, BinarySearch.search("Billy", arrays.asList("Anny", "Emmy", "Grammy")));
  //    }
  //
  //    @Test
  //    public void testIntegerSearch() {
  //
  //        assertEquals(-1, BinarySearch.search(2, arrays.asList(1, 3, 4)));
  //    }
}
