abstract class Osoba(val imie:String, val nazwisko:String) {
  val podatek:Double
}

trait Pracownik extends Osoba{
  var pensja:Double = 2000.00
  override val podatek: Double = 0.2 * pensja
}

trait Student extends Osoba{
  override val podatek: Double = 0.0
}

trait Nauczyciel extends Pracownik {
  override val podatek: Double = 0.1 * pensja
}