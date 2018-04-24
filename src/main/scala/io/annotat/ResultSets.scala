package io.annotat

object ResultSets {

  case class Date(`date-parts`: List[DateParts],
                  `date-time`: String,
                  timestamp: Long)

  case class DateParts(year: Int,
                       month: Int,
                       day: Int)

  case class UpdateTo(updated: Date,
                      label: String,
                      doi: String,
                      `type`: String)

  case class License(url: String,
                     start: Date,
                     `delay-in-days`: Int,
                     `content-version`: String)

  case class Funder(doi: String,
                    name: String,
                    `doi-asserted-by`: String,
                    award: List[String])

  case class ContentDomain(domain: List[String], // TODO: Unclear if String
                           `crossmark-restriction`: Boolean)

  case class Author(given: String,
                    family: String,
                    affilation: List[String],
                    suffix: String,
                    name: String) // TODO: Unclear if String

  case class PublishedOnline(`date-parts`: List[DateParts])

  case class Reference(issue: String,
                       key: String,
                       `first-page`: String,
                       `article-title`: String,
                       `journal-title`: String,
                       `volume-title`: String,
                       volume: String,
                       author: String,
                       year: String,
                       doi: String,
                       `doi-asserted-by`: String,
                       edition: String,
                       unstructured: String
                      )

  case class Link(url: String,
                  `content-type`: String,
                  `content-version`: String,
                  `intended-application`: String)

  case class Relation(cities: List[String]) // TODO: Unclear if String

  case class IssnType(value: String,
                      `type`: String)

  case class Assertion(name: String,
                       order: String,
                       label: String,
                       value: String,
                       url: String)

  case class Editor(given: String,
                    family: String)

  case class Work(indexed: Date,
                  `update-to`: UpdateTo,
                  `reference-count`: Int,
                  publisher: String,
                  `publisher-location`: String,
                  editor: Editor,
                  license: List[License],
                  funder: List[Funder],
                  `content-domain`: ContentDomain,
                  `short-container-title`: List[String],
                  doi: String,
                  `type`: String,
                  created: Date,
                  page: String,
                  source: String,
                  `is-referenced-by-count`: Int,
                  title: List[String],
                  prefix: String,
                  volume: String,
                  author: List[Author],
                  member: String,
                  `published-online`: PublishedOnline,
                  `published-print`: DateParts,
                  reference: List[Reference],
                  `container-title`: List[String],
                  link: Link,
                  deposited: Date,
                  score: Double,
                  issued: DateParts,
                  `references-count`: Int,
                  url: String,
                  relation: Relation,
                  issn: List[String],
                  `issn-type`: List[IssnType],
                  subject: List[String],
                  assertion: Assertion,
                  `abstract`: String,
                  `update-policy`: String
                 ) extends ItemSet

  case class Query(`start-index`: Int,
                   `search-terms`: String)

  case class Message(`items-per-page`: Int,
                     query: Query,
                     `total-results`: Int,
                     items: List[ItemSet]
                    )

  case class Body(status: String,
                  `message-type`: String,
                  `message-version`: String,
                  message: Message)

  trait ItemSet

  trait ResultSet

}