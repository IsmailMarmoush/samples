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

Retrieved from: http://en.literateprograms.org/Miller-Rabin_primality_test_(Java)?oldid=17585
*/

public class MillerRabin32 {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    System.out.println(miller_rabin_32(n) ? "PRIME" : "COMPOSITE");
  }

  public static boolean miller_rabin_32(int n) {
    if (n <= 1)
      return false;
    else
      if (n == 2)
        return true;
      else
        if (miller_rabin_pass_32(2, n) && (n <= 7 || miller_rabin_pass_32(7, n)) &&
            (n <= 61 || miller_rabin_pass_32(61, n)))
          return true;
        else
          return false;
  }

  private static boolean miller_rabin_pass_32(int a, int n) {
    int d = n - 1;
    int s = Integer.numberOfTrailingZeros(d);
    d >>= s;
    int a_to_power = modular_exponent_32(a, d, n);
    if (a_to_power == 1)
      return true;
    for (int i = 0; i < s - 1; i++) {
      if (a_to_power == n - 1)
        return true;
      a_to_power = modular_exponent_32(a_to_power, 2, n);
    }
    if (a_to_power == n - 1)
      return true;
    return false;
  }

  private static int modular_exponent_32(int base, int power, int modulus) {
    long result = 1;
    for (int i = 31; i >= 0; i--) {
      result = (result * result) % modulus;
      if ((power & (1 << i)) != 0) {
        result = (result * base) % modulus;
      }
    }
    return (int) result; // Will not truncate since modulus is an int
  }
}
