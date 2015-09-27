def exp (x: Int, y: Int, f: (Int,Int) => Int) = {
  f(x,y)
}
val a = exp(5,4,  _ * _)
val b = exp(5,4, (a,b) => a*b)
val c = exp(5,4, (a: Int,b: Int) => a*b)
def hi() = { println("hi") } //parenthesis and equals
def hi2() { println("hi2") } //parenthesis no equals
def hi3 { println("hi3") } //no parenthesis no equals
hi2()
hi
hi3
trait Base { override def toString = "Base" }
class A extends Base { override def toString = "A->" + super.toString }
trait B  { override def toString = "B->" + super.toString }
trait C  { override def toString = "C->" + super.toString }
class D extends A with B with C { override def toString = "D->" +
  super.toString }
new D()
val list = List(1,3,5,7,9,11,13,15)
@annotation.tailrec
def printList(x:List[Int]): Unit ={
  if(x.size == 0) return
  println(x.head)
  printList(x.tail) //recur on rest of list
}
printList(list)

list.foldLeft(2)( _ + _)
list.reduceLeft(_ + _)

