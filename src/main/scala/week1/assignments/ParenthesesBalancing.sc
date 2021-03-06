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
  def loopBalance(characters: List[Char], openParentheses: Int = 0): Boolean = {
    if (characters.isEmpty) openParentheses == 0
    else
      characters.head match {
        case '(' => loopBalance(characters.tail, openParentheses + 1)
        case ')' => 
          if (openParentheses > 0)
            loopBalance(characters.tail, openParentheses - 1)
          else false
        case _ => loopBalance(characters.tail, openParentheses)
      }
  }
  loopBalance(chars)
}

(new ParenthesesBalancingSpec).execute()