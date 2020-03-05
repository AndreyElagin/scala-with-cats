package fp.printable

object PrintableInstances {
  implicit val printableInt: Printable[Int] = new Printable[Int] {
    def format(a: Int): String = s"$a"
  }
  implicit val printableString: Printable[String] = new Printable[String] {
    def format(a: String): String = a
  }
}
