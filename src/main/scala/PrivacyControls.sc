

//protected scope: class and subclasses
//use it on VAL VAR DEF
class User { protected val passwd = util.Random.nextString(10) }
class ValidUser extends User { def isValid = !passwd.isEmpty }
val isValid = new ValidUser().isValid
val u = new User()
//privateClass - only that class can access that item
class User2(private var password: String) {
  def update(p: String): Unit = {
    println("Modifying Password !")
    password = p
  }
  def validate(p: String) = p == password
}
val u2 = new User2("1234")
val isValid2 = u2.validate("4567")
u2.update("4567")
val isValid3 = u2.validate("4567")
//val valid = new Authentication().validate
