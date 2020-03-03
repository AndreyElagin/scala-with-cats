package printable

import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers

class CatPrinterTest extends AnyFreeSpecLike with Matchers {

  case class Cat(name: String, age: Int, color: String)

  implicit val printableCat: Printable[Cat] = new Printable[Cat] {
    def format(c: Cat): String =
      s"${c.name} is a ${c.age} year-old ${c.color} cat."
  }

  "should format cat using object method" in {
    Printable.format(
      Cat("Vasian", 666, "Satanic Black"),
      printableCat
    ) shouldBe "Vasian is a 666 year-old Satanic Black cat."
  }

  "should format cat using extension method" in {
    import printable.PrintableSyntax._

    Cat("Satan", 2, "Pink").format shouldBe "Satan is a 2 year-old Pink cat."
  }
}
