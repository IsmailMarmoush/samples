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

Retrieved from: http://en.literateprograms.org/Binary_search_tree_(Java)?oldid=18914
*/

import java.util.ArrayList;
import java.util.List;

class BinaryNode<E extends Comparable<? super E>> {
  public final E value;
  public BinaryNode<E> left;
  public BinaryNode<E> right;

  BinaryNode(E value) {
    this.value = value;
  }

  BinaryNode(BinaryNode<E> node) {
    left = node.left;
    right = node.right;
    value = node.value;
  }
}

public class BinaryTree<E extends Comparable<? super E>> {
  BinaryNode<E> root;
  int size = 0;
  int i;

  public void testTree() {

    BinaryTree<String> tree = new BinaryTree<String>();
    tree.add("Hanno");
    tree.add("Zacharias");
    tree.add("Berhard");
    //        assertEquals(new String[]{"Berhard", "Hanno", "Zacharias"}, tree.toList().toArray(new
    // String[3]));
    //        assertEquals(null, tree.get("Otto"));
    //        assertEquals("Hanno", tree.get("Hanno"));
  }

  public void add(E element) {
    if (root == null && element != null) {
      root = new BinaryNode<E>(element);
      size++;
    } else
      if (element != null) {
        root = insert(root, element);
      }
  }

  private BinaryNode<E> insert(BinaryNode<E> node, E value) {
    BinaryNode<E> result = new BinaryNode<E>(node);
    int compare = result.value.compareTo(value);

    if (compare == 0) {
      return result;
    }

    if (compare > 0) {
      if (result.left != null) {
        result.left = insert(result.left, value);
      } else {
        result.left = new BinaryNode<E>(value);
        size++;
      }
    } else
      if (compare < 0) {
        if (result.right != null) {
          result.right = insert(result.right, value);
        } else {
          result.right = new BinaryNode<E>(value);
          size++;
        }
      }
    return result;
  }

  public E get(E key) {
    if (root == null)
      return null;

    BinaryNode<E> node = root;
    int compareResult;
    while ((compareResult = node.value.compareTo(key)) != 0) {
      if (compareResult > 0) {
        if (node.left != null)
          node = node.left;
        else
          return null;
      } else {
        if (node.right != null)
          node = node.right;
        else
          return null;
      }
    }
    return node.value;
  }

  public List<E> toList() {
    List<E> result = new ArrayList<E>();
    treeToList(root, result);
    return result;
  }

  private void treeToList(BinaryNode<E> node, List<E> goal) {
    if (node != null) {
      treeToList(node.left, goal);
      goal.add(node.value);
      treeToList(node.right, goal);
    }
  }
}
