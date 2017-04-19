
class StandardBill {

}

sealed trait Orders {
  def value: Double
}
case object Cola extends Orders {
  override def value = 0.4
}

case object Coffee extends Orders {
  override def value = 1.0
}

case object CheeseSandwich extends Orders {
  override def value = 2.0
}

case object SteakSandwich extends Orders {
  override def value = 4.5
}



