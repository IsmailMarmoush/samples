package com.marmoush.javasamples.algorithms;
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

Retrieved from: http://en.literateprograms.org/Rot13_(Java)?oldid=19204
*/

import com.marmoush.javasamples.algorithms.misc.Rot13;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Rot13Test {

  private String plainText;
  private String cypherText;

  public void setUp() {
    plainText = "Now is the Winter of our Discontent,\n" + "Made glorious Summer by this Son of Yorke:\n" +
                "And all the clouds that lowr'd vpon our house\n" + "In the deepe bosome of the Ocean buried.\n" +
                "Now are our browes bound with Victorious Wreathes,\n" + "Our bruised armes hung vp for Monuments;\n" +
                "Our sterne Alarums chang'd to merry Meetings;\n" +
                "Our dreadfull Marches, to delightfull Measures.\n" +
                "Grim-visag'd Warre, hath smooth'd his wrinkled Front:\n" +
                "And now, in stead of mounting Barbed Steeds,\n" + "To fright the Soules of fearfull Aduersaries,\n" +
                "He capers nimbly in a Ladies Chamber,\n" + "To the lasciuious pleasing of a Lute.";
    cypherText = "Abj vf gur Jvagre bs bhe Qvfpbagrag,\n" + "Znqr tybevbhf Fhzzre ol guvf Fba bs Lbexr:\n" +
                 "Naq nyy gur pybhqf gung ybje'q icba bhe ubhfr\n" + "Va gur qrrcr obfbzr bs gur Bprna ohevrq.\n" +
                 "Abj ner bhe oebjrf obhaq jvgu Ivpgbevbhf Jerngurf,\n" + "Bhe oehvfrq nezrf uhat ic sbe Zbahzragf;\n" +
                 "Bhe fgrear Nynehzf punat'q gb zreel Zrrgvatf;\n" +
                 "Bhe qernqshyy Znepurf, gb qryvtugshyy Zrnfherf.\n" +
                 "Tevz-ivfnt'q Jneer, ungu fzbbgu'q uvf jevaxyrq Sebag:\n" +
                 "Naq abj, va fgrnq bs zbhagvat Oneorq Fgrrqf,\n" + "Gb sevtug gur Fbhyrf bs srneshyy Nqhrefnevrf,\n" +
                 "Ur pncref avzoyl va n Ynqvrf Punzore,\n" + "Gb gur ynfpvhvbhf cyrnfvat bs n Yhgr.";
  }

  @Test
  public void testEncode() {
    Assertions.assertEquals(cypherText, Rot13.encode(plainText));
  }

  @Test
  public void testDecode() {
    assertEquals(plainText, Rot13.encode(cypherText));
  }
}
