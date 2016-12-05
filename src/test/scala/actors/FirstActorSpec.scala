package actors

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit, TestProbe}
import com.knoldus.actors.FirstActor
import com.knoldus.messages.{Message, Reply}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

class FirstActorSpec(_system: ActorSystem) extends TestKit(_system) with ImplicitSender
with WordSpecLike with Matchers with BeforeAndAfterAll {

  def this() = this(ActorSystem("FirstActorSpec"))

  override def afterAll {
    TestKit.shutdownActorSystem(_system)
  }

  "FirstActor" must {

    "receive a message Message1 and send back an object Reply" in {
      val probe = TestProbe()
      val halfYearlyActor = _system.actorOf(Props(classOf[FirstActor]))

      probe watch halfYearlyActor

      probe.send(halfYearlyActor, Message)
      probe.expectMsg(Reply)

    }

    "receive a message Message2 and send back an object Reply" in {
      val probe = TestProbe()
      val halfYearlyActor = _system.actorOf(Props(classOf[FirstActor]))

      probe watch halfYearlyActor

      probe.send(halfYearlyActor, Message)
      probe.expectMsg(Reply)
    }
  }
}
