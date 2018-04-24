
import scalaj.http.Http
import org.json4s.native.JsonMethods._
import org.json4s._


implicit val formats: DefaultFormats.type = DefaultFormats
val t = Http("http://api.crossref.org/works/10.3897/bdj.4.e9583")
val s = t.asString.body
val u = parse(s)
val body = u.extract[Body]
//body.message.title

// u.children.head
// u.children(3).children
//print(s)
// parse(t)


case class Date(`date-parts`: List[List[Int]],
                `date-time`: String,
                timestamp: Long)

case class DateParts(year: Int,
                     month: Int,
                     day: Int)

case class UpdateTo(updated: Date,
                    label: String,
                    DOI: String,
                    `type`: String)

case class License(URL: String,
                   start: Date,
                   `delay-in-days`: Int,
                   `content-version`: String)

case class Funder(DOI: String,
                  name: String,
                  `doi-asserted-by`: String,
                  award: List[String])

case class ContentDomain(domain: List[String], // TODO: Unclear if String
                         `crossmark-restriction`: Boolean)

case class Author(given: String,
                  family: String,
                  affilation: List[String],
                  suffix: Option[String],
                  name: Option[String]) // TODO: Unclear if String

case class PublishedOnline(`date-parts`: List[Int]) // TODO: Return to DateParts

case class Reference(issue: String,
                     key: String,
                     `first-page`: String,
                     `article-title`: String,
                     `journal-title`: String,
                     `volume-title`: String,
                     volume: String,
                     author: String,
                     year: String,
                     DOI: String,
                     `doi-asserted-by`: String,
                     edition: String,
                     unstructured: String
                    )

case class Link(URL: String,
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
                     URL: String)

case class Editor(given: String,
                  family: String)

case class Work(//indexed: Date,
                //`update-to`: Option[UpdateTo],
                //`reference-count`: Int,
                //publisher: String,
                //`publisher-location`: Option[String],
                //editor: Option[Editor],
                //license: List[License],
                //funder: List[Funder],
                //`content-domain`: ContentDomain,
//                `short-container-title`: List[String],
//                DOI: String,
//                `type`: String,
//                created: Date,
//                page: String,
//                source: String,
//                `is-referenced-by-count`: Int,
                title: List[String],
//                `original-title`: Option[String],
//                prefix: String,
//                volume: String,
//                author: List[Author],
//                member: String,
//                `published-online`: Option[PublishedOnline],
//                `published-print`: List[Int], // TODO: Return to dateparts
//                reference: Option[List[Reference]],
//                `container-title`: List[String],
//                link: Option[Link],
//                deposited: Option[Date],
//                score: Double,
//                issued: Option[List[Int]], // TODO: Return to dateparts
//                `references-count`: Int,
//                URL: String,
//                ISBN: Option[String],
//                relation: Relation,
//                ISSN: List[String],
//                `issn-type`: List[IssnType],
//                subject: List[String],
//                assertion: Option[Assertion],
//                `abstract`: Option[String],
//                `update-policy`: Option[String]
               ) extends ItemSet

case class Query(`start-index`: Int,
                 `search-terms`: String)

case class Facets()

case class Message(`items-per-page`: Int,
                   query: Query,
                   `total-results`: Int,
                   facets: Facets,
                   items: List[ItemSet]
                  )

case class Body(status: String,
                `message-type`: String,
                `message-version`: String,
                //message: Message)
                message: Work)

trait ItemSet

trait ResultSet