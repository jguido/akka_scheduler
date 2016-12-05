package com.knoldus.actors

import akka.actor.{Actor, ActorLogging}
import com.knoldus.messages._


class SecondActor extends Actor with ActorLogging{

  override def receive: Receive = {
    case Message => {
      log.info("<<<< !!! FROM Second Actor : THIS IS MESSAAAAAAAAAAAAAGE !!! >>>>")
      sender() ! Reply
    }
  }

}
