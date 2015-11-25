case object MNil extends MList
case class MCons(head: Int, tail: MList) extends MList
sealed trait MList {
  def length: Int = this match {
    case MNil => 0
    case MCons(h, t) => 1 + t.length
  }

  def sum: Int = this match {
    case MNil => 0
    case MCons(h, t) => h + t.sum
  }

  def map(f: Int => Int): MList = this match {
    case MNil => MNil
    case MCons(h, t) => MCons(f(h), t.map(f))
  }

  def filter(f: Int => Boolean): MList = this match {
    case MNil => MNil
    case MCons(h, t) => if(f(h)) MCons(h, t.filter(f))
                        else t.filter(f)
  }
  def append(e: Int): MList = this match {
    case MNil => MCons(e, MNil)
    case MCons(h, t) => MCons(h, t.append(e))
  }
  def reverse: MList = this match {
    case MNil => MNil
    case MCons(h, t) => t.reverse.append(h)
  }
}
val myList: MList = MCons(1, MCons(2, MCons(3, MCons(4, MNil))))
myList.length //4
myList.sum
myList.map(_ + 1)
myList.filter(_ % 2 == 0)
myList.append(5)
myList.reverse
val s = "Your selection is not available in any store within %d miles of %s. Please adjust your search criteria and try again."
s.format(50,raw"%s")
//for true merge


def fact(n: Int): Int ={
  @annotation.tailrec
  def helper(n: Int, acc: Int): Int ={
    if(n == 0) acc
    else helper(n-1,n*acc)
  }
  helper(n,1)
}
fact(3)
fact(4)
class Rational(val numer: Int, val denom: Int)
{
  def add(r: Rational) = {
    new Rational(numer * r.denom + r.numer * denom,
                denom * r.denom)
  }

  def neg = {
    new Rational(numer * -1, denom)
  }

  /*def sub(r: Rational) = {
    new Rational(numer * r.denom - r.numer * denom,
      denom * r.denom)*/

  def sub(r: Rational) = add(r.neg)

  override def toString = numer + "/" + denom
}

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
x.sub(y).sub(z)