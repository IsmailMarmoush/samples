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

public class FibonacciIterative {
  public static void main(String[] args) {
    for (int i = 0; i <= 46; i++)
      System.out.print(fib(i) + ", ");
  }

  public static int fib(int n) {
    int prev1 = 0, prev2 = 1;
    for (int i = 0; i < n; i++) {
      int savePrev1 = prev1;
      prev1 = prev2;
      prev2 = savePrev1 + prev2;
    }
    return prev1;
  }
}
