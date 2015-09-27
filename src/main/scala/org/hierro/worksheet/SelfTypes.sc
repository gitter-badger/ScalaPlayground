class A {
  def hi = "hi"
}

trait B {
  self: A =>
  override def toString = "B: " + hi
}

class C extends A with B


///////////////////////
class TestSuite(suiteName: String) {
  def start() {println("Calling start from base class...")}
}

trait RandomSeeded {
  self: TestSuite =>
  def randomStart(): Unit = {
    println("Calling RandomStart from Trait...")
    util.Random.setSeed(System.currentTimeMillis())
    self.start()
//    start() //<- this works too
  }
}

class idSpec extends TestSuite("ID Tests") with RandomSeeded {
  def testId() { println("Calling testId from idSpec...");println(s"Test ID: ${util.Random.nextInt != 1}") }
 //becuase of right association in extends, below start() method
  //gets called instead of base class
  override def start() { println("Calling start from idSpec...");testId() }

  println("Starting...")
  randomStart()
}
val i = new idSpec
