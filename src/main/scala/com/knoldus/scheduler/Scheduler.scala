package com.knoldus.scheduler


import akka.actor.{ActorRef, ActorSystem, Props}
import com.knoldus.actors.FirstActor
import com.knoldus.configuration.Namer
import org.slf4j.Logger

import scala.concurrent.duration._

trait Scheduler {

  val system: ActorSystem
  val logger: Logger

  def register(message: Any, delay: FiniteDuration): Unit = {
    import scala.concurrent.ExecutionContext.Implicits.global

    val actor: ActorRef = system.actorOf(Props(classOf[FirstActor]), Namer.generate)
    logger.info(s"HEY i am new actor this is my name ${actor.path}")
    this.system.scheduler.scheduleOnce(delay, actor, message)

  }

}
