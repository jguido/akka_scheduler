package com.knoldus.scheduler


import akka.actor.ActorRef
import com.knoldus.actors.LocalActorRefFactory
import com.knoldus.configuration.Configuration._
import com.knoldus.messages.Message

import scala.concurrent.duration._

trait Scheduler {

  val localActorRefFactory: LocalActorRefFactory

  def schedule: Unit = {

    import scala.concurrent.ExecutionContext.Implicits.global

    val _system = localActorRefFactory.system
    val firstReceiver: ActorRef = localActorRefFactory getReceiver NAME_FIRST_ACTOR
    val secondReceiver = localActorRefFactory getReceiver NAME_SECOND_ACTOR

    localActorRefFactory.system.scheduler.scheduleOnce(5000 milliseconds, firstReceiver, Message)
    localActorRefFactory.system.scheduler.scheduleOnce(500 milliseconds, secondReceiver, Message)
  }

}

object Scheduler extends Scheduler{


  val localActorRefFactory: LocalActorRefFactory = LocalActorRefFactory

}
