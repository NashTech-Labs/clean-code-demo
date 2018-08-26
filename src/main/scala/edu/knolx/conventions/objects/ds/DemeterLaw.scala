package edu.knolx.conventions.objects.ds

class DemeterLawSample1 {
  import third.party.library._

  class StringConcatenation(name: String) {
    def wrongUsage(translation: Translation, s: String): String = {
      translation.dictionary.translate(s"$name$s")
      // violates the law of Demeter
      // no guarantee that the translate method may be removed or updated in future releases of the library
    }

    /**thumbs up :) */
    def rightUsage(translation: Translation, s: String): String = {
      translation.translate(s"$name$s")
    }
  }
}

class DemeterLawSample2 {
  import third.party.library2._

  class StringConcatenation(name: String) {
    def wrongUsage(translation: Translation, s: String): String ={
      translation.dictionary.translate(s"$name$s")

      // violates the law of Demeter
      // no guarantee that the translate method may be removed or deprecated in future releases of the library
    }

    /**thumbs up :) */
    def rightUsage(translation: Translation, s: String): String ={
      translation.translate(s"$name$s")
    }
  }
}
