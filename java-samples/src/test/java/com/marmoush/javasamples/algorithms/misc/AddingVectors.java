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

Retrieved from: http://en.literateprograms.org/Adding_vectors_(Java)?oldid=19519
*/
public class AddingVectors {
  public Double[] vadd(Double[] vector1, Double[] vector2) {
    assert vector1.length == vector2.length;
    Integer length = vector1.length;
    Double[] newVector = new Double[length];
    for (int i = 0; i < length; i++)
      newVector[i] = vector1[i] + vector2[i];
    return newVector;
  }
}
