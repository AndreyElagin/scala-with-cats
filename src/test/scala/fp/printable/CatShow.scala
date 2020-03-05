package fp.printable

import cats.Show
import cats.syntax.show._
import fp.Cat
import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers

class CatShow extends AnyFreeSpecLike with Matchers {



  implicit val catShow: Show[Cat] =
    Show.show(c => s"${c.name} is a ${c.age} year-old ${c.color} cat.")

  "should format cat using Show instance" in {
    Cat("Vasian", 666, "Satanic Black").show shouldBe "Vasian is a 666 year-old Satanic Black cat."
  }
}
