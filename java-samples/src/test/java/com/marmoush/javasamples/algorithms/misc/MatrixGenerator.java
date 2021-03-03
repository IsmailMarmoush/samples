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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public class MatrixGenerator {
  private Map<String, String> lexicon;
  private Map<String, Integer> freq;
  private String corpus;
  private double[][] result;
  private String tagset;

  public MatrixGenerator(Map<String, String> lexicon, String corpus, String tagset) {
    this.corpus = corpus;
    this.lexicon = lexicon;
    this.tagset = tagset;
    countLexems();
    System.out.println("Tagset: " + tagset);
    System.out.println();
    System.out.println("Corpus: " + corpus);
    System.out.println();
    System.out.println("Frequencies:");
    System.out.println();
    printMap(freq);
  }

  private void countLexems() {
    freq = new HashMap<String, Integer>();
    for (StringTokenizer tok = new StringTokenizer(corpus, " \t\n.,", true); tok.hasMoreTokens(); ) {
      String rec = tok.nextToken();
      if (lexicon.containsKey(rec)) {
        if (freq.containsKey(rec)) {
          freq.put(rec, freq.get(rec) + 1);
        } else {
          freq.put(rec, 1);
        }
      }
    }
  }

  private void printMap(Map<String, ?> map) {
    for (Map.Entry<String, ?> e : map.entrySet()) {
      System.out.println(e.getKey() + ": " + e.getValue());
    }
  }

  public double[][] createMatrixB() {
    String[] t = tagset.split(" ");
    String[] l = lexicon.keySet().toArray(new String[0]);

    result = new double[l.length][t.length];
    for (int j = 0; j < result.length; j++) {
      Arrays.fill(result[j], 0.0);
      for (int k = 0; k < result[j].length; k++) {
        String categories = lexicon.get(l[j]);
        if (categories.contains(t[k])) {
          result[j][k] = 1.0 / categories.split(",").length;
        }
      }
    }

    for (int j = 0; j < result.length; j++) {
      for (int k = 0; k < result[j].length; k++) {
        double a = result[j][k] * freq.get(l[j]);
        double b = 0.0;
        for (int index = 0; index < result.length; index++) {
          b += result[index][k] * freq.get(l[index]);
        }
        result[j][k] = a / b;
      }
    }
    System.out.println();
    System.out.println("Matrix B (word-tag, lexicon and tags ordered as printed above, learned from corpus):");
    ViterbiMatrixTools.printMatrix(result);
    return result;
  }

  public double[][] createMatrixA(double diff) {
    String[] t = tagset.split(" ");
    double[][] res = new double[t.length][t.length];
    int cols = res[0].length;
    double average = 1.0 / cols;
    for (int i = 0; i < res.length; i++) {
      Arrays.fill(res[i], average);
    }
    Random r = new Random();
    for (int i = 0; i < res.length; i++) {
      double var = 1.0;
      while (var > diff)
        var = r.nextDouble();
      int pos = r.nextInt(res[i].length);
      boolean plus = true;
      for (int j = 0; j < res[i].length; j++) {
        // if not even, skip one random position
        if (res[i].length % 2 != 0 && j == pos)
          continue;
        if (plus && res[i][j] - var > 0) {
          res[i][j] += var;
          plus = false;
        } else
          if (res[i][j] - var > 0) {
            res[i][j] -= var;
            plus = true;
          }
      }
    }
    System.out.println();
    System.out.println("Matrix A (tag-tag, pseudo-random-generated):");
    ViterbiMatrixTools.printMatrix(res);
    System.out.println();
    return res;
  }
}
