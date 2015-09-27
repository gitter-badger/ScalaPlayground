//--------------------------------------------------------------
//---------Creating new Mutable Collections from scratch-----
//Immutable -> Mutable
//immutable.List -> mutable.Buffer
//immutable.Set -> mutable.Set
//immutable.Map -> mutable.map
//Buffer -  supports adding elements to its beginning, middle, and end
val nums = collection.mutable.Buffer(1)
for (i <- 2 to 10) nums += i
println(nums)
//Starting EMPTY buffer -> specify type
val nums2 = collection.mutable.Buffer[Int]()
for (i <- 1 to 10) nums2 += i
println(nums2)
//convert mutable back to IMmutable
val l = nums.toList

//---------Creating Mutable Collections from immutable ones-----
//The List, Map, and Set immutable collections
// can all be converted to the mutable collection.mutable.Buffer
// type with the toBuffer method
val map = Map("AAPL"-> 597, "MSFT" -> 40)
val b = map.toBuffer
b trimStart 1
b += ("GOOG" -> 521)
val n = b.toMap
//convert to Set now
b += ("GOOG" -> 521)
val list = b.toList
val set = b.toSet

//---------------------Using Collection Builders----------------
//builder - simplified version of Buffer
val setBuilder = Set.newBuilder[Char]
setBuilder += 'h'
setBuilder ++= List('e','l','l','o')
val helloSet = setBuilder.result()

//--------------------------------------------------------------
//--------------------------- Arrays ---------------------------
//fixed size, mutable, indexed collection - but not really
//not in the collections package and does not extend Iterable
//does not implement toString method

//--------------------------------------------------------------
//---------------------Seq and Sequences -----------------------
//root type of all sequences, including linked lists
// like List and indexed (direct-access) lists like Vector
val inks = Seq('C','M','Y','K')

//--------------------------------------------------------------
//--------------------------- Streams --------------------------
def inc(i: Int): Stream[Int] = Stream.cons(i, inc(i+1))
val s = inc(1)
val streamList = s.take(5).toList
s
//Using cons
def inc2(head: Int): Stream[Int] = head #:: inc2(head+1)

def to(head: Char, end: Char): Stream[Char] = (head > end) match {
       case true => Stream.empty
       case false => head #:: to((head+1).toChar, end)
     }
val hexChars = to('A','F').take(20).toList
