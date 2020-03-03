package printable

object PrintableSyntax {
  implicit class PrintableOps[A](a: A) {
    def format(implicit printer: Printable[A]): String = printer.format(a)
    def print(implicit printer: Printable[A]): Unit = println(printer.format(a))
  }
}
