import org.scalatest._

class PascalSpec extends FunSpec with Matchers {
  describe("First row") {
    val rowId = 0
    describe("Column one") {
      it("Is 1"){
        pascal(0, rowId) shouldBe 1
      }
    }
    describe("Invalid Column") {
      it("errors"){
        an [IndexOutOfBoundsException] should be thrownBy {
          pascal(1, rowId)
        }
      }
    }
  }
  describe("Second row"){
    val rowId = 1
    describe("Column one") {
      it("Is 1"){
        pascal(0, rowId) shouldBe 1
      }
    }
    describe("Column two") {
      it("Is 1"){
        pascal(1, rowId) shouldBe 1
      }
    }
  }
  describe("Third row"){
    val rowId = 2
    describe("Column one") {
      it("Is 1"){
        pascal(0, rowId) shouldBe 1
      }
    }
    describe("Column two") {
      it("Is 2"){
        pascal(1, rowId) shouldBe 2
      }
    }
  }
  describe("Fifth row"){
    val rowId = 4
    describe("Column three"){
      it("Is 6"){
        pascal(2, rowId) shouldBe 6
      }
    }
  }
  describe("Silly row"){
    val rowId = 5000
    describe("Column three"){
      it("Is 6"){
        pascal(2, rowId)
      }
    }
  }
}

//def pascal(targetColumn: Int, targetRow: Int): Int = {
//  def outsideColumn(column: Int, row: Int): Boolean =
//    (column == 0 || column == row+1 || row == 1)
//  def validColumn(): Boolean =
//    targetColumn <= targetRow
//  def loopRows(column: Int, row: Int): Int =
//    if (outsideColumn(column, row)) 1 else loopRows(column, row-1) + loopRows(column+1, row-1)
//
//  if (validColumn()) loopRows(targetColumn, targetRow) else throw new IndexOutOfBoundsException
//}

def pascal(targetColumn: Int, targetRow: Int): Int = {
  def validColumn(): Boolean =
    targetColumn <= targetRow

  val l = if (targetColumn > targetRow / 2) targetColumn else targetRow - targetColumn

  def accumulate(i: Int, accumulator: Int): Int =
    if (i == l + 1) accumulator
    else accumulate(i + 1, accumulator * (targetRow - l + i) / i)

  if (validColumn()) accumulate(1, 1) else throw new IndexOutOfBoundsException
}



(new PascalSpec).execute()