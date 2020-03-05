package fp

import cats.Eq
import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers

class CatEquality extends AnyFreeSpecLike with Matchers {

  implicit val catEq: Eq[Cat] = new Eq[Cat] {
    def eqv(x: Cat, y: Cat): Boolean =
      x.age === y.age &&
        x.color === y.color &&
        x.name === y.name
  }

  "cats shouldn't be equal" in {

    val cat1 = Cat("Garfield", 38, "orange and black")
    val cat2 = Cat("Heathcliff", 33, "orange and black")
    val optionCat1 = Option(cat1)
    val optionCat2 = Option.empty[Cat]

    cat1 === cat2 shouldBe false
    (optionCat1 !== optionCat2) shouldBe true
  }
}
