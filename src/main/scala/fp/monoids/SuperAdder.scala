package fp.monoids

import cats.Monoid

trait SuperAdder {
  def add[A](items: List[A]): A
}

object SuperAdder {
  import cats.syntax.semigroup._

  def add[A](items: List[A])(implicit monoid: Monoid[A]): A =
    items.foldLeft(monoid.empty)(_ |+| _)

  case class Order(totalCost: Double, quantity: Double)

  implicit val orderMonoid: Monoid[Order] = new Monoid[Order] {
    def empty: Order = Order(0, 0)

    def combine(x: Order, y: Order): Order =
      Order(x.totalCost + y.totalCost, x.quantity + y.quantity)
  }
}
