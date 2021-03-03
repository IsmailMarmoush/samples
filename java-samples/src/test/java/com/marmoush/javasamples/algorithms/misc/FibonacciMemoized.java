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

Retrieved from: http://en.literateprograms.org/Fibonacci_numbers_(Java)?oldid=18538
*/

import java.math.BigInteger;
import java.util.ArrayList;

public class FibonacciMemoized {

  private static ArrayList<BigInteger> fibCache = new ArrayList<BigInteger>();

  static {
    fibCache.add(BigInteger.ZERO);
    fibCache.add(BigInteger.ONE);
  }

  public static BigInteger fib(int n) {
    if (n >= fibCache.size()) {
      fibCache.add(n, fib(n - 1).add(fib(n - 2)));
    }
    return fibCache.get(n);
  }

  public static void main(String[] args) {
    for (int i = 0; i <= 46; i++)
      System.out.print(fib(i) + ", ");
  }
}
