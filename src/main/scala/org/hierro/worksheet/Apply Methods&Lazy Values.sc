class Multiplier(factor: Int) {
  def apply(input: Int) = input * factor
}

val tripleMe = new Multiplier(3)
val tripled = tripleMe.apply(10) //calling apply
val tripled2 = tripleMe(10) //but it's not necessary

//Lazy Values
class RandomPoint {
  val x = { println("creating x"); util.Random.nextInt }
  lazy val y = { println("now y"); util.Random.nextInt }
}

val p = new RandomPoint
