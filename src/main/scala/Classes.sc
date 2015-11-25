class User
val u = new User
val isAnyRef = u.isInstanceOf[AnyRef]

class User2 {
  val name = "Bob"
  def greet = s"Greetings from $name"
  override def toString = s"User ($name)"
}
val u2 = new User2
println(u2.greet)
println(u2.toString)

class User3(n: String){
  val name = n
  def greet = s"Greetings from $name"
  override def toString = s"User ($name)"
}
val u3 = new User3("Tiger")
println(u3.greet)
println(u3.toString)

class User4(val name: String){
  def greet = s"Greetings from $name"
  override def toString = s"User ($name)"
}
val u4 = new User4("Bob")
println(u4.greet)
println(u4.toString)

val users = List(new User4("Shoto"), new User4("Art3mis"),
  new User4("Aesch"))

val sizes = users.map(_.name.size)
val sorted = users sortBy(_.name)
val sorted2 = users.sortBy(_.name)
val third = users find(_.name contains "3")
val third2 = users.find(_.name contains "3")
val greet = third map (_.greet) getOrElse "hi"
val greet2 = third.map(_.greet).getOrElse("hi")

//Inheritance and polymorphism
class A{
  def hi = "Hello from A"
  override def toString = getClass.getName
}
class B extends A
class C extends B {
  override def hi = "Hello from C -> " + super.hi
}

val hiA = new A().hi
val hiB = new B().hi
val hiC = new C().hi

val a: A = new A
val b: A = new B

val misc = List(new B, new C, new A)
val messages = misc.map(_.hi).distinct.sorted
