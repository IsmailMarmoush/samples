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

Retrieved from: http://en.literateprograms.org/Generic_tree_(Java)?oldid=18925
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Tree<E> {
  public static <T> Tree<T> branch(final List<? extends Tree<T>> children) {
    // return anonymous subclass for a branch:
    return new Tree<T>() {
      @Override
      public <R> R visit(Visitor<? super T, R> v) {
        List<R> result = new ArrayList<R>();
        for (Tree<T> tree : children) {
          result.add(tree.visit(v));
        }
        return v.branch(result);
      }
    };
  }

  public abstract <R> R visit(Visitor<? super E, R> v);

  public static <T> Tree<T> leaf(final T e) {
    // return anonymous subclass for a leaf:
    return new Tree<T>() {
      @Override
      public <R> R visit(Visitor<? super T, R> v) {
        return v.leaf(e);
      }
    };
  }

  public interface Visitor<E, R> {
    public R leaf(E elt);

    public R branch(List<? extends R> children);
  }

  static class TreeClient {
    public static void main(String[] args) {
      Tree<Integer> t = Tree.branch(Arrays.asList(Tree.branch(Arrays.asList(Tree.leaf(1), Tree.leaf(2))),
                                                  Tree.leaf(3)));
      System.out.println(toString(t)); // --> ((1,2),3)
      System.out.println(sum(t)); // --> 6.0
    }

    public static String toString(Tree<?> t) {
      // return an anonymous implementation of a visitor:
      return t.visit(new Tree.Visitor<Object, String>() {
        public String leaf(Object e) {
          return e.toString();
        }

        public String branch(List<? extends String> children) {
          String result = "(";
          for (String c : children) {
            result += c + " ";
          }
          return result.trim() + ")";
        }
      });
    }

    public static double sum(Tree<? extends Number> t) {
      // return an anonymous implementation of a visitor:
      return t.visit(new Tree.Visitor<Number, Double>() {
        public Double leaf(Number e) {
          return e.doubleValue();
        }

        public Double branch(List<? extends Double> children) {
          Double res = 0.0;
          for (Double d : children) {
            res += d;
          }
          return res;
        }
      });
    }
  }
}
