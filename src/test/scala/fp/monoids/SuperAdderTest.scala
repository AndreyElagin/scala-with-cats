package fp.monoids

import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers

class SuperAdderTest extends AnyFreeSpecLike with Matchers {
  import cats.instances.int._
  import cats.instances.option._
  import fp.monoids.SuperAdder._

  "should be 6" in {
    add(List(1, 2, 3)) shouldBe 6
  }

  "should be 0" in {
    add(List(0, 0, 0)) shouldBe 0
  }

  "should be some 6" in {
    add(List(Option(1), Some(2), Some(3))) shouldBe Some(6)
  }

  "should be some 0" in {
    add(List(None, None, Some(0))) shouldBe Some(0)
  }

  import fp.monoids.SuperAdder.orderMonoid

  "should sum orders" in {
    add(
      List(
        Order(20, 3),
        Order(55, 4)
      )
    ) shouldBe Order(75, 7)
  }

  "should sum empty orders" in {
    add(
      List(
        Order(0, 0),
        Order(0, 0)
      )
    ) shouldBe orderMonoid.empty
  }
}
