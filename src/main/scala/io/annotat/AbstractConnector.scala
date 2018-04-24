package io.annotat

abstract class AbstractConnector {

  protected var route: Routable
  protected var baseUrl: String
  def setRoute(route: Routable): Unit
  def get[T](params: Map[String, String]): T

}
