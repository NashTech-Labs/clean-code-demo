package edu.knolx.conventions.objects.ds.foreign.library

trait Language

case object Spanish extends Language

sealed trait Dictionary {
  def language: Language
  def translate(s: String): String
}

case class ScientificDictionary(language: Language) extends Dictionary {
  override def translate(s: String): String = ???
}
case class MedicalDictionary(language: Language) extends Dictionary {
  override def translate(s: String): String = ???
}
case class SlangDictionary(language: Language) extends Dictionary {
  override def translate(s: String): String = ???
}
