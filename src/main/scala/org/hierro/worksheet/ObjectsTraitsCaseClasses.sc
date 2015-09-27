object Hello{ println("in Hello"); def hi = "hi" }
println(Hello.hi)
object HtmlUtils {
  def removeMarkup(input: String) = {
    input
      .replaceAll("""</?\w[^>]*>""","")
      .replaceAll("<.*>","")
  }
}

val html = "<html><body><h1>Introduction</h1></body></html>"
val text = HtmlUtils.removeMarkup(html)
//case classes
//don't include extended fields into it's auto-generated
//methods unless explicitly added to the case class params
case class Character(name: String, isThief: Boolean)
val h = Character("Hydra",true) //apply method
val r = h.copy(name="Royce")
h==r //checks all fields
h match { //unapply method
  case Character(x,true) => s"$x is a thief"
  case Character(x, false) => s"$x is not a thief"
}
println(h)
println(r)
//traits
trait HtmlUtils {
  def removeMarkup(input: String) = {
    input
      .replaceAll("""</?\w[^>]*>""","")
      .replaceAll("<.*>","")
  }
}
class Page(val s: String) extends HtmlUtils {
  def asPlainText = removeMarkup(s)
}

new Page("<html><body><h1>Introduction</h1></body></html>").asPlainText

trait SafeStringUtils {
  // Returns a trimmed version of the string wrapped in an Option,
  // or None if the trimmed string is empty.
  def trimToNone(s: String): Option[String] = {
    Option(s) map(_.trim) filterNot(_.isEmpty)
  }
}

class Page2(val s: String) extends SafeStringUtils with HtmlUtils {
  def asPlainText: String = {
    trimToNone(s) map removeMarkup getOrElse "n/a"
  }
}
new Page2("<html><body><h1>Introduction</h1></body></html>").asPlainText
new Page2("  ").asPlainText
new Page2(null).asPlainText

//Linearization - right to left - good for determining which method
//gets chosen from which trait
trait Base { override def toString = "Base" }
class A extends Base { override def toString = "A->" + super.toString }
trait B extends Base { override def toString = "B->" + super.toString }
trait C extends Base { override def toString = "C->" + super.toString }
class D extends A with B with C { override def toString = "D->" +
  super.toString }
new D()

//More linearization
class RGBColor(val color: Int) {def hex = {println("Calling RGBCOLOR");f"$color%06X"}}
val green = new RGBColor(255 << 8).hex

trait Opaque extends RGBColor {override def hex = {println("Calling OPAQUE");s"${super.hex}FF"}}
trait Sheer extends RGBColor { override def hex = {println("Calling SHEER");s"${super.hex}33"} }

class Paint(color: Int) extends RGBColor(color) with Opaque //will output Opaque color value
class Overlay(color: Int) extends RGBColor(color) with Sheer //will output Sheer color value

val red = new Paint(128 << 16).hex
val blue = new Overlay(192).hex

