def hi = "hi"
hi
hi

//return type
def hi5: String = "hi"
hi5

//full signature
def multiplier(x: Int, y: Int): Int = {x * y}
multiplier(5,6)

//returns - for when execution may need to be stopped
def safeTrim(s: String): String = {
  if (s == null) return null
  s.trim()
}
safeTrim("hola ")

//Procedure - function with no return value

//implicit Unit return type
def log(d: Double) = println(f"Got value $d%.2f")
//explicit Unitreturn type
def log2(d: Double): Unit = println(f"Got value $d%.2f")
log(2.23535)
log2(2.23535)
//unofficially deprecated because below expression in
//curly braces does not return value for function
def log3(d: Double) {println(f"Got value $d%.2f")}
log3(2.23535)

//no params - use empty parenthesis or above function on line one
def hi2() = "hi"
hi2()
//PLEASE NOTE: if function defined with NO parenthesis then you cannot
//invoke it with them. For example: cannot say hi()
//If a function was defined with EMPTY parenthesis then it can be
//invoked as below:
hi

//Recursion
/*Bad Cases
@annotation.tailrec
def power(x: Int, n: Int): Long = {
  if(n >= 1) x * power(x,n-1)
  else 1
}
@annotation.tailrec
def power2(x: Int, n: Int): Long = {
  if (n < 1) 1
  else x * power2(x, n - 1)
}*/
//third param below optional ?
def power3(x: Int, n: Int, t: Int = 1): Long = {
  if (n < 1) t
  else power3(x, n - 1, x * t)
}
power3(2,8)

def optionalParams(s: String="DefaultString", i: Int=21) = {
  println(s"Printing Params: $s $i")
}
optionalParams()
optionalParams("SalutonMondo",26)

