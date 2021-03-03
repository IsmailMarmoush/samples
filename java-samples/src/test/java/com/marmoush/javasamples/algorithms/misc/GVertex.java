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

Retrieved from: http://en.literateprograms.org/Depth-first_search_(Java)?oldid=11979
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

interface GoalFunction<T> {
  boolean evaluate(GVertex<T> o);
}

public class GVertex<T> {
  private final T data;
  private final List<GVertex<T>> _successors = new ArrayList<GVertex<T>>();

  GVertex(T data) {
    this.data = data;
  }

  public static <T> boolean depthFirstSearch(GVertex<T> start, GoalFunction<T> isGoal, Stack<GVertex<T>> result) {
    if (result.contains(start)) {
      return false;
    }

    result.push(start);

    if (isGoal.evaluate(start)) {
      return true;
    }
    for (GVertex<T> v : start.successors()) {
      if (depthFirstSearch(v, isGoal, result)) {
        return true;
      }
    }

    // No path was found
    result.pop();
    return false;
  }

  public static List<GVertex<Integer>> petersenGraph() {
    List<GVertex<Integer>> v = new ArrayList<GVertex<Integer>>();
    for (int i = 0; i < 10; i++) {
      v.add(new GVertex<Integer>(i));
    }
    int[][] edges = {{0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 3}, {3, 2}, {3, 4}, {4, 3}, {4, 0}, {0, 4}, {5, 6}, {6, 5},
                     {6, 7}, {7, 6}, {7, 8}, {8, 7}, {8, 9}, {9, 8}, {9, 5}, {5, 9}, {5, 0}, {0, 5}, {6, 2}, {2, 6},
                     {7, 4}, {4, 7}, {8, 1}, {1, 8}, {9, 3}, {3, 9}};
    for (int[] e : edges) {
      v.get(e[0]).successors().add(v.get(e[1]));
    }
    return v;
  }

  public static void main(String[] args) {
    List<GVertex<Integer>> v = petersenGraph();
    Stack<GVertex<Integer>> path = new Stack<GVertex<Integer>>();
    if (depthFirstSearch(v.get(0), new GoalFunction<Integer>() {
      public boolean evaluate(GVertex<Integer> v) {
        return v.getData() == 7;
      }
    }, path)) {
      System.out.print("Found path: ");
      for (GVertex<Integer> u : path) {
        System.out.print(u.getData() + " ");
      }
      System.out.println();
    } else {
      System.out.println("No path found");
    }
  }

  T getData() {
    return data;
  }

  List<GVertex<T>> successors() {
    return _successors;
  }
}
