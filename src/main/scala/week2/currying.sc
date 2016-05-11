def plus(a: Int, b: Int): Int = a + b
def times(a: Int, b: Int): Int = a * b

def bob(func: (Int, Int) => Int) =
  (name: String, number: Int) => func(name.length(), number)

bob(plus)("Iain", 3)
bob(times)("Iain", 3)

def bobPartial(func: (Int, Int) => Int)(name: String, number: Int) =
  func(name.length(), number)

bobPartial(plus)("Iain", 3)
bobPartial(times)("Iain", 3)

def charlie(func: (Int, Int) => Int)(name: String)(number: Int) =
  func(name.length(), number)

charlie(plus)("Iain")(3)

def product(func: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1
  else func(a) * product(func)(a+1, b)

product(x => x * x)(3, 4)

def factorial(n: Int) = product(x => x)(1, n)

factorial(5)

def 