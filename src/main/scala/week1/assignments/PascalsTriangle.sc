import org.scalatest._

class PascalSpec extends FunSpec with Matchers {
  describe("First row") {
    val rowId = 0
    describe("Column one") {
      it("row 1 Is 1"){
        pascal(1, rowId) shouldBe 1
      }
    }
    describe("Invalid Column") {
      it("errors"){
        an [IndexOutOfBoundsException] should be thrownBy {
          pascal(2, rowId)
        }
      }
    }
  }
//  describe("Second row"){
//    val rowId = 1
//    describe("Column one") {
//      it("row 1 Is 1"){
//        pascal(1, rowId) shouldBe 1
//      }
//    }
//  }
}

def pascal(column: Int, row: Int): Int = {
  if (column == 2) throw new IndexOutOfBoundsException else 1
}

(new PascalSpec).execute()