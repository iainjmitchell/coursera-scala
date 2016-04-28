import math._

def squareRoot(number: Double) = {
  def isGoodEnough(guess: Double): Boolean =
    abs(guess * guess - number) / number < 0.01

  def improve(guess: Double): Double =
    (guess + number / guess) / 2

  def squareNumber(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else squareNumber(improve(guess))

  squareNumber(1.0)
}

squareRoot(2)
squareRoot(16)
squareRoot(1e60)