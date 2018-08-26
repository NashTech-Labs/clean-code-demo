package edu.knolx.conventions.objects.ds.third.party.library2

import edu.knolx.conventions.objects.ds.foreign.library2._

class Translation(val dictionary: Dictionary) {
  def translate(s: String): String = {
    val translationString = TranslationString(s, "someMetadata")
    dictionary.translate(translationString)
  }
}

