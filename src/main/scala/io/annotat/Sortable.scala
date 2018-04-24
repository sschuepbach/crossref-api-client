package io.annotat

trait Sortable extends Parameterisable {

  private def setSort(sort: String, order: String): Sortable = {
    addToCache("sort", sort, append = false)
    if (order == "asc" || order == "desc") addToCache("order", order, append = false)
    this
  }

  /**
    * Sort by relevance score
    *
    * @param order `asc` or `desc`
    * @return Sorting / ordering token
    */
  def sortByScore(order: String): Sortable = setSort("score", order)

  /**
    * Sort by relevance score
    *
    * @param order `asc` or `desc`
    * @return Sorting / ordering token
    */
  def sortByRelevance(order: String): Sortable = setSort("relevance", order)

  /**
    * Sort by date of most recent change to metadata. Currently the same as deposited.
    *
    * @param order `asc` or `desc`
    * @return Sorting / ordering token
    */
  def sortByUpdated(order: String): Sortable = setSort("updated", order)

  /**
    * Sort by time of most recent deposit
    *
    * @param order `asc` or `desc`
    * @return Sorting / ordering token
    */
  def sortByDeposited(order: String): Sortable = setSort("deposited", order)

  /**
    * Sort by time of most recent index
    *
    * @param order `asc` or `desc`
    * @return Sorting / ordering token
    */
  def sortByIndexed(order: String): Sortable = setSort("indexed", order)

  /**
    * Sort by publication date
    *
    * @param order `asc` or `desc`
    * @return Sorting / ordering token
    */
  def sortByPublished(order: String): Sortable = setSort("published", order)

  /**
    * Sort by print publication date
    *
    * @param order `asc` or `desc`
    * @return Sorting / ordering token
    */
  def sortByPublishedPrint(order: String): Sortable = setSort("published-print", order)

  /**
    * Sort by online publication date
    *
    * @param order `asc` or `desc`
    * @return Sorting / ordering token
    */
  def sortByPublishedOnline(order: String): Sortable = setSort("published-online", order)

  /**
    * Sort by issued date (earliest known publication date)
    *
    * @param order `asc` or `desc`
    * @return Sorting / ordering token
    */
  def sortByIssued(order: String): Sortable = setSort("issued", order)

  /**
    * Sort by number of references to documents
    *
    * @param order `asc` or `desc`
    * @return Sorting / ordering token
    */
  def sortByIsReferencedByCount(order: String): Sortable = setSort("is-referenced-by-count", order)

  /**
    * Sort by number of references made by documents
    *
    * @param order `asc` or `desc`
    * @return Sorting / ordering token
    */
  def sortByReferencesCount(order: String): Sortable = setSort("references-count", order)

}
