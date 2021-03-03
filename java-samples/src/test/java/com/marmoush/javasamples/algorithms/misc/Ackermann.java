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

Retrieved from: http://en.literateprograms.org/Ackermann_function_(Java)?oldid=16642
*/

import java.math.BigInteger;

public class Ackermann {

  private static BigInteger calls;

  static BigInteger naiveAckermann(BigInteger m, BigInteger n) {
    calls = calls.add(BigInteger.ONE);
    if (m.signum() == 0)
      return n.add(BigInteger.ONE);
    else
      if (n.signum() == 0)
        return naiveAckermann(m.subtract(BigInteger.ONE), BigInteger.ONE);
      else
        return naiveAckermann(m.subtract(BigInteger.ONE), naiveAckermann(m, n.subtract(BigInteger.ONE)));
  }

  static BigInteger iterativeAckermann(BigInteger m, BigInteger n) {
    calls = calls.add(BigInteger.ONE);
    while (m.signum() != 0) {
      if (n.signum() == 0) {
        n = BigInteger.ONE;
      } else {
        n = iterativeAckermann(m, n.subtract(BigInteger.ONE));
      }
      m = m.subtract(BigInteger.ONE);
    }
    return n.add(BigInteger.ONE);
  }

  static BigInteger formulaAckermann(BigInteger m, BigInteger n) {
    calls = calls.add(BigInteger.ONE);
    BigInteger TWO = BigInteger.valueOf(2);
    BigInteger THREE = BigInteger.valueOf(3);
    BigInteger FOUR = BigInteger.valueOf(4);
    while (m.compareTo(FOUR) >= 0) {
      if (n.signum() == 0) {
        n = BigInteger.ONE;
      } else {
        n = formulaAckermann(m, n.subtract(BigInteger.ONE));
      }
      m = m.subtract(BigInteger.ONE);
    }
    switch (m.intValue()) {
      case 0:
        return n.add(BigInteger.ONE);
      case 1:
        return n.add(TWO);
      case 2:
        return n.shiftLeft(1).add(THREE);
      default:
        return BigInteger.ONE.shiftLeft(n.intValue() + 3).subtract(THREE);
    }
  }

  public static void main(String[] args) {
    BigInteger m, n, result;
    m = new BigInteger(args[0]);
    n = new BigInteger(args[1]);

    calls = BigInteger.ZERO;
    result = naiveAckermann(m, n);
    System.out.println("Naive:     " + result + " (" + calls + " calls)");

    calls = BigInteger.ZERO;
    result = iterativeAckermann(m, n);
    System.out.println("Iterative: " + result + " (" + calls + " calls)");

    calls = BigInteger.ZERO;
    result = formulaAckermann(m, n);
    System.out.println("Formula:   " + result + " (" + calls + " calls)");
  }
}
