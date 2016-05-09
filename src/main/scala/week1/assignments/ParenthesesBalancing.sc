import org.scalatest._

class ParenthesesBalancingSpec extends FunSpec with Matchers {
  describe("Balanced Parentheses") {
    describe("EXAMPLE: (if (zero? x) max (/ 1 x))") {
      it("true") {
        balance("(if (zero? x) max (/ 1 x))".toList) shouldBe true
      }
    }
    describe("EXAMPLE: I told him (that it’s not (yet) done). (But he wasn’t listening)") {
      it("true") {
        balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList) shouldBe true
      }
    }
    describe("single"){
      it("true"){
        balance("()".toList) shouldBe true
      }
    }
  }
  describe("Unbalanced Parentheses") {
    describe("EXAMPLE: :-)") {
      it("false") {
        balance(":-)".toList) shouldBe false
      }
    }
    describe("one opening"){
      it("false"){
        balance("(".toList) shouldBe false
      }
    }
    describe("two opening"){
      it("false"){
        balance("((".toList) shouldBe false
      }
    }
    describe("one opening, two closing"){
      it("false"){
        balance("())".toList) shouldBe false
      }
    }
    describe("one of each but out of order"){
      it("false"){
        balance(")(".toList) shouldBe false
      }
    }
    describe("two of each but one out of order"){
      it("false"){
        balance(")()(".toList) shouldBe false
      }
    }
  }
}

def balance(chars : List[Char]): Boolean = {
  def findEnd(chars: List[Char]): Boolean = {
    if (chars.length == 0) false else
      if (chars.head == ')') true else findEnd(chars.tail)
  }

  def loopChars(chars: List[Char]): Boolean = {
    if (chars.length == 0) true else
      if (chars.head == '(') findEnd(chars.tail) else
        loopChars(chars.tail)
  }

  val parentheses = chars.filter(character => (character == '(') || (character == ')'))
  (parentheses.count(_ == '(') == parentheses.count(_ == ')')) && loopChars(parentheses)
}

(new ParenthesesBalancingSpec).execute()