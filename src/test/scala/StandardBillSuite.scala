
import org.scalatest._
class StandardBillSuite extends FlatSpec with Matchers {

  "A Standard Bill" should "return 3.5 for cola coffee and cheese sandwich" in {
    val sum = List(0.5, 1.0, 2.0).sum
    sum should be (3.5)
  }
}
