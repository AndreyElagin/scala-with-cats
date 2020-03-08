package fp.monoids

import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers

class MonoidTest extends AnyFreeSpecLike with Matchers {

  def associativeLaw[A](x: A, y: A, z: A)(implicit m: Monoid[A]): Boolean = {
    m.combine(x, m.combine(y, z)) == m.combine(m.combine(x, y), z)
  }

  def identityLaw[A](x: A)(implicit m: Monoid[A]): Boolean = {
    (m.combine(x, m.empty) == x) && (m.combine(m.empty, x) == x)
  }

  "boolean monoids" - {
    "booleanAnd should abide the monoid laws" in {
      import fp.monoids.MonoidInstances.booleanAndMonoid

      associativeLaw(true, true, true) shouldBe true
      associativeLaw(false, true, true) shouldBe true
      associativeLaw(true, false, true) shouldBe true
      associativeLaw(true, true, false) shouldBe true
      associativeLaw(false, false, false) shouldBe true

      identityLaw(true) shouldBe true
      identityLaw(false) shouldBe true
    }

    "booleanOr should abide the monoid laws" in {
      import fp.monoids.MonoidInstances.booleanOrMonoid

      associativeLaw(true, true, true) shouldBe true
      associativeLaw(false, true, true) shouldBe true
      associativeLaw(true, false, true) shouldBe true
      associativeLaw(true, true, false) shouldBe true
      associativeLaw(false, false, false) shouldBe true

      identityLaw(true) shouldBe true
      identityLaw(false) shouldBe true
    }

    "booleanXor should abide the monoid laws" in {
      import fp.monoids.MonoidInstances.booleanXorMonoid

      associativeLaw(true, true, true) shouldBe true
      associativeLaw(false, true, true) shouldBe true
      associativeLaw(true, false, true) shouldBe true
      associativeLaw(true, true, false) shouldBe true
      associativeLaw(false, false, false) shouldBe true

      identityLaw(true) shouldBe true
      identityLaw(false) shouldBe true
    }

    "booleanNor should abide the monoid laws" in {
      import fp.monoids.MonoidInstances.booleanNorMonoid

      associativeLaw(true, true, true) shouldBe true
      associativeLaw(false, true, true) shouldBe true
      associativeLaw(true, false, true) shouldBe true
      associativeLaw(true, true, false) shouldBe true
      associativeLaw(false, false, false) shouldBe true

      identityLaw(true) shouldBe true
      identityLaw(false) shouldBe true
    }
  }

  "set monoids" - {
    val set1 = Set(1, 2)
    val set2 = Set(3, 4)
    val set3 = Set(5, 6)

    "union should abide the monoid laws" in {
      import fp.monoids.MonoidInstances.unionMonoid

      associativeLaw(set1, set2, set3) shouldBe true

      identityLaw(set1) shouldBe true
      identityLaw(set2) shouldBe true
    }

    "intersection should abide the monoid laws" in {
      import fp.monoids.MonoidInstances.{ intersectionSemigroup => s }

      s.combine(set1, s.combine(set2, set3)) == s.combine(s.combine(set1, set2), set3) shouldBe true
    }

    "symmetric diff should abide the monoid laws" in {
      import fp.monoids.MonoidInstances.symmetricDiffMonoid

      associativeLaw(set1, set2, set3) shouldBe true

      identityLaw(set1) shouldBe true
      identityLaw(set2) shouldBe true
    }
  }
}
