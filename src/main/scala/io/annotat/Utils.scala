package io.annotat

import java.net.URLEncoder

object Utils {

  implicit class urlEncodedString(val s: String) {
    def urlEncode: String = {
      URLEncoder.encode(s, "UTF-8")
    }
  }

}
