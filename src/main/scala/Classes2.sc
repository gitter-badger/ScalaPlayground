class Car(val make: String, var reserved: Boolean){
  def reserve(r: Boolean){reserved = r}
//  def reserve(r: Boolean): Unit = {reserved = r}
}
val t = new Car("Toyota",false)
t.reserve(true)
t reserve (true)
println(s"Is my ${t.make} reserved? ${t.reserved}")
val t2 = new Car(reserved = false, make = "Tesla")
println("Make: " + t2.make)
class Lotus(val color: String, reserved: Boolean) extends
Car("Lotus",reserved)
val l = new Lotus("Red",false)
println(s"Requested a ${l.color} ${l.make}")

//default parameters
class Car2(val make: String,
           var reserved: Boolean = false,
           val year: Int = 2015)
val a = new Car2("Acura")
val b = new Car2("Lexus",year=2014)
val c = new Car2(reserved = false, make="Porsh")

//Type Parameters
class Singular[A] (element: A) extends Traversable[A]{
  def foreach[B] (f: A => B) = f(element)
}

val p = new Singular("Planes")
p foreach println
val name = p.head

