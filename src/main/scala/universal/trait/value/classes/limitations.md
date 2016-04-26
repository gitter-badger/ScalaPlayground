#Summary of Limitations
##A value class:

- must have only a primary constructor with exactly one public, val parameter whose type is not a value class.
(From Scala 2.11.0, the parameter may be non-public.)
```scala
class Complex(val real: Double, val imag: Double) extends AnyVal

Complex.scala:1: error: value class needs to have exactly one public val parameter
class Complex(val real: Double, val imag: Double) extends AnyVal
      ^
```

```scala
NoByName.scala:1: error: `val' parameters may not be call-by-name
class NoByName(val x: => Int) extends AnyVal
                      ^
```

- may not have specialized type parameters.
```scala
class Secondary(val x: Int) extends AnyVal {
  def this(y: Double) = this(y.toInt)
}
Secondary.scala:2: error: value class may not have secondary constructors
  def this(y: Double) = this(y.toInt)



```

- may not have nested or local classes, traits, or objects
```scala
class NoLocalTemplates(val x: Int) extends AnyVal {
  def aMethod = {
    class Local
    ...
  }
}
```

- may not define a equals or hashCode method.

- must be a top-level class or a member of a statically accessible object
```scala
// OK !
object Outer {
  class Inner(val x: Int) extends AnyVal
}
```

```scala
class Outer(val inner: Inner) extends AnyVal
class Inner(val value: Int) extends AnyVal
Nested.scala:1: error: value class may not wrap another user-defined value class
class Outer(val inner: Inner) extends AnyVal
                ^
```

```scala
class Outer {
  class Inner(val x: Int) extends AnyVal
}
Outer.scala:2: error: value class may not be a member of another class
class Inner(val x: Int) extends AnyVal
      ^
```

```scala
class Value(val x: Int) extends AnyVal
object Usage {
  def anyValue(v: { def value: Value }): Value =
    v.value
}
Struct.scala:3: error: Result type in structural refinement may not refer to a user-defined value class
  def anyValue(v: { def value: Value }): Value =
                               ^
```

- can only have defs as members. In particular, it cannot have lazy vals, vars, or vals as members.
```scala
class NoLazyMember(val evaluate: () => Double) extends AnyVal {
  val member: Int = 3
  lazy val x: Double = evaluate()
  object NestedObject
  class NestedClass
}
Invalid.scala:2: error: this statement is not allowed in value class: private[this] val member: Int = 3
  val member: Int = 3
      ^
Invalid.scala:3: error: this statement is not allowed in value class: lazy private[this] var x: Double = NoLazyMember.this.evaluate.apply()
  lazy val x: Double = evaluate()
           ^
Invalid.scala:4: error: value class may not have nested module definitions
  object NestedObject
         ^
Invalid.scala:5: error: value class may not have nested class definitions
  class NestedClass
        ^
```

- cannot be extended by another class. MUST extend Universal Trait
```scala
trait NotUniversal
class Value(val x: Int) extends AnyVal with notUniversal
class Extend(x: Int) extends Value(x)
Extend.scala:2: error: illegal inheritance; superclass AnyVal
 is not a subclass of the superclass Object
 of the mixin trait NotUniversal
class Value(val x: Int) extends AnyVal with NotUniversal
                                            ^
Extend.scala:3: error: illegal inheritance from final class Value
class Extend(x: Int) extends Value(x)
                             ^
```


