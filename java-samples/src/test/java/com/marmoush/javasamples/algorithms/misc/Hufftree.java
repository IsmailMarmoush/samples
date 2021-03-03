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

Retrieved from: http://en.literateprograms.org/Huffman_coding_(Java)?oldid=12343
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Hufftree<E extends Comparable<? super E>> {
  private final Map<E, Boolean[]> encoding = new HashMap<E, Boolean[]>();
  private Node<E> tree;

  public Hufftree(Map<E, Double> frequencies) {
    PriorityQueue<Node<E>> pqueue = new PriorityQueue<Node<E>>();
    assert frequencies.size() > 1; // will not work with 0 or 1 symbols

    for (Map.Entry<E, Double> e : frequencies.entrySet()) {
      pqueue.offer(new Leaf<E>(e.getValue(), e.getKey()));
    }
    while (true) {
      Node<E> top = pqueue.poll();
      if (pqueue.isEmpty()) {
        tree = top;
        break;
      } else {
        Node<E> top2 = pqueue.poll();
        pqueue.offer(new Internal<E>(top, top2));
      }
    }
    Stack<Boolean> bitvec = new Stack<Boolean>();
    tree.fill(encoding, bitvec);
  }

  public static void main(String[] args) {
    Map<Character, Double> frequencies = new HashMap<Character, Double>();
    frequencies.put('e', 0.124167);
    frequencies.put('a', 0.0820011);
    frequencies.put('t', 0.0969225);
    frequencies.put('i', 0.0768052);
    frequencies.put('n', 0.0764055);
    frequencies.put('o', 0.0714095);
    frequencies.put('s', 0.0706768);
    frequencies.put('r', 0.0668132);
    frequencies.put('l', 0.0448308);
    frequencies.put('d', 0.0363709);
    frequencies.put('h', 0.0350386);
    frequencies.put('c', 0.0344391);
    frequencies.put('u', 0.028777);
    frequencies.put('m', 0.0281775);
    frequencies.put('f', 0.0235145);
    frequencies.put('p', 0.0203171);
    frequencies.put('y', 0.0189182);
    frequencies.put('g', 0.0181188);
    frequencies.put('w', 0.0135225);
    frequencies.put('v', 0.0124567);
    frequencies.put('b', 0.0106581);
    frequencies.put('k', 0.00393019);
    frequencies.put('x', 0.00219824);
    frequencies.put('j', 0.0019984);
    frequencies.put('q', 0.0009325);
    frequencies.put('z', 0.000599);
    Hufftree<Character> hufftree = new Hufftree<Character>(frequencies);
    for (char ch = 'a'; ch <= 'z'; ++ch) {
      System.out.println(ch + ": " + hufftree.encode(ch));
    }
    String source = "literateprogramming";
    System.out.println(source);

    List<Character> sourceArray = new ArrayList<Character>();
    for (int i = 0; i < source.length(); i++)
      sourceArray.add(source.charAt(i));

    List<Boolean> encoded = hufftree.encode(sourceArray);
    System.out.println(encoded);

    Collection<Character> destination = hufftree.decode(encoded);
    System.out.println(destination);
  }

  public List<Boolean> encode(E value) {
    return Arrays.asList(encoding.get(value));
  }

  public List<Boolean> encode(Iterable<E> c) {
    List<Boolean> result = new ArrayList<Boolean>();
    for (E x : c) {
      result.addAll(encode(x));
    }
    return result;
  }

  public Collection<E> decode(List<Boolean> v) {
    Collection<E> result = new ArrayList<E>();
    Node<E> node = tree;
    for (Boolean b : v) {
      Internal<E> i = (Internal<E>) node;
      node = b ? i.rightChild : i.leftChild;
      if (node instanceof Leaf) {
        result.add(((Leaf<E>) node).data);
        node = tree;
      }
    }

    assert node == tree;
    return result;
  }
}

abstract class Node<E extends Comparable<? super E>> implements Comparable<Node<E>> {
  protected final double frequency;

  protected Node(double f) {
    frequency = f;
  }

  public abstract void fill(Map<E, Boolean[]> encoding, Stack<Boolean> prefix);

  public int compareTo(Node<E> b) {
    if (frequency != b.frequency)
      return Double.compare(frequency, b.frequency);
    else
      if (this instanceof Leaf && b instanceof Internal)
        return -1;
      else
        if (this instanceof Internal && b instanceof Leaf)
          return 1;
        else
          if (this instanceof Internal && b instanceof Internal) {
            Internal<E> a = (Internal<E>) this, z = (Internal<E>) b;
            if (!a.leftChild.equals(z.leftChild))
              return a.leftChild.compareTo(z.leftChild);
            else
              return a.rightChild.compareTo(z.rightChild);
          } else
            return ((Leaf<E>) this).data.compareTo(((Leaf<E>) b).data);
  }
}

class Leaf<E extends Comparable<? super E>> extends Node<E> {
  public final E data;

  public Leaf(double f, E d) {
    super(f);
    data = d;
  }

  public void fill(Map<E, Boolean[]> encoding, Stack<Boolean> prefix) {
    encoding.put(data, prefix.toArray(new Boolean[0]));
  }
}

class Internal<E extends Comparable<? super E>> extends Node<E> {
  public final Node<E> leftChild, rightChild;

  public Internal(Node<E> l, Node<E> r) {
    super(l.frequency + r.frequency);
    leftChild = l;
    rightChild = r;
  }

  public void fill(Map<E, Boolean[]> encoding, Stack<Boolean> prefix) {
    prefix.push(false);
    leftChild.fill(encoding, prefix);
    prefix.pop();
    prefix.push(true);
    rightChild.fill(encoding, prefix);
    prefix.pop();
  }
}
