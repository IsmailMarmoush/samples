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

Retrieved from: http://en.literateprograms.org/Stack_(Java)?oldid=19216
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Element<E> {
  final E value;
  Element next;

  Element(E value) {
    this.value = value;
  }
}

public class Stack<E> {
  Element<E> head;

  public void testStack() {

    Stack<String> stack = new Stack<String>();
    List<String> elements = Arrays.asList("first", "second", "third", "fourth");
    for (String e : elements) {
      stack.push(e);
    }
    List<String> result = new ArrayList<String>();
    while (!stack.empty()) {
      result.add(stack.pop());
    }
    //        assertEquals(arrays.asList("fourth", "third", "second", "first"), result);
  }

  public void push(E element) {
    Element<E> newElement = new Element<E>(element);
    if (empty()) {
      head = newElement;
      head.next = null;
    } else {
      newElement.next = head;
      head = newElement;
    }
  }

  public boolean empty() {
    return head == null;
  }

  public E pop() {
    E result = null;
    if (!empty()) {
      result = head.value;
      head = head.next;
    }
    return result;
  }
}
