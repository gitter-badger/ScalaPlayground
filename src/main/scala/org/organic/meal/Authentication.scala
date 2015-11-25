package org.organic.meal

/**
 * Created by anthonygaro on 9/11/15.
 */
class Authentication {
  private[this] val password = "jason"
  def validate = password.size > 0
}
