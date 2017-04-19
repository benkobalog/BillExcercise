import Bill._
import org.scalatest._
class ServiceChargeSuite extends FlatSpec with Matchers {

  "A Bill with Service Charge" should "return 3.5 * 1.1 for cola coffee and cheese sandwich" in {
    val orders = List("Cola", "Coffee", "Cheese Sandwich")
    val value = Bill.withServiceCharge(orders)
    value should be (3.5 * 1.1)
  }

  it should "work for only drinks" in {
    val orders = List("Cola", "Coffee")
    val value = Bill.withServiceCharge(orders)
    value should be(1.5)
  }

  it should "work for hot foods" in {
    val orders = List("Steak Sandwhich", "Cola")
    val value = Bill.withServiceCharge(orders)
    value should be(5.0 * 1.2)
  }

  it should "limit the tip in 20" in {
    val orders = List.fill(25)("Steak Sandwhich")
    val value = Bill.withServiceCharge(orders)
    // Tip would be 22.5 but it should only be 20
    // Cost should be 135 by default
    value should be(132.5)
  }
}
