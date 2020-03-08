package fp.monoids

object MonoidInstances {

  implicit val booleanAndMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def empty: Boolean = true

    def combine(x: Boolean, y: Boolean): Boolean = x && y
  }

  implicit val booleanOrMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def empty: Boolean = false

    def combine(x: Boolean, y: Boolean): Boolean = x || y
  }

  implicit val booleanXorMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def empty: Boolean = false

    def combine(x: Boolean, y: Boolean): Boolean = (x || y) && !(x && y)
  }

  implicit val booleanNorMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def empty: Boolean = true

    def combine(x: Boolean, y: Boolean): Boolean = (!x && !y) || (x && y)
  }

  implicit val unionMonoid: Monoid[Set[Int]] = new Monoid[Set[Int]] {
    def empty: Set[Int] = Set.empty

    def combine(x: Set[Int], y: Set[Int]): Set[Int] = x ++ y
  }

  implicit val intersectionSemigroup: Semigroup[Set[Int]] = new Semigroup[Set[Int]] {
    def combine(x: Set[Int], y: Set[Int]): Set[Int] = x intersect y
  }

  implicit val symmetricDiffMonoid: Monoid[Set[Int]] = new Monoid[Set[Int]] {
    def empty: Set[Int] = Set.empty

    def combine(x: Set[Int], y: Set[Int]): Set[Int] = (x diff y) union (y diff x)
  }
}
