

def factorOf(x: Int, y: Int) = y % x == 0
//shortcut without retaining params
val f = factorOf _ //don't have to type params i guess?
val x = f(7,20)

//partially apply function
val multipleOf3 = factorOf(3,_: Int)
val y = multipleOf3(78)

//CURRYING - using functions with multiple parameter lists as a base, apply
// the params for one list while leaving the other unapplied
def factorOfc(x: Int)(y: Int) = y % x  == 0
val isEven = factorOfc(2) _
val z = isEven(32)

//By-Name Parameters
def doubles(x: => Int) = {
  println("Now Doubling " + x)
}
doubles(5)
def f(i: Int) = {println(s"Hello from f($i)");i}
doubles( f(8) )

def safeStringOps(s: String, f: String => String) = {
  if(s != null) f(s) else s
}

val uuid = java.util.UUID.randomUUID().toString

val timedUUID = safeStringOps(uuid, {s =>
  val now = System.currentTimeMillis()
  val timed = s.take(24) + now
  timed.toUpperCase
})

def safeStringOp(s: String)(f: String => String) = {
  if(s != null) f(s) else s
}

val timedUUID2 = safeStringOp(uuid) { s=>
  val now = System.currentTimeMillis()
  val timed = s.take(24) + now
  timed.toUpperCase()
}

