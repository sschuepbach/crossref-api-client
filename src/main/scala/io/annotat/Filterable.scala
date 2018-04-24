package io.annotat

trait Filterable extends Parameterisable {

  import Utils._

  private def setFilter(key: String, value: String): Filterable = {
    addToCache("filter", s"$key:${value.urlEncode}", append = true)
    this
  }

  private def setFlag(flag: String): Filterable = {
    addToCache("filter", flag.urlEncode, append = true)
    this
  }

  /**
    * Filters metadata which includes one or more funder entry
    *
    * @return Filter key-value pair
    */
  def hasFunder: Filterable = setFlag("has-funder")

  /**
    * Filters metadata which include the `{funder_id}` in FundRef data
    *
    * @param funderId `funder_id` in FundRef data
    * @return Filter key-value pair
    */
  def filterOnFunderId(funderId: String): Filterable = setFilter("funder", funderId)

  /**
    * Filters funder records where location = `{country name}`. Only works on `/funders` route
    *
    * @param location Country name
    * @return
    */
  def filterOnLocation(location: String): Filterable = setFilter("location", location)

  /**
    * Filters metadata belonging to a DOI owner prefix `{owner_prefix}` (e.g. `10.1016` )
    *
    * @param ownerPrefix DOI owner prefix
    * @return
    */
  def filterOnPrefix(ownerPrefix: String): Filterable = setFilter("prefix", ownerPrefix)

  /**
    * Filters metadata belonging to a CrossRef member
    *
    * @param memberId Id of CrossRef member
    * @return
    */
  def filterOnMember(memberId: String): Filterable = setFilter("member", memberId)

  /**
    * Filters metadata indexed since (inclusive) `{date}`
    *
    * @param date Start date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return
    */
  def filterFromIndexDate(date: String): Filterable = setFilter("from-index-date", date)

  /**
    * Filters metadata indexed before (inclusive) `{date}`
    *
    * @param date End date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return
    */
  def filterUntilIndexDate(date: String): Filterable = setFilter("until-index-date", date)

  /**
    * Filters metadata last (re)deposited since (inclusive) `{date}`
    *
    * @param date Start date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return
    */
  def filterFromDepositDate(date: String): Filterable = setFilter("from-deposit-date", date)

  /**
    * Filters metadata last (re)deposited before (inclusive) `{date}`
    *
    * @param date End date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return
    */
  def filterUntilDepositDate(date: String): Filterable = setFilter("until-deposit-date", date)

  /**
    * Filters Metadata updated since (inclusive) `{date}`. Currently the same as `from-deposit-date`.
    *
    * @param date Start date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return
    */
  def filterFromUpdateDate(date: String): Filterable = setFlag("from-update-Date")

  /**
    * Filters metadata updated before (inclusive) `{date}`. Currently the same as `until-deposit-date`.
    *
    * @param date End date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterUntilUpdateDate(date: String): Filterable = setFilter("until-update-date", date)

  /**
    * Filters metadata first deposited since (inclusive) `{date}`
    *
    * @param date Start date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterFromCreatedDate(date: String): Filterable = setFilter("from-created-date", date)

  /**
    * Filters metadata first deposited before (inclusive) `{date}`
    *
    * @param date End date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterUntilCreatedDate(date: String): Filterable = setFilter("until-created-date", date)

  /**
    * Filters metadata where published date is since (inclusive) `{date}`
    *
    * @param date Start date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterFromPubDate(date: String): Filterable = setFilter("from-pub-date", date)

  /**
    * Filters metadata where published date is before (inclusive) `{date}`
    *
    * @param date End date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterUntilPubDate(date: String): Filterable = setFilter("until-pub-date", date)

  /**
    * Filters metadata where online published date is since (inclusive) `{date}`
    *
    * @param date Start date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterFromOnlinePubDate(date: String): Filterable = setFilter("from-online-pub-date", date)

  /**
    * Filters metadata where online published date is before (inclusive) `{date}`
    *
    * @param date End date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterUntilOnlinePubDate(date: String): Filterable = setFilter("until-online-pub-date", date)

  /**
    * Filters metadata where print published date is since (inclusive) `{date}`
    *
    * @param date Start date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterFromPrintPubDate(date: String): Filterable = setFilter("from-print-pub-date", date)

  /**
    * Filters metadata where print published date is before (inclusive) `{date}`
    *
    * @param date End date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterUntilPrintPubDate(date: String): Filterable = setFilter("until-print-pub-date", date)

  /**
    * Filters metadata where posted date is since (inclusive) `{date}`
    *
    * @param date Start date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterFromPostedDate(date: String): Filterable = setFilter("from-posted-date", date)

  /**
    * Filters metadata where posted date is before (inclusive) `{date}`
    *
    * @param date End date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterUntilPostedDate(date: String): Filterable = setFilter("until-posted-date", date)

  /**
    * Filters metadata where accepted date is since (inclusive) `{date}`
    *
    * @param date Start date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterFromAcceptedDate(date: String): Filterable = setFilter("from-accepted-date", date)

  /**
    * Filters metadata where accepted date is before (inclusive) `{date}`
    *
    * @param date End date: YYYY-MM-DD, YYYY-MM or YYYY. Skipped months or days are replaced by 01, eg. 2017 = 2017-01-01
    * @return Filter key-value pair
    */
  def filterUntilAcceptedDate(date: String): Filterable = setFilter("until-accepted-date", date)

  /**
    * Filters metadata that includes any `<license_ref>` elements.
    *
    * @return Filter key-value pair
    */
  def hasLicense: Filterable = setFlag("has-license")

  /**
    * Filters metadata where `<license_ref>` value equals `{url}`
    *
    * @param url License url
    * @return Filter key-value pair
    */
  def filterLicenseUrl(url: String): Filterable = setFilter("license.url", url)

  /**
    * Filters metadata where the `<license_ref>`'s `applies_to` attribute is `{string}`
    *
    * @param appliesTo String
    * @return Filter key-value pair
    */
  def filterLicenseVersion(appliesTo: String): Filterable = setFilter("license.version", appliesTo)

  /**
    * Filters metadata where difference between publication date and the `<license_ref>`'s `start_date` attribute is <= `{integer}` (in days)
    *
    * @param delay Difference between publication date and the `start_date` attribute in days
    * @return Filter key-value pair
    */
  def filterLicenseDelay(delay: Integer): Filterable = setFilter("license.delay", delay.toString)

  /**
    * Filters metadata that includes any full text `<resource>` elements.
    *
    * @return Filter key-value pair
    */
  def filterHasFullText: Filterable = setFlag("has-full-text")

  /**
    * Filters metadata where `<resource>` element's `content_version` attribute is `{string}`.
    *
    * @param contentVersion `content_version` attribute
    * @return Filter key-value pair
    */
  def filterFullTextVersion(contentVersion: String): Filterable = setFilter("full-text.version", contentVersion)

  /**
    * Filters metadata where `<resource>` element's `content_type` attribute is `{mime_type}` (e.g. `application/pdf`).
    *
    * @param mimeType Mime type of `<resource>`
    * @return Filter key-value pair
    */
  def filterFullTextType(mimeType: String): Filterable = setFilter("full-text.type", mimeType)

  /**
    * Filters metadata where `<resource>` link has one of the following intended applications: `text-mining`, `similarity-checking` or `unspecified`
    *
    * @param application Intended application. Possible values are `text-mining`, `similarity-checking` or `unspecified`
    * @return Filter key-value pair
    */
  def filterFullTextApplication(application: String): Filterable = setFilter("full-text.application", application)

  /**
    * Filters metadata for works that have a list of references
    *
    * @return Filter key-value pair
    */
  def hasReferences: Filterable = setFlag("has-references")

  /**
    * Filters metadata which include name of archive partner
    *
    * @return Filter key-value pair
    */
  def hasArchiveName: Filterable = setFlag("has-archive")

  /**
    * Filters metadata which where value of archive partner is `{string}`
    *
    * @param archive Name of archive
    * @return Filter key-value pair
    */
  def filterArchive(archive: String): Filterable = setFilter("archive", archive)

  /**
    * Filters metadata which includes one or more ORCIDs
    *
    * @return Filter key-value pair
    */
  def hasOrcid: Filterable = setFlag("has-orcid")

  /**
    * Filters metadata which includes one or more ORCIDs where the depositing publisher claims to have witness the ORCID owner authenticate with ORCID
    *
    * @return Filter key-value pair
    */
  def hasAuthenticatedOrcid: Filterable = setFlag("has-authenticated-orcid")

  /**
    * Filters metadata where `<orcid>` element's value = `{orcid}`
    *
    * @param orcid `<orcid>` value
    * @return Filter key-value pair
    */
  def filterOrcid(orcid: String): Filterable = setFilter("orcid", orcid)

  /**
    * Filters metadata where record has an ISSN = `{issn}`. Format is `xxxx-xxxx`.
    *
    * @param issn ISSN
    * @return Filter key-value pair
    */
  def filterIssn(issn: String): Filterable = setFilter("issn", issn)

  /**
    * Filters metadata records whose type = `{type}`. Type must be an ID value from the list of types returned by the `/types` resource
    *
    * @param recordType Type ID of record
    * @return Filter key-value pair
    */
  def filterType(recordType: String): Filterable = setFilter("type", recordType)

  /**
    * Filters metadata records whose article or serial are mentioned in the given `{directory}`. Currently the only supported value is `doaj`.
    *
    * @param directory Directory who mentions article or serial. Currently only `doaj` is supported
    * @return Filter key-value pair
    */
  def filterDirectory(directory: String): Filterable = setFilter("directory", directory)

  /**
    * Filters metadata describing the DOI `{doi}`
    *
    * @param doi DOI
    * @return Filter key-value pair
    */
  def filterDoi(doi: String): Filterable = setFilter("doi", doi)

  /**
    * Filters metadata for records that represent editorial updates to the DOI `{doi}`
    *
    * @param doi DOI of record which is updated by the given one
    * @return Filter key-value pair
    */
  def filterUpdated(doi: String): Filterable = setFilter("updates", doi)

  /**
    * Filters metadata for records that represent editorial updates
    *
    * @return Filter key-value pair
    */
  def isEditorialUpdate: Filterable = setFlag("is-update")

  /**
    * Filters metadata for records that include a link to an editorial update policy
    *
    * @return Filter key-value pair
    */
  def hasUpdatePolicy: Filterable = setFlag("has-update-policy")

  /**
    * Filters metadata for records with a publication title exactly with an exact match
    *
    * @return Filter key-value pair
    */
  def hasContainerTitle: Filterable = setFlag("container-title")

  /**
    * Filters metadata for records with an exact matching category label. Category labels come from [this list](https://www.elsevier.com/solutions/scopus/content) published by Scopus
    *
    * @return Filter key-value pair
    */
  def hasMatchingCategoryName: Filterable = setFlag("category-name")

  /**
    * Filters metadata for records with type matching a type identifier (e.g. `journal-article`)
    *
    * @return Filter key-value pair
    */
  def hasTypeIdentifier: Filterable = setFlag("type")

  /**
    * Filters metadata for records with an exacty matching type label
    *
    * @return Filter key-value pair
    */
  def hasMatchingTypeLabel: Filterable = setFlag("type-name")

  /**
    * Filters metadata for records with a matching award number. Optionally combine with `award.funder`
    *
    * @param awardNumber Award number
    * @return Filter key-value pair
    */
  def filterAwardNumber(awardNumber: String): Filterable = setFilter("award.number", awardNumber)

  /**
    * Filters metadata for records with an award with matching funder. Optionally combine with `award.number`
    *
    * @param funderDoi DOI of matching funder
    * @return Filter key-value pair
    */
  def filterAwardFunder(funderDoi: String): Filterable = setFilter("award.funder", funderDoi)

  /**
    * Filters metadata for records with any assertions
    *
    * @return Filter key-value pair
    */
  def hasAnyAssertion: Filterable = setFlag("has-assertion")

  /**
    * Filters metadata for records with an assertion in a particular group
    *
    * @return Filter key-value pair
    */
  def hasAssertionGroup: Filterable = setFlag("assertion-group")

  /**
    * Filters metadata for records with a particular named assertion
    *
    * @return Filter key-value pair
    */
  def hasAssertion: Filterable = setFlag("assertion")

  /**
    * Filters metadata for records that have any affiliation information
    *
    * @return Filter key-value pair
    */
  def hasAnyAffiliation: Filterable = setFlag("has-affiliation")

  /**
    * Filters metadata for records with the given alternative ID, which may be a publisher-specific ID, or any other identifier a publisher may have provided
    *
    * @return Filter key-value pair
    */
  def hasAlternativeId: Filterable = setFlag("alternative-id")

  /**
    * Filters metadata for records with a given article number
    *
    * @return Filter key-value pair
    */
  def hasArticleNumber: Filterable = setFlag("article-number")

  /**
    * Filters metadata for records which include an abstract
    *
    * @return Filter key-value pair
    */
  def hasAbstract: Filterable = setFlag("has-abstract")

  /**
    * Filters metadata for records which include a clinical trial number
    *
    * @return Filter key-value pair
    */
  def hasClinicalTrialNumber: Filterable = setFlag("has-clinical-trial-number")

  /**
    * Filters metadata where the publisher records a particular domain name as the location Crossmark content will appear
    *
    * @return Filter key-value pair
    */
  def hasParticularContentDomain: Filterable = setFlag("content-domain")

  /**
    * Filters metadata where the publisher records a domain name location for Crossmark content
    *
    * @return Filter key-value pair
    */
  def hasContentDomain: Filterable = setFlag("has-content-domain")

  /**
    * Filters metadata where the publisher restricts Crossmark usage to content domains
    *
    * @return Filter key-value pair
    */
  def hasCrossmarkRestriction: Filterable = setFlag("has-crossmark-restriction")

  /**
    * Filters metadata for records that either assert or are the object of a relation
    *
    * @return Filter key-value pair
    */
  def hasRelation: Filterable = setFlag("has-relation")

  /**
    * Filters One of the relation types from the Crossref relations schema (e.g. `is-referenced-by`, `is-parent-of`, `is-preprint-of`)
    *
    * @return Filter key-value pair
    */
  def relationHasType: Filterable = setFlag("relation.type")

  /**
    * Filters Relations where the object identifier matches the identifier provided
    *
    * @return Filter key-value pair
    */
  def relationHasObject: Filterable = setFlag("relation.object")

  /**
    * Filters One of the identifier types from the Crossref relations schema (e.g. `doi`, `issn`)
    *
    * @return Filter key-value pair
    */
  def relationHasObjectType: Filterable = setFlag("relation.object-type")

}
