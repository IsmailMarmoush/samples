package com.marmoush.scalasamples.concepts

class GraphLikeJava {

  class JNode {
    var connectedNodes: List[GraphLikeJava#JNode] = Nil

    def connectTo(node: GraphLikeJava#JNode) {
      if (connectedNodes.find(node.equals).isEmpty) {
        connectedNodes = node :: connectedNodes
      }
    }
  }

  var nodes: List[JNode] = Nil

  def newNode: GraphLikeJava#JNode = {
    val res = new JNode
    nodes = res :: nodes
    res
  }
}

class Graph {

  class Node {
    var connectedNodes: List[Node] = Nil

    def connectTo(node: Node) {
      if (connectedNodes.find(node.equals).isEmpty) {
        connectedNodes = node :: connectedNodes
      }
    }
  }

  var nodes: List[Node] = Nil

  def newNode: Node = {
    val res = new Node
    nodes = res :: nodes
    res
  }
}

object IllegalGraphTest extends App {
  val g: Graph   = new Graph
  val n1: g.Node = g.newNode
  val n2: g.Node = g.newNode
  n1.connectTo(n2) // ok
  val h: Graph   = new Graph
  val n3: h.Node = h.newNode
  // n1.connectTo(n3) // illegal!

  /*-------------------------*/
  val gjava: GraphLikeJava        = new GraphLikeJava
  val n1java: GraphLikeJava#JNode = gjava.newNode
  val n2java: GraphLikeJava#JNode = gjava.newNode
  n1java.connectTo(n2java) // ok
  val hjava: GraphLikeJava        = new GraphLikeJava
  val n3java: GraphLikeJava#JNode = hjava.newNode
  n1java.connectTo(n3java) // now ok
}
