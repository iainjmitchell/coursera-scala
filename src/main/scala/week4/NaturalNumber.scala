package week4

trait NaturalNumber {
  def isZero: Boolean
  def predecessor: NaturalNumber
  def successor: NaturalNumber = new Successor(this)
  def + (that: NaturalNumber): NaturalNumber
  def - (that: NaturalNumber): NaturalNumber
}

object Zero extends NaturalNumber {
  def isZero: Boolean = true

  def +(that: NaturalNumber): NaturalNumber = that

  def -(that: NaturalNumber): NaturalNumber = if (that.isZero) this else throw new Error("Negative Number")

  def predecessor: NaturalNumber = throw new Error("No Predecessor!")
}

class Successor(number: NaturalNumber) extends NaturalNumber {
  def isZero: Boolean = false

  def +(that: NaturalNumber): NaturalNumber = new Successor(number + that)

  def -(that: NaturalNumber): NaturalNumber = if (that.isZero) this else number - that.predecessor

  def predecessor: NaturalNumber = number
}
