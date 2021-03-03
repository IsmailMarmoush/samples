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

Retrieved from: http://en.literateprograms.org/Euclidean_algorithm_(Java,_recursive)?oldid=16782
*/

public class Euclid {
  public static long gcd(long a, long b) {
    if (b == 0)
      return a;
    else
      return gcd(b, a % b);
  }

  public static void main(String[] args) {
    long n0 = Long.parseLong(args[0]);
    long n1 = Long.parseLong(args[1]);

    long res;
    if (n0 > n1)
      res = gcd(n0, n1);
    else
      if (n1 > n0)
        res = gcd(n1, n0);
      else
        res = n0;

    System.out.println(res);
  }
}
