object ImplicitClasses{
  implicit class Hello(s: String) { def hello = s"Hello,$s"}
  def test = {
    println("World".hello)
  }
}
ImplicitClasses.test
object ImplicitParams {
  def greet(name: String)(implicit greeting: String) = s"$greeting, $name"
  implicit val hi = "hello"
  def test = {
    println(greet("Developers"))
  }
}
ImplicitParams.test
//Bounds
class A { def greet = println("meow from A")}
class B extends A
class C extends B { override def greet = println("woof from C")}
class D extends C
class E extends D
class F
//checks that param is supertype of C and returns it
//if it is not superType, it will cast-up to C and if true, returns C
def lowerBoundTest[T >: C] (param: T)= { param }
//checks that param is a subtype of C and returns it
def upperBoundTest[T <: C] (param: T)= { param }
//Checking for object supertype of C.
lowerBoundTest(new A)
lowerBoundTest(new B)
lowerBoundTest(new C)
lowerBoundTest(new D)
lowerBoundTest(new E)
lowerBoundTest(new F) //returns Object
//Checking for object subtype of C
//upperBoundTest(new A)
//upperBoundTest(new B)
upperBoundTest(new C)
upperBoundTest(new D)
upperBoundTest(new E)
//upperBoundTest(new F)
/////////////////////////////////////
class BaseUser(val name: String)
class Admin(name: String, val level: String) extends BaseUser(name)
class Customer(name: String) extends BaseUser(name)
class PreferredCustomer(name: String) extends Customer(name)
def check[A <: BaseUser](u: A) { if (u.name.isEmpty) println("Fail!") }
def check2[A <: Customer](u: A) { if (u.name.isEmpty) println("Fail!") }
def check3[A <% Customer](u: A) { if (u.name.isEmpty) println("Fail!") }
check2(new Customer(""))
check2(new PreferredCustomer(""))
