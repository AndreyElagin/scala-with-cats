package fp.monoids

trait Semigroup[A] {
  def combine(x: A, y: A): A
}
