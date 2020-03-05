package fp.monoids

import fp.monoids.Monoid._
import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers

class MonoidTest extends AnyFreeSpecLike with Matchers {

  "booleanAnd should abide the monoid laws" in {
    import fp.monoids.MonoidInstances.{ booleanAndMonoid => andMonoid }

    true combine andMonoid.empty shouldBe true
    false combine andMonoid.empty shouldBe false

    andMonoid.empty combine true shouldBe true
    andMonoid.empty combine false shouldBe false

    true combine true shouldBe true
    false combine true shouldBe false
    true combine false shouldBe false
    false combine false shouldBe false
  }

  "booleanOr should abide the monoid laws" in {
    import fp.monoids.MonoidInstances.{ booleanOrMonoid => orMonoid }

    true combine orMonoid.empty shouldBe true
    false combine orMonoid.empty shouldBe false

    orMonoid.empty combine true shouldBe true
    orMonoid.empty combine false shouldBe false

    true combine true shouldBe true
    false combine true shouldBe true
    true combine false shouldBe true
    false combine false shouldBe false
  }

  "booleanXor should abide the monoid laws" in {
    import fp.monoids.MonoidInstances.{ booleanXorMonoid => xorMonoid }

    true combine xorMonoid.empty shouldBe true
    false combine xorMonoid.empty shouldBe false

    xorMonoid.empty combine true shouldBe true
    xorMonoid.empty combine false shouldBe false

    true combine true shouldBe false
    false combine true shouldBe true
    true combine false shouldBe true
    false combine false shouldBe false
  }

  "booleanNor should abide the monoid laws" in {
    import fp.monoids.MonoidInstances.{ booleanNorMonoid => norMonoid }

    true combine norMonoid.empty shouldBe true
    false combine norMonoid.empty shouldBe false

    norMonoid.empty combine true shouldBe true
    norMonoid.empty combine false shouldBe false

    true combine true shouldBe true
    false combine true shouldBe false
    true combine false shouldBe false
    false combine false shouldBe true
  }
}
