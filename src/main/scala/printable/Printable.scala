package printable

trait Printable[A] {
  def format(a: A): String
}

object Printable {
  def format[A](a: A, printer: Printable[A]): String = printer.format(a)
  def print[A](a: A, printer: Printable[A]): Unit = println(printer.format(a))
}
