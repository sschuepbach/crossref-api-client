package io.annotat

/**
  * Contains query categories
  */
trait Queriable {

  import io.annotat.Utils._

  type Param = (String, String)

  /**
    * Query all
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inAll(v: String): Param = ("query", v.urlEncode)

  /**
    * Query title and subtitle
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inTitle(v: String): Param = ("query.title", v.urlEncode)

  /**
    * Query container-title aka. publication name
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inContainerTitle(v: String): Param = ("query.container-title", v.urlEncode)

  /**
    * Query author given and family names
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inAuthor(v: String): Param = ("query.author", v.urlEncode)

  /**
    * Query editor given and family names
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inEditor(v: String): Param = ("query.editor", v.urlEncode)

  /**
    * Query chair given and family names
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inChair(v: String): Param = ("query.chair", v.urlEncode)

  /**
    * Query translator given and family names
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inTranslator(v: String): Param = ("query.translator", v.urlEncode)

  /**
    * Query author, editor, chair and translator given and family names
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inContributor(v: String): Param = ("query.contributor", v.urlEncode)

  /**
    * Query bibliographic infomration, useful for citation look up. Includes titles, authors, ISSNs and publication years
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inBibliographicInformation(v: String): Param = ("query.bibliographic", v.urlEncode)

  /**
    * Query contributor affiliations
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inAffiliation(v: String): Param = ("query.affiliation", v.urlEncode)

}
