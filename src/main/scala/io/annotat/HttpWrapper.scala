package io.annotat

import org.json4s.native.JsonMethods._

import scalaj.http._


class Works(conn: AbstractConnector) extends CrossrefRequest {
  val baseUrl: String = conn.baseUrl + "/works"
}

case object Works extends Routable with Queriable
case object Funders extends Routable
case object Members extends Routable
case object Types extends Routable
case object Licenses extends Routable
case object Journals extends Routable

class Works() extends Routable

object Works {
  def apply(conn: AbstractConnector) = new Works(conn) with Queriable
}

class Funders(conn: AbstractConnector) extends CrossrefRequest {
  val baseUrl: String = "http://api.crossref.org/funders"

}

object Funders {

}

class Members(conn: AbstractConnector) extends CrossrefRequest {
  val baseUrl: String = "http://api.crossref.org/members"
}

object Members {

}

class Types(conn: AbstractConnector) extends CrossrefRequest {
  val baseUrl: String = conn.baseUrl + "/types"
}

object Types {

}



class Licenses(conn: AbstractConnector) extends CrossrefRequest {
  val baseUrl: String = conn.baseUrl + "/licenses"
}

object Licenses {
  def apply(conn: AbstractConnector): Licenses = new Licenses(conn)
  def apply(conn: AbstractConnector, onWorks: Boolean): Licenses = if (onWorks) new Licenses(conn) with Queriable else apply(conn)
}

class Journals(conn: AbstractConnector) extends Route {
  val baseUrl: String = conn.baseUrl + "/journals"
}

object Journals {
  def apply(conn: AbstractConnector): Journals = new Journals(conn)
  def apply(conn: AbstractConnector, onWorks: Boolean): Journals = if (onWorks) new Journals(conn) with Queriable else apply(conn)
  val response: HttpResponse[Map[String,String]] = Http("http://foo.com").execute(parser = {inputStream =>
    parse(inputStream)
  })
}

sealed class BaseSearchType(url: String)

trait CrossrefRequest extends Filterable with Sortable with Facetable {
  def get: HttpRequest = Http(baseUrl).params(paramCache)
}

trait Routable extends Filterable with Facetable with Sortable

class Router(get: Unit => String)