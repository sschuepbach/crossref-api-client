package io.annotat

trait Facetable extends Parameterisable {

  private def setFacet(facet: String, number: Int): Facetable = {
    addToCache("facet", facet + ":" + (if (number <= 0) "*" else number.toString), append = true)
    this
  }

  /**
    * Author affiliation
    *
    * @param number Number of shown aggregations. 0 = all
    * @return Facet key-value pair
    */
  def facetAffiliation(number: Int): Facetable = setFacet("affiliation", number)

  /**
    * Earliest year of publication, synonym for published
    *
    * @param number Number of shown aggregations. 0 = all
    * @return Facet key-value pair
    */
  def facetYear(number: Int): Facetable = setFacet("name", number)

  /**
    * Funder literal name as deposited alongside DOIs
    *
    * @param number Number of shown aggregations. 0 = all
    * @return Facet key-value pair
    */
  def facetFunderName(number: Int): Facetable = setFacet("funder-name", number)

  /**
    * Funder DOI
    *
    * @param number Number of shown aggregations. 0 = all
    * @return Facet key-value pair
    */
  def facetFunderDoi(number: Int): Facetable = setFacet("funder-doi", number)

  /**
    * Contributor ORCID
    *
    * @param number Number of shown aggregations. Max 100
    * @return Facet key-value pair
    */
  def facetOrcid(number: Int): Facetable = setFacet("orcid", number)

  /**
    * Work container title, such as journal title, or book title
    *
    * @param number Number of shown aggregations. Max 100
    * @return Facet key-value pair
    */
  def facetContainerTitle(number: Int): Facetable = setFacet("container-title", number)

  /**
    * Custom Crossmark assertion name
    *
    * @param number Number of shown aggregations. 0 = all
    * @return Facet key-value pair
    */
  def facetAssertion(number: Int): Facetable = setFacet("assertion", number)

  /**
    * Archive location
    *
    * @param number Number of shown aggregations. 0 = all
    * @return Facet key-value pair
    */
  def facetArchive(number: Int): Facetable = setFacet("", number)

  /**
    * Significant update type
    *
    * @param number Number of shown aggregations. 0 = all
    * @return Facet key-value pair
    */
  def facetUpdateType(number: Int): Facetable = setFacet("", number)

  /**
    * Journal ISSN (any - print, electronic, link)
    *
    * @param number Number of shown aggregations. Max 100
    * @return Facet key-value pair
    */
  def facetIssn(number: Int): Facetable = setFacet("", number)

  /**
    * Earliest year of publication
    *
    * @param number Number of shown aggregations. 0 = all
    * @return Facet key-value pair
    */
  def facetPublished(number: Int): Facetable = setFacet("", number)

  /**
    * Work type name, such as journal-article or book-chapter
    *
    * @param number Number of shown aggregations. 0 = all
    * @return Facet key-value pair
    */
  def facetTypeName(number: Int): Facetable = setFacet("type-name", number)

  /**
    * License URI of work
    *
    * @param number Number of shown aggregations. 0 = all
    * @return Facet key-value pair
    */
  def facetLicense(number: Int): Facetable = setFacet("license", number)

  /**
    * Category name of work
    *
    * @param number Number of shown aggregations. 0 = all
    * @return Facet key-value pair
    */
  def facetCategoryName(number: Int): Facetable = setFacet("category-name", number)

  /**
    * Relation type described by work or described by another work with work as object
    *
    * @param number Number of shown aggregations. 0 = all
    * @return Facet key-value pair
    */
  def facetRelationType(number: Int): Facetable = setFacet("relation-type", number)

  /**
    * Custom Crossmark assertion group name
    *
    * @param number Number of shown aggregations. 0 = all
    * @return Facet key-value pair
    */
  def facetAssertionGroup(number: Int): Facetable = setFacet("assertion-group", number)

}
