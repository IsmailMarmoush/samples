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

Retrieved from: http://en.literateprograms.org/99_Bottles_of_Beer_(Java)?oldid=18905
*/

public class NinetyNineBottles {

  private static int NUMBER_BOTTLES_OF_BEER_ON_THE_WALL = 99;

  public static void main(String[] args) {
    NinetyNineBottles nnb = new NinetyNineBottles();
    nnb.printSong();
  }

  /** Print the 99 bottles of beer song to the console. */
  public void printSong() {
    int nBottles = NUMBER_BOTTLES_OF_BEER_ON_THE_WALL;
    while (nBottles > 0) {
      String verse = "";
      if (nBottles > 1)
        verse += verseForNBottles(nBottles);
      else
        verse += finalVerse();
      System.out.println(verse);
      nBottles--;
    }
  }

  // private methods

  /**
   * Return verse for N bottles of beer (where N is > 1)
   *
   * @param nBottles the current number of bottles of beer on the wall.
   * @return verse appropriate for the number of bottles of beer on the wall.
   */
  private String verseForNBottles(int nBottles) {
    if (nBottles <= 0)
      return "";
    String verse =
            nBottles + " bottles of beer on the wall,\n" + nBottles + " bottles of beer!\n" + "   Take one down,\n" +
            "   Pass it around,\n";
    int bottlesLeft = nBottles - 1;
    if (bottlesLeft > 1)
      verse += bottlesLeft + " bottles of beer on the wall!\n\n";
    else
      verse += "1 bottle of beer on the wall!\n\n";
    return verse;
  }

  /**
   * Print final verse for one bottle of beer.
   *
   * @return the final verse (one bottle of beer on the wall).
   */
  private String finalVerse() {
    return "1 bottle of beer on the wall,\n" + "1 bottle of beer!\n" + "   Take one down,\n" + "   Pass it around,\n" +
           "No more bottles of beer on the wall!\n\n";
  }
}
