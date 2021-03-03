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

Retrieved from: http://en.literateprograms.org/POS_tagger_(Java)?oldid=16733
*/

import java.util.Map;

abstract class AbstractHMM {
  protected String a;
  protected int n;
  protected String obsA;
  protected String obs;
  protected double[][] A;
  protected double[][] B;
  protected String mostProbableSequence;

  public AbstractHMM(String a, String obsA, String obs, Map<String, String> lexicon, String corpus) {
    MatrixGenerator gen = new MatrixGenerator(lexicon, corpus, a);
    this.a = a;
    this.n = obs.length();
    this.obsA = obsA;
    this.obs = obs;
    this.A = gen.createMatrixA(0.01);
    this.B = gen.createMatrixB();
  }

  public abstract String mostProbableSequence();
}
