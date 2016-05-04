import org.scalatest._

class ParenthesesBalancingSpec extends FunSpec with Matchers {
  describe("Balanced Parentheses") {
    describe("(if (zero? x) max (/ 1 x))") {
      it("true") {
        balance("(if (zero? x) max (/ 1 x))".toList) shouldBe true
      }
    }
    describe("I told him (that it’s not (yet) done). (But he wasn’t listening)") {
      it("true") {
        balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList) shouldBe true
      }
    }
  }
  describe("Unbalanced Parentheses") {
    describe(":-)") {
      it("false") {
        balance(":-)".toList) shouldBe false
      }
    }
  }
}

def balance(chars : List[Char]): Boolean = {
//  def loopChars(chars: List[Char]): Boolean =
//    if (chars.head == '(')

  val parentheses = chars.filter(character => (character == '(') || (character == ')'))
  println(parentheses)
  //[(, (, ), (, ), )]
  true
}

(new ParenthesesBalancingSpec).execute()