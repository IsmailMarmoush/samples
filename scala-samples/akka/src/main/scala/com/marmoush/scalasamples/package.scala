package com.marmoush

import akka.actor.ActorSystem

import scala.concurrent.ExecutionContext

/**
  * Created by spark on 11/17/15.
  */
package object scalasamples {

  object Contexts {
    private val akka: ActorSystem = ActorSystem("helloakka")
    implicit val simpleDbLookups: ExecutionContext = akka.dispatchers.lookup("main.contexts.simple-db-lookups")
    implicit val expensiveDbLookups: ExecutionContext = akka.dispatchers.lookup("main.contexts.expensive-db-lookups")
    implicit val dbWriteOperations: ExecutionContext = akka.dispatchers.lookup("main.contexts.db-write-operations")
    implicit val expensiveCpuOperations: ExecutionContext = akka.dispatchers.lookup("main.contexts.expensive-cpu-operations")
  }
}
