package com.knoldus.actors

import akka.actor.{Actor, ActorLogging}
import com.knoldus.messages._

class FirstActor extends Actor with ActorLogging{

  override def receive: Receive = {
    case Message => {
      log.info("<<<< !!! FROM First Actor : THIS IS MESSAAAAAAAAAAAAAGE !!! >>>>")
      context stop self
      log.info("<<<< !!! I am done, farewell! !!! >>>>")
    }
  }

}
