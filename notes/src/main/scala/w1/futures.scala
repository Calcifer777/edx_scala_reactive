package w1


import scala.concurrent.{Await, Future, Promise, TimeoutException}
import scala.concurrent.ExecutionContext.Implicits.global 
import scala.concurrent.duration._
import scala.util.{Failure, Random, Success, Try}
import scala.util.Random

object Main extends App {

  def square(x: Int): (Int, Long) = {
    val start = System.currentTimeMillis
    println(f"Squaring($x), at ${start}")
    Thread.sleep(x*1000)
    (x, start)
  }

  (1 until 10) foreach { x => 
    Future(square(x)) onComplete {
      case Success(v) => println(
        f"Squared: ${v._1}, Elapsed: ${System.currentTimeMillis-v._2} ms"
        )
      case Failure(f) => println("Timeout")
    }
  }

}