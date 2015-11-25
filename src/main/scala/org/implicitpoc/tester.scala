package org.implicitpoc

/**
 * Created by anthonygaro on 10/23/15.
 */
object tester extends App{

  implicit def Cart2Basket(cart: JsonCart): XmlBasket = new XmlBasket(Seq(cart.itemName),
                                                                          Some(cart.total),
                                                                          Some(cart.total),
                                                                          None)

  val cart : XmlBasket = JsonCart("Plates","123456789",100.00)
  println(cart)


}

case class JsonCart (
  itemName: String,
  skuCode: String,
  total: Double
)

case class XmlBasket(
                   basketItems: Seq[String],
                  basketTotal: Option[Double] = None,
                  purchaseOrderTotal: Option[Double] = None,
                  customData: Option[String] = None
                   ){
  override def toString = s"XmlBasket items=${basketItems.mkString} basketTotal = ${basketTotal.getOrElse(0)} " +
    s"purchaseTotal = ${purchaseOrderTotal.getOrElse(0)} customData=${customData.getOrElse("No Custom Data")}"
}