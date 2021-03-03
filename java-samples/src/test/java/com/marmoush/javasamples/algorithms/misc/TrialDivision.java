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

Retrieved from: http://en.literateprograms.org/Trial_division_(Java)?oldid=19223
*/

import java.util.BitSet;

class TrialDivision {

  public static final int IS_PRIME = 0;
  static int[] primes;

  public static void main(String[] args) {
    long n = Long.parseLong(args[1]);
    if (n <= 0) {
      System.out.println("Please enter only positive integers.");
    } else
      if (args[0].equals("TrialDivisionSqrt")) {
        for (int i = 0; i < 10000 - 1; i++)
          trialDivisionSqrt((int) n);
        System.out.println(trialDivisionSqrt((int) n));
      } else
        if (args[0].equals("TrialDivisionSquaring")) {
          for (int i = 0; i < 10000 - 1; i++)
            trialDivisionSquaring((int) n);
          System.out.println(trialDivisionSquaring((int) n));
        } else
          if (args[0].equals("TrialDivisionOdd")) {
            for (int i = 0; i < 10000 - 1; i++)
              trialDivisionOdd((int) n);
            System.out.println(trialDivisionOdd((int) n));
          } else
            if (args[0].equals("TrialDivisionPrimes")) {
              generatePrimeList(65536);
              for (int i = 0; i < 10000 - 1; i++)
                trialDivisionPrimes((int) n);
              System.out.println(trialDivisionPrimes((int) n));
            } else
              if (args[0].equals("TrialDivisionPrimesLong")) {
                generatePrimeList(Integer.MAX_VALUE / 2);
                for (int i = 0; i < 10000 - 1; i++)
                  trialDivisionPrimesLong(n);
                System.out.println(trialDivisionPrimesLong(n));
              } else {
                System.out.println("Invalid algorithm selection.");
              }
  }

  public static int trialDivisionSqrt(int n) {
    int sqrtN = (int) Math.sqrt((double) n);
    for (int x = 2; x <= sqrtN; x++) {
      if (n % x == 0) {
        return x;
      }
    }
    return IS_PRIME;
  }

  static int trialDivisionSquaring(int n) {
    for (int x = 2, xSquared = 4; xSquared > 2 * x - 1 && xSquared <= n; x++, xSquared += 2 * x - 1) {
      if (n % x == 0) {
        return x;
      }
    }
    return IS_PRIME;
  }

  public static int trialDivisionOdd(int n) {
    int sqrtN = (int) Math.sqrt((double) n);
    if (n % 2 == 0)
      return 2;
    for (int x = 3; x <= sqrtN; x += 2) {
      if ((n % x) == 0) {
        return x;
      }
    }
    return IS_PRIME;
  }

  private static void generatePrimeList(int max) {
    BitSet isNotPrime = new BitSet(max + 1);
    int numPrimes = 1;
    for (int i = 2; i <= max; i++) {
      if (!isNotPrime.get(i)) {
        numPrimes++;
        for (int j = i + i; j <= max; j += i) {
          isNotPrime.set(j);
        }
      }
    }
    primes = new int[numPrimes];
    int j = 0;
    for (int i = 2; i <= max; i++) {
      if (!isNotPrime.get(i)) {
        primes[j] = i;
        j++;
      }
    }
  }

  public static int trialDivisionPrimes(int n) {
    int sqrtN = (int) Math.sqrt((double) n);
    for (int primeIdx = 0; primeIdx < primes.length && primes[primeIdx] <= sqrtN; primeIdx++) {
      if (n % primes[primeIdx] == 0) {
        return primes[primeIdx];
      }
    }
    return IS_PRIME;
  }

  public static int trialDivisionPrimesLong(long n) {
    long maxPrime = primes[primes.length - 1];
    if (maxPrime * maxPrime > n) {
      throw new IllegalArgumentException("Cannot factor numbers larger than " + maxPrime * maxPrime);
    }
    long sqrtN = sqrt(n);
    for (int primeIdx = 0; primeIdx < primes.length && primes[primeIdx] <= sqrtN; primeIdx++) {
      if (n % primes[primeIdx] == 0) {
        return primes[primeIdx];
      }
    }
    return IS_PRIME;
  }

  public static long sqrt(long n) {
    long guess = 2, prev_guess = 0, prev2_guess = 0;
    while (guess != prev_guess && guess != prev2_guess) {
      prev2_guess = prev_guess;
      prev_guess = guess;
      guess = (guess + n / guess) / 2;
    }
    return Math.min(guess, prev_guess);
  }
}
