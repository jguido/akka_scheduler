package com.knoldus.boot.sbt

import akka.actor.ActorSystem
import com.knoldus.messages.Message
import com.knoldus.scheduler.Scheduler
import com.typesafe.config.ConfigFactory
import org.slf4j.{Logger, LoggerFactory}

// $COVERAGE-OFF$Disabling highlighting by default until a workaround for https://issues.scala-lang.org/browse/SI-8596 is found
object BootStrap extends Scheduler {

  import scala.concurrent.duration._

  override val system: ActorSystem = ActorSystem.create("KnoldusScheduler", ConfigFactory.load)
  def main(args: Array[String]): Unit = {

    register(Message, 1000 milliseconds)
    register(Message, 1500 milliseconds)
    register(Message, 10000 milliseconds)
    register(Message, 2000 milliseconds)
    register(Message, 5000 milliseconds)
    register(Message, 6000 milliseconds)
    register(Message, 20000 milliseconds)
  }

  override val logger: Logger = LoggerFactory.getLogger(this.getClass)
}
// $COVERAGE-ON$