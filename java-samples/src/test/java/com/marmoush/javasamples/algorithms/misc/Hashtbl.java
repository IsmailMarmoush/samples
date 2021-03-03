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

Retrieved from: http://en.literateprograms.org/Hash_table_(Java)?oldid=12352
*/

class Hashnode<K, V> {
  K key;
  V data;
  Hashnode<K, V> next;

  public Hashnode(K k, V v, Hashnode<K, V> n) {
    key = k;
    data = v;
    next = n;
  }
}

public class Hashtbl<K, V> {
  private Hashnode<K, V>[] nodes;

  @SuppressWarnings("unchecked")
  public Hashtbl(int size) {
    nodes = new Hashnode[size];
  }

  public static void main(String[] args) {
    Hashtbl<String, String> hashtbl = new Hashtbl<String, String>(16);

    hashtbl.insert("France", "Paris");
    hashtbl.insert("England", "London");
    hashtbl.insert("Sweden", "Stockholm");
    hashtbl.insert("Germany", "Berlin");
    hashtbl.insert("Norway", "Oslo");
    hashtbl.insert("Italy", "Rome");
    hashtbl.insert("Spain", "Madrid");
    hashtbl.insert("Estonia", "Tallinn");
    hashtbl.insert("Netherlands", "Amsterdam");
    hashtbl.insert("Ireland", "Dublin");

    System.out.println("After insert:");
    String italy = hashtbl.get("Italy");
    System.out.println("Italy: " + (italy != null ? italy : "-"));
    String spain = hashtbl.get("Spain");
    System.out.println("Spain: " + (spain != null ? spain : "-"));

    hashtbl.remove("Spain");

    System.out.println("After remove:");
    spain = hashtbl.get("Spain");
    System.out.println("Spain: " + (spain != null ? spain : "-"));

    hashtbl.resize(8);

    System.out.println("After resize:");
    italy = hashtbl.get("Italy");
    System.out.println("Italy: " + (italy != null ? italy : "-"));
  }

  public V insert(K key, V data) {
    int hash = getIndex(key);

    //    System.err.printf("insert() key=%s, hash=%d, data=%s\n", key, hash, data);

    for (Hashnode<K, V> node = nodes[hash]; node != null; node = node.next) {
      if (key.equals(node.key)) {
        V oldData = node.data;
        node.data = data;
        return oldData;
      }
    }

    Hashnode<K, V> node = new Hashnode<K, V>(key, data, nodes[hash]);
    nodes[hash] = node;

    return null;
  }

  public V get(K key) {
    int hash = getIndex(key);

    //    System.err.printf("get() key=%s, hash=%d\n", key, hash);

    for (Hashnode<K, V> node = nodes[hash]; node != null; node = node.next) {
      if (key.equals(node.key))
        return node.data;
    }

    return null;
  }

  public boolean remove(K key) {
    int hash = getIndex(key);

    Hashnode<K, V> prevnode = null;
    for (Hashnode<K, V> node = nodes[hash]; node != null; node = node.next) {
      if (key.equals(node.key)) {
        if (prevnode != null)
          prevnode.next = node.next;
        else
          nodes[hash] = node.next;
        return true;
      }
      prevnode = node;
    }

    return false;
  }

  public void resize(int size) {
    Hashtbl<K, V> newtbl = new Hashtbl<K, V>(size);

    for (Hashnode<K, V> node : nodes) {
      for (; node != null; node = node.next) {
        newtbl.insert(node.key, node.data);
        remove(node.key);
      }
    }

    nodes = newtbl.nodes;
  }

  private int getIndex(K key) {
    int hash = key.hashCode() % nodes.length;
    if (hash < 0)
      hash += nodes.length;
    return hash;
  }
}
