package scheduler

import akka.actor._
import akka.testkit.{ImplicitSender, TestKit}
import com.knoldus.messages.Message
import com.typesafe.config.ConfigFactory
import org.scalatest.{BeforeAndAfterAll, MustMatchers, WordSpecLike}

class SchedulerSpec(_system: ActorSystem) extends TestKit(_system) with ImplicitSender
with WordSpecLike with MustMatchers with BeforeAndAfterAll{

  def this() = this(ActorSystem("SchedulerSpec", ConfigFactory.load("test.conf")))

  override def afterAll {
    TestKit.shutdownActorSystem(_system)
  }

  object ScheduleTestReceiver extends Actor with ActorLogging {
    var probe: ActorRef = _
    def receive = {
      case Message =>
        log.info("Got the Message1")
      case Message =>
        log.info("Got the Message2")
    }
  }
}
