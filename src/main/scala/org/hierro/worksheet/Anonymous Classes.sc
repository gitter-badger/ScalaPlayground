import java.util.Date

abstract class Listener { def trigger }
val myListener = new Listener {
  override def trigger: Unit = {
    println(s"Trigger at ${new java.util.Date}")
  }
}
myListener.trigger

class Listening {
  var listener: Listener = null
  def register(l: Listener) {listener = l}
  def sendNotification() { listener.trigger}
}
val notification = new Listening()
notification.register(new Listener {
  override def trigger: Unit = { println(s"Trigger at ${new Date}")}
})
notification.sendNotification
