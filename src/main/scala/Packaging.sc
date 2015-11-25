import scala.collection.mutable.{Map => MutMap}

val m1 = Map(1 -> 2)
val m2 = MutMap(2->3)
m2.remove(2)
println(m2)
