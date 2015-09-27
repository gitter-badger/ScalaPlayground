case class Receipt(id: Int, amount: Double, who: String, title: String)
{
  val latteReceipt = Receipt(123, 4.12, "fred", "Medium Latte")
  println(s"Sold a $title for $amount to $who")
}