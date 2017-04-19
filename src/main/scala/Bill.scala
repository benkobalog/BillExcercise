
object Bill {

  type Price = Double
  val items =
    Map[String, (Price, Category)](
      "Cola" -> (0.5, Drink),
      "Coffee" -> (1.0, Drink),
      "Cheese Sandwich" -> (2.0, Food),
      "Steak Sandwhich" -> (4.5, HotFood))

  def apply(orders: List[String]): Double = {
    orders.foldLeft(0.0) {
      (sum, item) =>
        val price = items.getOrElse(item, (0.0, NonItem))
        price._1 + sum
    }
  }

  def withServiceCharge(orders: List[String]): Double = {
    val baseSum = orders.foldLeft(0.0) {
      (sum, item) =>
        val price = items.getOrElse(item, (0.0, NonItem))
        price._1 + sum
    }
    val categoryList =
      orders
        .map(order => items.getOrElse(order, (0.0, NonItem)))
        .map(x => x._2)
    val multiplier =
      if (categoryList.contains(HotFood)) 1.2
      else if (categoryList.contains(Food)) 1.1
      else 1.0

    if ((multiplier - 1.0) * baseSum >= 20) 20 + baseSum
    else multiplier * baseSum
  }
}

sealed trait Category
case object Drink extends Category
case object Food extends Category
case object HotFood extends Category
case object NonItem extends Category




