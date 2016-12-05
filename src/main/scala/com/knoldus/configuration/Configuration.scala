package com.knoldus.configuration

import com.typesafe.config.ConfigFactory

object Configuration {
  def load: (String) => String = {
    ConfigFactory.load().getString
  }

  lazy val NO_OF_INSTANCE = load("knoldus.scheduler.noOf.instance")

  lazy val NAME_FIRST_ACTOR = load("knoldus.scheduler.actors.name.first")
  lazy val NAME_SECOND_ACTOR = load("knoldus.scheduler.actors.name.second")
}
