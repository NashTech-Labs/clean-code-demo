package edu.knolx.conventions.objects.ds.foreign.library2

trait Language

/**Dictionary v2.0*/
sealed trait Dictionary {
  def language: Language
  def translate(translationString: TranslationString): String
}

case class TranslationString(value: String, metadata: String)

case class ScientificDictionary(language: Language) extends Dictionary {
  override def translate(translationString: TranslationString): String = ???
}
case class MedicalDictionary(language: Language) extends Dictionary {
  override def translate(translationString: TranslationString): String = ???
}
case class SlangDictionary(language: Language) extends Dictionary {
  override def translate(translationString: TranslationString): String = ???
}
