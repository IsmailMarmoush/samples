import akka.actor.Actor

import scala.concurrent.forkjoin.ForkJoinPool
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

trait DatabaseDriver

case class CustomerUpdateException(x: String)

case class UpdateCustomer(id: Int)

class CustomerUpdater(dbDriver: DatabaseDriver) extends Actor {
  def receive = {
    case UpdateCustomer(customer) =>
      val originalSender = sender
      implicit val ec: ExecutionContext =
        ExecutionContext.fromExecutor(new ForkJoinPool())
      val future = Future {
        // define some JDBC action
        "hello from future"
      }
      future.onComplete {
        case Failure(x) => throw new Exception(x)
        case Success(_) => originalSender ! "hello back"
      }
  }
}