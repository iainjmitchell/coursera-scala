import org.scalatest._

class PascalSpec extends FunSpec with Matchers {
  describe("First row") {
    val rowId = 0
    describe("Column one") {
      it("Is 1"){
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
  describe("Second row"){
    val rowId = 1
    describe("Column one") {
      it("Is 1"){
        pascal(1, rowId) shouldBe 1
      }
    }
    describe("Column two") {
      it("Is 1"){
        pascal(2, rowId) shouldBe 1
      }
    }
  }
  describe("Third row"){
    val rowId = 2
    describe("Column one") {
      it("Is 1"){
        pascal(1, rowId) shouldBe 1
      }
    }
    describe("Column two") {
      it("Is 2"){
        pascal(2, rowId) shouldBe 2
      }
    }
  }
}

def pascal(targetColumn: Int, targetRow: Int): Int = {
  def validColumn(): Boolean =
    targetColumn <= targetRow+1
  def loopRows(column: Int, row: Int): Int =
    if (column == 0 || row+1 == column) 1 else loopRows(column, row-1) + loopRows(column+1, row-1)



  if (validColumn()) loopRows(targetColumn, targetRow) else throw new IndexOutOfBoundsException
}

(new PascalSpec).execute()