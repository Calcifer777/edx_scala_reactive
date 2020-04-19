package w2


import akka.actor.Actor
import akka.actor.Props
import akka.actor.ActorSystem


class MainActor extends Actor {
  val counter = context.actorOf(Props[Counter], "counter")
  counter ! "incr"
  counter ! "incr"
  counter ! "incr"
  counter ! "get"
  def receive = {
    case count: Int =>
      println(s"count was $count")
      context.stop(self)
  }
}

object Main extends App {
  val system = ActorSystem.create("test")
  val root = system.actorOf(Props[MainActor])
  system.terminate()
}
