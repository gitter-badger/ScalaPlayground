package implicitClasses

/**
  * Created by Hierro on 4/25/16.
  */
object Example {

  /***
    * An implicit class is a class marked with the implicit keyword.
    * This keyword makes the class’ primary constructor available
    * for implicit conversions when the class is in scope.
    *
    * Restrictions:
    * 1. They must be defined inside of another trait/class/object
    * 2. They may only take one non-implicit argument in their constructor.
    *
    *    implicit class RichDate(date: java.util.Date) // OK!
    *    implicit class Indexer[T](collecton: Seq[T], index: Int) // BAD!
    *    implicit class Indexer[T](collecton: Seq[T])(implicit index: Index) // OK! - While it’s possible
    *    to create an implicit class with more than one non-implicit argument, such classes aren’t used
    *    during implicit lookup
    *
    * 3. There may not be any method, member or object in scope with the same name as the implicit class.
    *    Note: This means an implicit class cannot be a case class.
    *
    *    object Bar
    *    implicit class Bar(x: Int) // BAD!
    *    val x = 5
    *    implicit class x(y: Int) // BAD!
    *    implicit case class Baz(x: Int) // BAD!
    *
    */

  implicit class IntWithTimes(x: Int) {
    def times[A](f: => A): Unit = {
      def loop(current: Int): Unit =
        if(current > 0) {
          f
          loop(current - 1)
        }
      loop(x)
    }
  }

  implicit class StringToInt(s: String) {
    def getNumber = s.toInt
    def getDouble = s.toDouble
  }

}

object ImplicitClassTester extends App {
  import Example._

  5 times println("Hello")
  5 times println("Hello")

  val a = "6"
  println(a getNumber)

  println("6" getNumber)
  println("6" getDouble)

}