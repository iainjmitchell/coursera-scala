class Rational(val numerator: Int, val denominator: Int){
  def add(that: Rational) = {
    new Rational(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator)
  }

  def negative = new Rational(-numerator, denominator)

  def substract(that: Rational) = add(that.negative)

  override def toString = s"$numerator / $denominator"
}

val rational = new Rational(1, 2)
val rational2 = new Rational(2,3)
rational.add(rational2)
rational.substract(rational2)

rational.negative





