package org.organic.meal

/**
 * Created by anthonygaro on 9/11/15.
 */
class Testing {
  println(s"url = ${new Config().url}")
  println("This print statement should only show up in the test branch")
  println("This print statement should only show up in test_branch2.")
  println("true merge")
  println("true merge2")
  
}

private[organic] class Config {
  val url = "http://localhost"
}

