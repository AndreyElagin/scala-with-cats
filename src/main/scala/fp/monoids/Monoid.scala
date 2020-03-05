package fp.monoids

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}

object Monoid {

  def apply[A](implicit monoid: Monoid[A]): Monoid[A] = monoid

  implicit class MonoidSyntax[A](a: A) {
    def combine(b: A)(implicit monoid: Monoid[A]): A = monoid.combine(a, b)

    def empty(implicit monoid: Monoid[A]): A = monoid.empty
  }
}
