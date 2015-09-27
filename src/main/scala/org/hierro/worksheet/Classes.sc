class User
val u = new User
val isAnyRef = u.isInstanceOf[AnyRef]

class UserEnhanced {
  val name: String = "Yubaba"
  def greet: String = s"Hello from $name"
  override def toString = s"User($name)"
}
val u2 = new UserEnhanced
println(u2.greet)

//Un-named Param can't be used for anything other than initialization
class UserEnhanced2(n: String){
  val name: String = n
  def greet: String = s"Hello from $name"
  override def toString = s"User($name)"
}
val u3 = new UserEnhanced2("Anthony")
println(u3.greet)

//Named Params
class UserEnhanced3(val name: String){
  def greet: String = s"Hello from $name"
  override def toString = s"User($name)"
}

