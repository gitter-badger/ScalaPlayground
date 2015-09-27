//Option - Presence or absence of a value
var x: String = "Indeed"
var a = Option(x)
x = null
var b = Option(x)
//isDefined - checks for Some
//isEmpty - checks for None
println(s"a is define? ${a.isDefined}")
println(s"a is not define? ${a.isEmpty}")

//divide by zero
def divide(amt: Double, divisor: Double): Option[Double] = {
  if(divisor == 0) None
  else Option(amt/divisor)
}

val legit = divide(5,2)
val illegit = divide(3,0)


//Try Collection
def loopAndFail(end: Int, failAt: Int): Int = {
  for(i <- 1 to end){
    println(s"$i ")
    if(i == failAt) throw new Exception("Too Many Iterations")
  }
  end
}
//loopAndFail(10,3)
val t1 = util.Try( loopAndFail(2,3) )
val t2 = util.Try{ loopAndFail(4,2) } //expression blocks also acceptable

def nextError = util.Try{ 1 / util.Random.nextInt(2) }
val x2 = nextError
val y = nextError

//Future - Concurrent - Value is not readily available yet
import scala.concurrent.ExecutionContext.Implicits.global
val f = concurrent.Future { Thread.sleep(5000); println("hi")}
println("waiting")
