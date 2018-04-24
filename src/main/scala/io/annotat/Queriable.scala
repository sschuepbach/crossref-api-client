package io.annotat

/**
  * Contains query categories
  */
trait Queriable extends Parameterisable {

  import io.annotat.Utils._


  private def setQuery(name: String, value: String): Queriable = {
    addToCache(name, value, append = false)
    this
  }

  /**
    * Query all
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inAll(v: String): Queriable = setQuery("query", v.urlEncode)

  /**
    * Query title and subtitle
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inTitle(v: String): Queriable = setQuery("query.title", v.urlEncode)

  /**
    * Query container-title aka. publication name
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inContainerTitle(v: String): Queriable = setQuery("query.container-title", v.urlEncode)

  /**
    * Query author given and family names
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inAuthor(v: String): Queriable = setQuery("query.author", v.urlEncode)

  /**
    * Query editor given and family names
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inEditor(v: String): Queriable = setQuery("query.editor", v.urlEncode)

  /**
    * Query chair given and family names
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inChair(v: String): Queriable = setQuery("query.chair", v.urlEncode)

  /**
    * Query translator given and family names
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inTranslator(v: String): Queriable = setQuery("query.translator", v.urlEncode)

  /**
    * Query author, editor, chair and translator given and family names
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inContributor(v: String): Queriable = setQuery("query.contributor", v.urlEncode)

  /**
    * Query bibliographic infomration, useful for citation look up. Includes titles, authors, ISSNs and publication years
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inBibliographicInformation(v: String): Queriable = setQuery("query.bibliographic", v.urlEncode)

  /**
    * Query contributor affiliations
    *
    * @param v Search value
    * @return Search key-value pair
    */
  def inAffiliation(v: String): Queriable = setQuery("query.affiliation", v.urlEncode)

}
