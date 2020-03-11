package fp.functors

import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers

class PrintableContramapTest extends AnyFreeSpecLike with Matchers {

  final case class Box[A](value: A)

  "should create PrintableContramap using stringPrintable" in {
    import fp.functors.PrintableContramap.stringPrintable

    implicit def genericContramap[A](
      implicit contr: PrintableContramap[A]
    ): PrintableContramap[Box[A]] = contr.contramap[Box[A]](_.value)

    genericContramap.format(Box("hello")) shouldBe """"hello""""
  }

  "should create PrintableContramap using booleanPrintable" in {
    import fp.functors.PrintableContramap.booleanPrintable

    implicit def genericContramap[A](
      implicit contr: PrintableContramap[A]
    ): PrintableContramap[Box[A]] = contr.contramap[Box[A]](_.value)

    genericContramap.format(Box(true)) shouldBe "yes"
    genericContramap.format(Box(false)) shouldBe "no"
  }
}
