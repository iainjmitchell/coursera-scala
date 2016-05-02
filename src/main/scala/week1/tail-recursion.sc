
def factorial(n: Integer): Integer =
  if (n == 0) 1 else n * factorial(n - 1)

factorial(4)

def factorialTail(number: Integer): Integer = {
  def iterate(runningTotal: Integer, number: Integer): Integer =
    if (number == 0) runningTotal
    else iterate(number * runningTotal, number-1)
  iterate(1, number)
}

factorialTail(4)