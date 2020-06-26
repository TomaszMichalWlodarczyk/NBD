import scala.annotation.tailrec

object Scala_Zadanie {

  def rtrim(s: String, x: String): String = s.replaceAll(x + "+$", "")
  def ltrim(s: String, x: String) = s.replaceAll("^" + x, "")
  def numberList = 1 :: 2 :: 0 :: 3 :: 5 :: 0 :: (-5) :: 11 :: Nil

  def recursiveForward[T](l: List[T]): String = {
    if (l.isEmpty) {
      return ""
    }
    l.head + ", " + recursiveForward(l.tail)
  }

  def recursiveBackward(l: List[String]): String = {
    if (l.isEmpty) {
      return ""
    }
    recursiveBackward(l.tail) + "," + l.head
  }

  @tailrec
  def tailRecursion(l: List[String], acc:String):String = {
    if(l.isEmpty) {
      acc
    } else {
      tailRecursion(l.tail, acc + "," + l.head)
    }
  }

  def foldlExample(l:List[String]) = {
    rtrim(l.foldLeft("")(_ + _ + ","), ",")
  }

  def foldrExample(l:List[String]) = {
    rtrim(l.foldRight("")(_ + "," + _), ",")
  }

  @tailrec
  def zeroRemoval(l:List[Int], acc:List[Int]):List[Int] = {
    if (l.isEmpty) {
      return acc
    }
    if (l.head != 0) {
      zeroRemoval(l.tail, acc :+ l.head)
    }
    else {
      zeroRemoval(l.tail, acc)
    }
  }

  def incrementListItems(l:List[Int], increment:Int) = {
    l.map(x => x + increment)
  }

  def filterAndProcessList(l:List[Int]) = {
    l.filter(x => x >= (-5) && x <= 12).map(_.abs)
  }

  def main(args: Array[String]): Unit = {

    println("---1---")
    var daysOfWeek = "Poniedzialek" :: "Wtorek" :: "Sroda" :: "Czwartek" :: "Piatek" :: "Sobota" :: "Niedziela" :: Nil

    println("a")
    for (i <- daysOfWeek) {
      println(i)
    }

    println("b")
    for (i <- daysOfWeek if i.startsWith("P")) {
      println(i)
    }

    println("c")
    daysOfWeek.foreach(println)

    println("---2---")
    println("a")
    println(rtrim(recursiveForward(daysOfWeek), ","))

    println("b")
    println(ltrim(recursiveBackward(daysOfWeek), ","))

    println("---3---")
    println(ltrim(tailRecursion(daysOfWeek, ""), ","))

    println("---4---")
    println("a")
    println(foldlExample(daysOfWeek))

    println("b")
    println(foldrExample(daysOfWeek))

    println("c")
    var res1h = daysOfWeek.foldRight("") { (i, acc) =>
      if (i.startsWith("P")) {
        acc + i + "\n"
      }
      else {
        acc
      }
    }
    println(res1h)

    println("---5---")
    var map1 = Map("Monitor" -> 1000.00, "Myszka" -> 50.00, "Klawiatura" -> 300.00)
    var map2 = map1 map {case (k, v) => (k, v * 0.9) }
    println(map2)

    println("---6---")
    val f: ((String, Int, Boolean)) => Any = {
      case (a, b, c) =>
        println(a)
        println(b)
        println(c)
    }
    var tupl = ("String", 500, false)
    f(tupl)

    println("---7---")
    var m1 = Map("Monitor" -> 1000.00, "Myszka" -> 50.00, "Klawiatura" -> 300.00)
    def show(x: Option[Double]) = x match {
      case Some(s) => s
      case None => "None"
    }

    println(show(m1.get("Monitor")))
    println(show(m1.get("Laptop")))

    println("---8---")
    println(recursiveForward(zeroRemoval(numberList, List[Int]())))

    println("---9---")
    println(recursiveForward(incrementListItems(numberList, 1)))

    println("---10---")
    println(recursiveForward(filterAndProcessList(numberList)))
  }
}
