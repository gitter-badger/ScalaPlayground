class A
trait B { self: A =>}
val a = new A with B

class User(val name: String){
  def suffix = ""
  override def toString = s"$name$suffix"
}

trait Attorney { self: User => override def suffix = ", esq." }
trait Wizard { self: User => override def suffix = ", Wizard" }
trait Reverser { override def toString = super.toString.reverse }
val h = new User("Harry P") with Wizard
val g = new User("Ginny W") with Attorney
val l = new User("Luna L") with Wizard with Reverser