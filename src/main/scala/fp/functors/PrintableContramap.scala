package fp.functors

trait PrintableContramap[A] { self =>

  def format(value: A): String

  def contramap[B](func: B => A): PrintableContramap[B] = v => self.format(func(v))
}

object PrintableContramap {

  implicit val stringPrintable: PrintableContramap[String] =
    new PrintableContramap[String] {
      def format(value: String): String =
        "\"" + value + "\""
    }

  implicit val booleanPrintable: PrintableContramap[Boolean] =
    new PrintableContramap[Boolean] {
      def format(value: Boolean): String =
        if (value) "yes" else "no"
    }
}
