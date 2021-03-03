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

Retrieved from: http://en.literateprograms.org/Nth_element_(Java)?oldid=15027
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QNth {
  public static <T extends Comparable<? super T>> T qnth(List<T> sample, int n) {
    T pivot = sample.get(0);
    List<T> below = new ArrayList<T>(), above = new ArrayList<T>();
    for (T s : sample) {
      if (s.compareTo(pivot) < 0)
        below.add(s);
      else
        if (s.compareTo(pivot) > 0)
          above.add(s);
    }
    int i = below.size(), j = sample.size() - above.size();

    if (n < i)
      return qnth(below, n);
    else
      if (n >= j)
        return qnth(above, n - j);
      else
        return pivot;
  }

  public static void main(String[] args) {
    int n = 64, mid = 32;
    List<Double> sample = new ArrayList<Double>();
    for (int i = 0; i < n; i++)
      sample.add(Math.random());
    double partial = qnth(sample, mid);
    Collections.sort(sample);
    double sorted = sample.get(mid);
    System.out.println("" + partial + " " + sorted + " " + (partial == sorted));
  }
}
