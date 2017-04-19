
object StandardBill {

  type Price = Double
  val items = Map[String, Price]("Cola" -> 0.5, "Coffee" -> 1.0, "Cheese Sandwich" -> 2.0, "Steak Sandwhich" -> 4.5)

  def apply(orders: List[String]): Double = {
    orders.foldLeft(0.0) {
      (sum, item) =>
        val price = items.getOrElse(item, 0.0)
        price + sum
    }
  }
}




