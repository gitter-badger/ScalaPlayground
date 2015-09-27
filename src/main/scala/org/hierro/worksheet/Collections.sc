//Lists - immutable singly linked list
val numbers = List(32,95,24,21,17)
val colors = List("red","green","blue")
println(s"I have ${colors.size} colors: $colors")
colors.head
colors.tail //everything after first element
colors(1)
colors(2)
var total = 0 ; for( i <- numbers ) { total += i } //this works in REPL ?
for (c <- colors) {println(c)}
//Higher Order functions in Collections
colors.foreach( (c: String) => println(c) )
val sizes = colors.map( (c:String) => c.size )
val total2 = numbers.reduce( (a:Int, b:Int) => a + b )
//Set - immutable and unordered collection of unique elements
val unique = Set(10, 20, 30, 20, 20, 10)
val sum = unique.reduce( (a: Int, b: Int) => a + b )
val sum2 = unique.reduce( (a, b) => a + b )
//Map -  immutable key-value store
val colorMap = Map("red" -> 0xFF0000, "green" -> 0xFF00, "blue" -> 0xFF)
val redRGB = colorMap("red")
val cyanRGB = colorMap("green") | colorMap("blue")
val hasWhite = colorMap.contains("white")
for (pairs <- colorMap) {println(pairs)}
//traversing lists
var i = numbers
while (! i.isEmpty ) {print(i.head + ", "); i=i.tail}

@annotation.tailrec
def visit(i: List[Int]) { if (i.size>0) { print(i.head + ", ");
          visit(i.tail)
}}
visit(numbers)
var j = numbers
while(j != Nil) {print(j.head + ", "); j = j.tail }

/**
 * Nil is essentially a singleton instance of List[Nothing].
 * The Nothing type is a noninstantiable subtype of all
 * other Scala types. A list of Nothing types is
 * thus compatible with lists of all other types
 * and can be safely used as their terminus.
 *
 * Lists ALWAYS end with Nil
 */

//cons - takes value and makes it head - right associatve
val numCons = 1::2::3::Nil //read right to left

List(1, 2) zip List("a", "b")
//built-in higher order fucntions
val f = List(23, 8, 14, 21) filter (_ > 18)
val p = List(1, 2, 3, 4, 5) partition (_ < 3)
val s = List("apple", "to") sortBy (_.length)

//operators that work on end of list - better to work at front of list
val appended = List(1, 2, 3, 4) :+ 5
val suffix = appended takeRight 3
suffix dropRight 2

//Mapping
List(0, 1, 0) collect {case 1 => "ok"}
List("milk,tea") flatMap (_.split(','))
List("milk","tea") map (_.toUpperCase)

//Reducing
List(41, 59, 26).max
List(10.9, 32.5, 4.23, 5.67).min
List(5, 6, 7).product
List(11.3, 23.5, 7.2).sum



//boolean reduction
List(34, 29, 18) contains 29
List(0, 4, 3) endsWith List(4, 3)
List(24, 17, 32) exists (_ < 18)
List(24, 17, 32) forall (_ < 18)
List(0, 4, 3) startsWith List(0)

//folding - left/right lets you return whatever.
// nondirectional returns type of elements in list
List(4, 5, 6).fold(0)(_ + _)
List(4, 5, 6).foldLeft(0)(_ + _)
List(4, 5, 6).foldRight(0)(_ + _)
List(4, 5, 6).reduce(_ + _)
List(4, 5, 6).reduceLeft(_ + _)
List(4, 5, 6).reduceRight(_ + _)
List(4, 5, 6).scan(0)(_ + _)
List(4, 5, 6).scanLeft(0)(_ + _)
List(4, 5, 6).scanLeft(1)(_ + _)
List(4, 5, 6).scanRight(0)(_ + _)

//convert from one collection to another
List(24, 99, 104).mkString(", ") //converts to set
List('f', 't').toBuffer //immutable -> mutable
Set(1 -> true, 3 -> true).toMap
List(2, 5, 5, 3, 2).toString

//Java compatibility
import scala.collection.JavaConverters._
val l = new java.util.ArrayList(5).asScala
List(12, 29).asJava

//Pattern Matching With Collisions
