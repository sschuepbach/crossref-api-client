package io.annotat

trait Parameterisable {

  final protected var paramCache: Map[String, String] = Map()

  protected def addToCache(key: String, value: String, append: Boolean): Unit = paramCache =
    if (append) {
      if (paramCache.contains(key)) {
        paramCache + (key -> (paramCache.get(key) + "," + value))
      } else {
        paramCache + (key -> value)
      }
    } else {
      paramCache + (key -> value)
    }

}
