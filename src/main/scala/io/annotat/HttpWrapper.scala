package io.annotat

import java.net.URLEncoder

import scalaj.http._


class Works extends BaseRequest {
  override val baseUrl: String = super.baseUrl + "/works"
  override def apply = new BaseSearchType(baseUrl) with Queriable
  override def apply(onWorks: Boolean) = apply
}

object Funders extends BaseRequest {
  override val baseUrl: String = super.baseUrl + "/funders"
}

object Members extends BaseRequest {
  override val baseUrl: String = super.baseUrl + "/members"
}

object Types extends BaseRequest {
  override val baseUrl: String = super.baseUrl + "/types"
}

object Licenses extends BaseRequest {
  override val baseUrl: String = super.baseUrl + "/licenses"
}

object Journals extends BaseRequest {
  override val baseUrl: String = super.baseUrl + "/journals"
}


sealed class BaseSearchType(url: String) {

  type Param = (String, String)

  val baseUrl: String = "http://api.crossref.org/"

  val get: HttpRequest = {
    val req = Http(baseUrl)

  }

  def get(params: Seq[(String, String)]): HttpRequest = get.params(params)
}

trait BaseRequest extends Filterable with Sortable with Facetable {

  val baseUrl: String = "http://api.crossref.org"
  def apply: BaseSearchType = new BaseSearchType(baseUrl)
  def apply(onWorks: Boolean): BaseSearchType = if (onWorks) new BaseSearchType(baseUrl) with Queriable else new BaseSearchType(baseUrl)
}

