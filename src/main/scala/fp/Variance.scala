package fp

class Variance {
  trait Json

  trait JsonWriter[-A] {
    def write(value: A): Json
  }

  object JsonWriter {
    sealed trait Shape
    case class Circle(radius: Double) extends Shape

    val shape: Shape = ???
    val circle: Circle = ???
    val shapeWriter: JsonWriter[Shape] = ???

    val circleWriter: JsonWriter[Circle] = ???
    def format[A](value: A, writer: JsonWriter[A]): Json =
      writer.write(value)

    // JsonWriter[Shape]
    // JsonWriter[Circle]
  }

}
