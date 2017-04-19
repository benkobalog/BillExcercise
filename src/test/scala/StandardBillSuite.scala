import Bill._
import org.scalatest._
class StandardBillSuite extends FlatSpec with Matchers {

  "A Standard Bill" should "return 3.5 for cola coffee and cheese sandwich" in {
    val orders = List("Cola", "Coffee", "Cheese Sandwich")
    val value = Bill(orders)
    value should be (3.5)
  }

  it should "return 0 for empty List" in {
    val orders = List[String]()
    val value = Bill(orders)
    value should be(0.0)
  }

  it should "handle non existent items" in {
    val orders = List("Pug family", "Cola")
    val value = Bill(orders)
    value should be(0.5)
  }
}
