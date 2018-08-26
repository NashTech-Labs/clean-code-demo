package edu.knolx.conventions.objects.ds.third.party.library

import edu.knolx.conventions.objects.ds.foreign.library.Dictionary

class Translation(val dictionary: Dictionary)  {
  def translate(s: String): String =
    dictionary.translate(s)
}
