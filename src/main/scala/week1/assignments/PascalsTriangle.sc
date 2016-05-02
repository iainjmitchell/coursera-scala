import org.scalatest._

class PascalSpec extends FunSpec with Matchers {
  describe("First row") {
    val rowId = 0
    describe("Column one") {
      it("Is 1"){
        pascal(1, rowId) shouldBe 1
      }
    }
  }
}

def pascal(column: Int, row: Int): Int = 1

(new PascalSpec).execute(fullstacks = true)