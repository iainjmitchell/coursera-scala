package week3poly

import java.util.NoSuchElementException

trait List[ListType] {
  def isEmpty: Boolean
  def head: ListType
  def tail: List[ListType]
  def nth(number: Int): ListType
}

class Cons[ListType](val head: ListType, val tail: List[ListType]) extends List[ListType] {
  def isEmpty: Boolean = false
  def nth(number: Int): ListType = number match {
    case 0 => head
    case numberGreaterThanZero if numberGreaterThanZero > 0 => tail.nth(number-1)
    case _ => throw new IndexOutOfBoundsException
  }
}

class Nil[ListType] extends List[ListType] {
  def isEmpty: Boolean = true
  def tail: Nothing = throw new NoSuchElementException("End of the line")
  def head: Nothing = throw new NoSuchElementException("End of the line")
  def nth(number: Int): ListType = throw new IndexOutOfBoundsException
}
