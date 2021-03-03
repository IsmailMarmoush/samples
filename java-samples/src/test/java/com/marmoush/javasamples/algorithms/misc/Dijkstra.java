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

Retrieved from: http://en.literateprograms.org/Dijkstra's_algorithm_(Java)?oldid=15444
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Edge {
  public final DijkstraVertex target;
  public final double weight;

  public Edge(DijkstraVertex argTarget, double argWeight) {
    target = argTarget;
    weight = argWeight;
  }
}

public class Dijkstra {
  public static void main(String[] args) {
    DijkstraVertex v0 = new DijkstraVertex("Harrisburg");
    DijkstraVertex v1 = new DijkstraVertex("Baltimore");
    DijkstraVertex v2 = new DijkstraVertex("Washington");
    DijkstraVertex v3 = new DijkstraVertex("Philadelphia");
    DijkstraVertex v4 = new DijkstraVertex("Binghamton");
    DijkstraVertex v5 = new DijkstraVertex("Allentown");
    DijkstraVertex v6 = new DijkstraVertex("New York");
    v0.adjacencies = new Edge[]{new Edge(v1, 79.83), new Edge(v5, 81.15)};
    v1.adjacencies = new Edge[]{new Edge(v0, 79.75), new Edge(v2, 39.42), new Edge(v3, 103.00)};
    v2.adjacencies = new Edge[]{new Edge(v1, 38.65)};
    v3.adjacencies = new Edge[]{new Edge(v1, 102.53), new Edge(v5, 61.44), new Edge(v6, 96.79)};
    v4.adjacencies = new Edge[]{new Edge(v5, 133.04)};
    v5.adjacencies = new Edge[]{new Edge(v0, 81.77), new Edge(v3, 62.05), new Edge(v4, 134.47), new Edge(v6, 91.63)};
    v6.adjacencies = new Edge[]{new Edge(v3, 97.24), new Edge(v5, 87.94)};
    DijkstraVertex[] vertices = {v0, v1, v2, v3, v4, v5, v6};

    computePaths(v0);
    for (DijkstraVertex v : vertices) {
      System.out.println("Distance to " + v + ": " + v.minDistance);
      List<DijkstraVertex> path = getShortestPathTo(v);
      System.out.println("Path: " + path);
    }
  }

  public static void computePaths(DijkstraVertex source) {
    source.minDistance = 0.;
    PriorityQueue<DijkstraVertex> vertexQueue = new PriorityQueue<DijkstraVertex>();
    vertexQueue.add(source);

    while (!vertexQueue.isEmpty()) {
      DijkstraVertex u = vertexQueue.poll();

      // Visit each edge exiting u
      for (Edge e : u.adjacencies) {
        DijkstraVertex v = e.target;
        double weight = e.weight;
        double distanceThroughU = u.minDistance + weight;
        if (distanceThroughU < v.minDistance) {
          vertexQueue.remove(v);

          v.minDistance = distanceThroughU;
          v.previous = u;
          vertexQueue.add(v);
        }
      }
    }
  }

  public static List<DijkstraVertex> getShortestPathTo(DijkstraVertex target) {
    List<DijkstraVertex> path = new ArrayList<DijkstraVertex>();
    for (DijkstraVertex vertex = target; vertex != null; vertex = vertex.previous)
      path.add(vertex);

    Collections.reverse(path);
    return path;
  }
}
