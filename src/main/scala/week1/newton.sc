import math._

def isGoodEnough(guess: Double, number: Double): Boolean =
  abs(guess * guess - number) / number < 0.01


def improve(guess: Double, number: Double): Double =
  (guess + number / guess) / 2

def squareNumber(guess: Double, number: Double): Double =
  if (isGoodEnough(guess, number)) guess
  else squareNumber(improve(guess, number), number)

def squareRoot(number: Double) = squareNumber(1.0, number)

squareRoot(2)
squareRoot(16)
squareRoot(1e60)
