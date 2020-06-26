import scala.annotation.tailrec

object Scala_Zadanie2 {

  @tailrec
  def passFunction(v:Int, f:Int=>Int, it:Int): Int ={
    if (it == 0)
      v
    else {
      passFunction(f(v),f,it-1)
    }
  }

  def validateStatement[T](statement:()=>T, validate:T=>Unit): Unit =
  {
    validate(statement())
  }

  def main(args: Array[String]): Unit = {

    println("---1---")
    var workDays = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "piatek")
    var freeDays = List("Sobota", "Niedziela")

    def checkDay(x: String) = x match {
        case "Poniedzialek" => "Praca"
        case "Wtorek" => "Praca"
        case "Sroda" => "Praca"
        case "Czwartek" => "Praca"
        case "Piatek" => "Praca"
        case "Sobota" => "Weekemd"
        case "Niedziela" => "Weekend"
        case _ => "Bledny dzien"
    }

    println(checkDay("Poniedzialek"))
    println(checkDay("Sobota"))
    println(checkDay("Test"))

    println("---2---")
    class KontoBankowe(_poczatkowyStanKonta: Int) {
      def this() = this(0)

      private var _stanKonta = _poczatkowyStanKonta
      def stanKonta: Int = _stanKonta

      def wplata(kwota: Int): Unit = {
        _stanKonta += kwota
      }

      def wyplata(kwota: Int): Unit = {
        _stanKonta -= kwota
      }
    }

    var konto1 = new KontoBankowe()
    println("Konto nr 1: ")
    println("Stan konta bez wartosci poczatkowej: " + konto1.stanKonta)
    konto1.wplata(15)
    println("Stan konta po wplacie 15: " + konto1.stanKonta)
    konto1.wyplata(5)
    println("Stan konta po wyplace 5: " + konto1.stanKonta)

    var konto2 = new KontoBankowe(10)
    println("Konto nr 2: ")
    println("Stan konta2 z poczatkowym stanem 10: " + konto2.stanKonta)

    println("---3---")

    case class Osoba2(imie: String, nazwisko: String) {
    }

    var person1 = Osoba2("Tomek", "Wlodarczyk")
    var person2 = Osoba2("Jan", "Kowalski")
    var person3 = Osoba2("Ala", "Makota")

    def greeting(person: Osoba2) = person match {
        case Osoba2("Tomek", "Wlodarczyk") => "Witaj Tomek"
        case Osoba2("Ala", "Makota") => "Witaj Ala"
        case _ => "Dzien dobry"
    }

    println(greeting(person1))
    println(greeting(person2))
    println(greeting(person3))


    println("---4---")
    println(passFunction(5,(x:Int) => x - 1,3))
    println(passFunction(5,(x:Int)=> x * 2,3))

    println("---5---")

    var student = new Osoba("Jan", "Koowalski") with Student
    println("Student")
    println("Imie: " + student.imie)
    println("Nazwisko: " + student.nazwisko)
    println("Podatek: " + student.podatek)
    println("----------------")

    var pracownik = new Osoba("Ala", "Makota") with Pracownik
    println("Pracownik")
    println("Imie: " + pracownik.imie)
    println("Nazwisko: " + pracownik.nazwisko)
    println("Podatek: " + pracownik.podatek)
    println("----------------")

    var nauczyciel = new Osoba("John", "Black") with Nauczyciel
    println("Nauczyciel")
    println("Imie: " + nauczyciel.imie)
    println("Nazwisko: " + nauczyciel.nazwisko)
    println("Podatek: " + nauczyciel.podatek)

  }

}