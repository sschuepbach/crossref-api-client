package io.annotat

trait Filterable {

  type Param = (String, String)

  private var filterCache: String = ""

  private def appendFilterToParams(k: String, v: String) = {
    filterCache = (if (!filterCache.isEmpty) filterCache + ",") + k + ":" + v
    ("filter", filterCache)
  }

  private def appendFlagToParams(flag: String) = {
    filterCache = (if (!filterCache.isEmpty) filterCache + ",") + flag
    ("filter", filterCache + "," + flag)
  }

  /**
    * Filters metadata which includes one or more funder entry
    *
    * @return Filter key-value pair
    */
  def hasFunder: Param = appendFlagToParams("has-funder")

  /**
    * Filters metadata which include the `{funder_id}` in FundRef data
    *
    * @param funder_id funder_id
    * @return Filter key-value pair
    */
  def filterOnFunder(funder_id: String): Param = appendFilterToParams("funder", funder_id)

  def filterOnLocation(location: String): Param = appendFilterToParams("location", location)

  def filterOnPrefix(owner_prefix: String): Param = appendFilterToParams("prefix", owner_prefix)

  def filterOnMember(member_id: String): Param = appendFilterToParams("member", member_id)

  def filterFromIndexDate(date: String): Param = appendFilterToParams("from-index-date", date)

  def filterUntilIndexDate(date: String): Param = appendFilterToParams("until-index-date", date)

  def filterFromDepositDate(date: String): Param = appendFilterToParams("from-deposit-date", date)

  def filterUntilDepositDate(date: String): Param = appendFilterToParams("until-deposit-date", date)

  def filterFromUpdateDate(date: String): Param = appendFlagToParams("from-update-Date")

  /**
    * Filters metadata updated before (inclusive) `{date}`. Currently the same as until-deposit-date.
    *
    * @param date A date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterUntilUpdateDate(date: String): Param = appendFilterToParams("until-update-date", date)

  /**
    * Filters metadata first deposited since (inclusive) `{date}`
    *
    * @param date A date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterFromCreatedDate(date: String): Param = appendFilterToParams("from-created-date", date)

  /**
    * Filters metadata first deposited before (inclusive) `{date}`
    *
    * @param date A date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterUntilCreatedDate(date: String): Param = appendFilterToParams("until-created-date", date)

  /**
    * Filters metadata where published date is since (inclusive) `{date}`
    *
    * @param date A date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterFromPubDate(date: String): Param = appendFilterToParams("from-pub-date", date)

  /**
    * Filters metadata where published date is before (inclusive) `{date}`
    *
    * @param date A date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterUntilPubDate(date: String): Param = appendFilterToParams("until-pub-date", date)

  /**
    * Filters metadata where online published date is since (inclusive) `{date}`
    *
    * @param date A date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterFromOnlinePubDate(date: String): Param = appendFilterToParams("from-online-pub-date", date)

  /**
    * Filters metadata where online published date is before (inclusive) `{date}`
    *
    * @param date A date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterUntilOnlinePubDate(date: String): Param = appendFilterToParams("until-online-pub-date", date)

  /**
    * Filters metadata where print published date is since (inclusive) `{date}`
    *
    * @param date A date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterFromPrintPubDate(date: String): Param = appendFilterToParams("from-print-pub-date", date)

  /**
    * Filters metadata where print published date is before (inclusive) `{date}`
    *
    * @param date A date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterUntilPrintPubDate(date: String): Param = appendFilterToParams("until-print-pub-date", date)

  /**
    * Filters metadata where posted date is since (inclusive) `{date}`
    *
    * @param date A date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterFromPostedDate(date: String): Param = appendFilterToParams("from-posted-date", date)

  /**
    * Filters metadata where posted date is before (inclusive) `{date}`
    *
    * @param date A date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterUntilPostedDate(date: String): Param = appendFilterToParams("until-posted-date", date)

  /**
    * Filters metadata where accepted date is since (inclusive) `{date}`
    *
    * @param date A date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterFromAcceptedDate(date: String): Param = appendFilterToParams("from-accepted-date", date)

  /**
    * Filters metadata where accepted date is before (inclusive) `{date}`
    *
    * @param date A date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterUntilAcceptedDate(date: String): Param = appendFilterToParams("until-accepted-date", date)

  /**
    * Filters metadata that includes any <license_ref> elements.
    *
    * @return Filter key-value pair
    */
  def hasLicense: Param = appendFlagToParams("has-license")

  /**
    * Filters metadata where <license_ref> value equals `{url}`
    *
    * @param
    * @return Filter key-value pair
    */
  def filterLicenseUrl(url: String): Param = appendFilterToParams("license.url", url)

  /**
    * Filters metadata where the <license_ref>'s applies_to attribute is `{string}`
    *
    * @param
    * @return Filter key-value pair
    */
  def filterLicenseVersion(appliesTo: String): Param = appendFilterToParams("license.version", appliesTo)

  /**
    * Filters metadata where difference between publication date and the <license_ref>'s start_date attribute is <= `{integer}` (in days)
    *
    * @param
    * @return Filter key-value pair
    */
  def filterLicenseDelay(delay: Integer) = appendFlagToParams("license.delay", delay)

  /**
    * Filters metadata that includes any full text <resource> elements.
    *
    * @param
    * @return Filter key-value pair
    */
  def filterHasFullText: Param = appendFlagToParams("has-full-text")

  /**
    * Filters metadata where <resource> element's content_version attribute is `{string}`.
    *
    * @param
    * @return Filter key-value pair
    */
  def filterFullTextVersion(contentVersion: String): Param = appendFilterToParams("full-text.version", contentVersion)

  /**
    * Filters metadata where <resource> element's content_type attribute is `{mime_type}` (e.g. application/pdf).
    *
    * @param
    * @return Filter key-value pair
    */
  def filterFullTextType(mimeType: String): Param = appendFilterToParams("full-text.type", mimeType)

  /**
    * Filters metadata where <resource> link has one of the following intended applications: text-mining, similarity-checking or unspecified
    *
    * @param
    * @return Filter key-value pair
    */
  def filterFullTextApplication(application: String): Param = appendFilterToParams("full-text.application", application)

  /**
    * Filters metadata for works that have a list of references
    *
    * @return Filter key-value pair
    */
  def hasReferences: Param = appendFlagToParams("has-references")

  /**
    * Filters metadata which include name of archive partner
    *
    * @return Filter key-value pair
    */
  def hasArchiveName: Param = appendFlagToParams("has-archive")

  /**
    * Filters metadata which where value of archive partner is `{string}`
    *
    * @param
    * @return Filter key-value pair
    */
  def filterArchive(archive: String): Param = appendFilterToParams("archive", archive)

  /**
    * Filters metadata which includes one or more ORCIDs
    *
    * @param
    * @return Filter key-value pair
    */
  def hasOrcid: Param = appendFlagToParams("has-orcid")

  /**
    * Filters metadata which includes one or more ORCIDs where the depositing publisher claims to have witness the ORCID owner authenticate with ORCID
    *
    * @param
    * @return Filter key-value pair
    */
  def hasAuthenticatedOrcid: Param = appendFlagToParams("has-authenticated-orcid")

  /**
    * Filters metadata where <orcid> element's value = `{orcid}`
    *
    * @param
    * @return Filter key-value pair
    */
  def filterOrcid(orcid: String): Param = appendFilterToParams("orcid", orcid)

  /**
    * Filters metadata where record has an ISSN = `{issn}`. Format is xxxx-xxxx.
    *
    * @param
    * @return Filter key-value pair
    */
  def filterIssn(issn: String): Param = appendFilterToParams("issn", issn)

  /**
    * Filters metadata records whose type = `{type}`. Type must be an ID value from the list of types returned by the /types resource
    *
    * @param
    * @return Filter key-value pair
    */
  def filterType(recordType: String): Param = appendFilterToParams("type", recordType)

  /**
    * Filters metadata records whose article or serial are mentioned in the given `{directory}`. Currently the only supported value is doaj.
    *
    * @param
    * @return Filter key-value pair
    */
  def filterDirectory(directory: String): Param = appendFilterToParams("directory", directory)

  /**
    * Filters metadata describing the DOI `{doi}`
    *
    * @param
    * @return Filter key-value pair
    */
  def filterDoi(doi: String): Param = appendFilterToParams("doi", doi)

  /**
    * Filters metadata for records that represent editorial updates to the DOI `{doi}`
    *
    * @param
    * @return Filter key-value pair
    */
  def filterUpdated(doi: String): Param = appendFilterToParams("updates", doi)

  /**
    * Filters metadata for records that represent editorial updates
    *
    * @param
    * @return Filter key-value pair
    */
  def isEditorialUpdate: Param = appendFlagToParams("is-update")

  /**
    * Filters metadata for records that include a link to an editorial update policy
    *
    * @return Filter key-value pair
    */
  def hasUpdatePolicy: Param = appendFlagToParams("has-update-policy")

  /**
    * Filters metadata for records with a publication title exactly with an exact match
    *
    * @return Filter key-value pair
    */
  def hasContainerTitle: Param = appendFlagToParams("container-title")

  /**
    * Filters metadata for records with an exact matching category label. Category labels come from this list published by Scopus
    *
    * @return Filter key-value pair
    */
  def hasMatchingCategoryName: Param = appendFlagToParams("category-name")

  /**
    * Filters metadata for records with type matching a type identifier (e.g. journal-article)
    *
    * @return Filter key-value pair
    */
  def hasTypeIdentifier: Param = appendFlagToParams("type")

  /**
    * Filters metadata for records with an exacty matching type label
    *
    * @return Filter key-value pair
    */
  def hasMatchingTypeLabel: Param = appendFlagToParams("type-name")

  /**
    * Filters metadata for records with a matching award number. Optionally combine with award.funder
    *
    * @param
    * @return Filter key-value pair
    */
  def filterAwardNumber(awardNumber: String): Param = appendFilterToParams("award.number", awardNumber)

  /**
    * Filters metadata for records with an award with matching funder. Optionally combine with award.number
    *
    * @param
    * @return Filter key-value pair
    */
  def filterAwardFunder(funderDoi: String): Param = appendFilterToParams("award.funder", funderDoi)

  /**
    * Filters metadata for records with any assertions
    *
    * @return Filter key-value pair
    */
  def hasAnyAssertion: Param = appendFlagToParams("has-assertion")

  /**
    * Filters metadata for records with an assertion in a particular group
    *
    * @return Filter key-value pair
    */
  def hasAssertionGroup: Param = appendFlagToParams("assertion-group")

  /**
    * Filters metadata for records with a particular named assertion
    *
    * @return Filter key-value pair
    */
  def hasAssertion: Param = appendFlagToParams("assertion")

  /**
    * Filters metadata for records that have any affiliation information
    *
    * @return Filter key-value pair
    */
  def hasAnyAffiliation: Param = appendFlagToParams("has-affiliation")

  /**
    * Filters metadata for records with the given alternative ID, which may be a publisher-specific ID, or any other identifier a publisher may have provided
    *
    * @return Filter key-value pair
    */
  def hasAlternativeId: Param = appendFlagToParams("alternative-id")

  /**
    * Filters metadata for records with a given article number
    *
    * @return Filter key-value pair
    */
  def hasArticleNumber: Param = appendFlagToParams("article-number")

  /**
    * Filters metadata for records which include an abstract
    *
    * @return Filter key-value pair
    */
  def hasAbstract: Param = appendFlagToParams("has-abstract")

  /**
    * Filters metadata for records which include a clinical trial number
    *
    * @return Filter key-value pair
    */
  def hasClinicalTrialNumber: Param = appendFlagToParams("has-clinical-trial-number")

  /**
    * Filters metadata where the publisher records a particular domain name as the location Crossmark content will appear
    *
    * @return Filter key-value pair
    */
  def hasContentDomain: Param = appendFlagToParams("content-domain")

  /**
    * Filters metadata where the publisher records a domain name location for Crossmark content
    *
    * @param
    * @return Filter key-value pair
    */
  def hasContentDomain: Param = appendFlagToParams("has-content-domain")

  /**
    * Filters metadata where the publisher restricts Crossmark usage to content domains
    *
    * @return Filter key-value pair
    */
  def hasCrossmarkRestriction: Param = appendFlagToParams("has-crossmark-restriction")

  /**
    * Filters metadata for records that either assert or are the object of a relation
    *
    * @return Filter key-value pair
    */
  def hasRelation: Param = appendFlagToParams("has-relation")

  /**
    * Filters One of the relation types from the Crossref relations schema (e.g. is-referenced-by, is-parent-of, is-preprint-of)
    *
    * @return Filter key-value pair
    */
  def relationHasType: Param = appendFlagToParams("relation.type")

  /**
    * Filters Relations where the object identifier matches the identifier provided
    *
    * @return Filter key-value pair
    */
  def relationHasObject: Param = appendFlagToParams("relation.object")

  /**
    * Filters One of the identifier types from the Crossref relations schema (e.g. doi, issn)
    *
    * @return Filter key-value pair
    */
  def relationHasObjectType: Param = appendFlagToParams("relation.object-type")

}
