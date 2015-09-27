println("Saluton Mondo")
var sequence = Seq(1,2,3)
val x = "Hello World"
val r1 = x.reverse
val r2 = x.reverse
val r3 = "Hello World".reverse
r1 == r3
r1.equals(r3)
val sb = new StringBuilder("Hello")
val sbx = sb.append(", World")
val sbString = sb.toString
val sbStringy = sbx.toString
/*
Given a string name, write a match expression that will return
the same string if nonempty, or else the string “n/a” if it is empty.
 */
val name = "AnthonyGaro"
name match {
  case n if n != null & n != "" => n
  case n => "n/a"
}

for (x <- 1 to 100) {
  print(x)
if(x%5==0) print("\n") else print(",")
}

for (x <- 1 to 100) {

  if (x%3==0) println("type")
      else {
            if (x%5==0) println("safe")
            else {
                  if (x%3==0 & x%5==0) println("typesafe")
                  else println(x)
            }
      }
}
for (x <- 1 to 100) {
  x match {
    case x if x % 3 == 0 => println("type")
    case x if x % 5 == 0 => println("safe")
    case x if x % 3 == 0 & x % 5 == 0 =>  println("typesafe")
    case x =>  println(x)
  }
}
val amount : Double = 50
amount match {
  case amount if amount > 0 => "greater"
  case amount if amount < 0 => "less"
  case amount => "same"

}

