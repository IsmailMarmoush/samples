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

Retrieved from: http://en.literateprograms.org/Mersenne_twister_(Java)?oldid=5676
*/

public final class MT {
  private int mt_index;
  private int[] mt_buffer = new int[624];

  public MT() {
    java.util.Random r = new java.util.Random();
    for (int i = 0; i < 624; i++)
      mt_buffer[i] = r.nextInt();
    mt_index = 0;
  }

  public int random() {
    if (mt_index == 624) {
      mt_index = 0;
      int i = 0;
      int s;
      for (; i < 624 - 397; i++) {
        s = (mt_buffer[i] & 0x80000000) | (mt_buffer[i + 1] & 0x7FFFFFFF);
        mt_buffer[i] = mt_buffer[i + 397] ^ (s >> 1) ^ ((s & 1) * 0x9908B0DF);
      }
      for (; i < 623; i++) {
        s = (mt_buffer[i] & 0x80000000) | (mt_buffer[i + 1] & 0x7FFFFFFF);
        mt_buffer[i] = mt_buffer[i - (624 - 397)] ^ (s >> 1) ^ ((s & 1) * 0x9908B0DF);
      }

      s = (mt_buffer[623] & 0x80000000) | (mt_buffer[0] & 0x7FFFFFFF);
      mt_buffer[623] = mt_buffer[396] ^ (s >> 1) ^ ((s & 1) * 0x9908B0DF);
    }
    return mt_buffer[mt_index++];
  }
}
