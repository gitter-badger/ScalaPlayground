package org.organic.meal

object HelloWorld {
  def main(args: Array[String]) {
    println("Hello, world!")

    val valid = new Authentication().validate
    println(valid)
    val t = new Testing
    print(t)

    val i = new Config
    println(i)

    val acc = new CheckingAccount(100)
    println(acc.currentBalance)
    acc.deposit(10)
    println(acc.currentBalance)
    acc.withdraw(5)
    println(acc.currentBalance)

    val a = new Animal();
    val m = new Mammal();
    val d = new Dog();

   println(m.isInstanceOf[Animal])
    println(d.isInstanceOf[Mammal])
   println(d.isInstanceOf[Animal])

    val bandaids = new SimpleItem(0.25f, "Band-aids 20pk")
    val gauze = new SimpleItem(1.20f, "Gauze 20m")
    val sanitizer = new SimpleItem(2.19f, "Sanitizer 200ml")
    val first_aid_kit = new Bundle()
    first_aid_kit.add(bandaids)
    first_aid_kit.add(gauze)
    first_aid_kit.add(sanitizer)
    println(bandaids)
    println(gauze)
    println(first_aid_kit)

  }

  class BankAccount(initialBalance: Double) {
    private var balance = initialBalance
    def currentBalance = balance
    def deposit(amount: Double) = { balance += amount; balance }
    def withdraw(amount: Double) = { balance -= amount; balance }
  }

  class CheckingAccount(initBalance: Double) extends BankAccount(initBalance) {
    override def deposit(amount: Double) = { super.deposit(amount - 1) }
    override def withdraw(amount: Double) = { super.withdraw(amount + 1 ) }
  }

  class Animal{
  }

  class Mammal extends Animal{
  }

  class Reptile extends Animal{
  }

  class Dog extends Mammal{
  }

  abstract class Item{
    def price: Double
    def description: String
    override def toString = s"price=${price} description=$description"
  }
  class SimpleItem(override val price: Double, override val description:String) extends Item {}
  class Bundle extends Item {
    val items = scala.collection.mutable.Set[Item]()

    override def price: Double = items.map(_.price).sum

    override def description: String = "Bundle Contains: " + items.map(_.description).mkString(",")

    def add(item: Item) = items += item
  }
}
