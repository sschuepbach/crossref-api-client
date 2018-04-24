package io.annotat

import scalaj.http._
import org.json4s.native.JsonMethods._

class CrossrefConnector extends AbstractConnector {
  override var baseUrl = "http://api.crossref.org"

//  override def setRoute(route: Routable): Routable = route match {
//    case x: Works =>
//
//      baseUrl = baseUrl + "/works"
//      x
//    case x: Funders =>
//      baseUrl = baseUrl + "/funders"
//      x
//    case x: Members =>
//      baseUrl = baseUrl + "/members"
//      x
//    case x: Types =>
//      baseUrl = baseUrl + "/types"
//      x
//    case x: Licenses =>
//      baseUrl = baseUrl + "/licenses"
//      x
//    case x: Journals =>
//      baseUrl = baseUrl + "/journals"
//      x
//
//  }


  def getResult(url: String, param: Map[String, String]): Option[List[ResultSet]] = {
    val res = Http(url).params(param).asString
    if (res.isError) None
    else {
      val parsedRes = parse(res.body).children
      if (parsedRes.head.toString != "ok") None
      else {
        parsedRes(1).toString match {
          case "work-list" => //parsedRes(3)
          case "work" =>
          case "funder-list" =>
          case "funder" =>
          case "member-list" =>
          case "member" =>
          case "type-list" =>
          case "type" =>
          case "license-list" =>
          case "license" =>
          case "journal-list" =>
          case "journal" =>
        }
      }
    }
  }


  def setWorksRoute: Router = {
    val r = new Router((param: Map[String, String]) => Http("http://api.crossref.org/works").params(param))
  }

  def setWorksRoute(doi: String) = {

  }

  def setFundersRoute: Router = {
    val r = new Router((param: Map[String, String]) => Http("http://api.crossref.org/funders").params(param))
  }

  def setFundersRoute(funderId: String): Router = {

  }

  def setWorksInFundersRoute(funderId: String): Router

  def setMembersRoute: Router

  def setMembersRoute(memberId: String): Router

  def setWorksInMembersRoute(memberId: String): Router

  def setTypesRoute: Router
  def setTypesRoute(typeId: String): Router

  def setWorksInTypesRoute(typeId: String): Router

  def setLicensesRoute: Router
  def setJournalsRoute: Router
  def setJournalsRoute(issn: String): Router
  def setWorksInJournalsRoute(issn: String): Router

}
