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

import java.util.HashMap;
import java.util.Map;

public class Tagger {
  String tagset;
  String corpus;
  Map<String, String> lexicon;
  String lexiconString;

  public void testTagger() {

    System.out.println(tag("layers that fly that food . that fly sneaks ."));
  }

  public String tag(String input) {
    initData();
    ViterbiHMM hmm = new ViterbiHMM(tagset, lexiconString, input, lexicon, corpus, true);
    String[] in = input.split(" ");
    String[] re = hmm.mostProbableSequence().split(" ");
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < in.length; i++) {
      buf.append(in[i] + ":" + re[i] + " ");
    }
    return buf.toString();
  }

  private void initData() {
    lexicon = new HashMap<String, String>();
    lexicon.put("fly", "vn");
    lexicon.put("layers", "vn");
    lexicon.put("sneaks", "v");
    lexicon.put("food", "n");
    lexicon.put("that", "det,rp");
    lexicon.put(".", "period");
    StringBuffer lexBuf = new StringBuffer();
    for (String word : lexicon.keySet()) {
      lexBuf.append(word + " ");
    }
    lexiconString = lexBuf.toString();
    tagset = "det rp vn v n period";
    corpus = "that fly layers. that fly sneaks. that, that sneaks food" + "layers. that fly layers that food. layers.";
  }
}
