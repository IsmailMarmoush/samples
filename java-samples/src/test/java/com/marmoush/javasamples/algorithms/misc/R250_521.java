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

Retrieved from: http://en.literateprograms.org/R250/521_(Java)?oldid=4768
*/

public final class R250_521 {
  private int[] r250_buffer = new int[250];
  private int[] r521_buffer = new int[521];

  private int r250_index;
  private int r521_index;

  public R250_521() {
    java.util.Random r = new java.util.Random();
    int i = 521;

    while (i-- > 250) {
      r521_buffer[i] = r.nextInt();
    }
    while (i-- > 31) {
      r250_buffer[i] = r.nextInt();
      r521_buffer[i] = r.nextInt();
    }

    int mask1 = 1;
    int mask2 = 0xFFFFFFFF;
    while (i-- > 0) {
      r250_buffer[i] = (r.nextInt() | mask1) & mask2;
      r521_buffer[i] = (r.nextInt() | mask1) & mask2;
      mask2 ^= mask1;
      mask1 >>= 1;
    }
    r250_buffer[0] = mask1;
    r521_buffer[0] = mask2;
    r250_index = 0;
    r521_index = 0;
  }

  public int random() {
    int i1 = r250_index;
    int i2 = r521_index;

    int j1 = i1 - (250 - 103);
    if (j1 < 0)
      j1 = i1 + 103;
    int j2 = i2 - (521 - 168);
    if (j2 < 0)
      j2 = i2 + 168;
    int r = r250_buffer[j1] ^ r250_buffer[i1];
    r250_buffer[i1] = r;
    int s = r521_buffer[j2] ^ r521_buffer[i2];
    r521_buffer[i2] = s;
    i1 = (i1 != 250 - 1) ? (i1 + 1) : 0;
    r250_index = i1;
    i2 = (i2 != 521 - 1) ? (i2 + 1) : 0;
    r521_index = i2;
    return r ^ s;
  }
}
