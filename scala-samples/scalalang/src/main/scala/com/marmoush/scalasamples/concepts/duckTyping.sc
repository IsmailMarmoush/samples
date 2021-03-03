package com.marmoush.scalasamples.concepts

object duckTyping extends App {
  val conn: Connection = new Connection()

  def withClose(closeAble: {def close(): Unit}, op: {def close(): Unit} => Unit) {
    try {
      op(closeAble)
    } finally {
      closeAble.close()
    }
  }

  withClose(conn, conn =>
    println("do something with Connection"))

}

class Connection {
  def close() = println("close Connection")
}