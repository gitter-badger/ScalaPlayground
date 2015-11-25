abstract class Car{
  val year: Int
  val automatic: Boolean = true
  def color: String //method to be implemented by subclass
}

class RedMini(val year: Int) extends Car{
  def color = "Red"
}

val m: Car = new RedMini(2005)

class Mini(val year: Int, val color: String) extends Car
val redMini2: Car = new Mini(2005,"Blue")
println(s"Got a ${redMini2.color} Mini")


//Anonymous Classes
abstract class Listener { def trigger }
val myListener = new Listener {
  override def trigger: Unit = { println(s"Trigger at ${new java.util.Date}") }
}
myListener.trigger

class Listening {
  var listener: Listener = null
  def register(l: Listener) { listener = l}
  def sendNotification() { listener.trigger }
}

val notification = new Listening()
notification.register(new Listener {
  override def trigger: Unit = { println(s"Trigger at ${new java.util.Date}") }
})

notification.sendNotification()


//Apply Methods - kind of a default method  - i.e List(0)
class Multiplier(factor: Int){
  def apply(input: Int) = input * factor
}
val tripleMe = new Multiplier(3)
tripleMe.apply(10)
tripleMe(10)

//Lazy Values
class RandomPoint {
  val x = { println("creating x"); util.Random.nextInt }
  lazy val y = { println("now y"); util.Random.nextInt }
}

val p = new RandomPoint
println( s"Location is ${p.x}, ${p.y}")
