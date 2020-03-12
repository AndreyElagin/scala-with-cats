package fp.functors

import fp.functors.Codec.{ decode, encode, stringCodec }
import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers

class CodecTest extends AnyFreeSpecLike with Matchers {

  final case class Box[A](value: A)

  implicit val doubleCodec: Codec[Double] =
    stringCodec.imap(s => s.toDouble, (d: Double) => d.toString)

  implicit def boxCodec[A](implicit codec: Codec[A]): Codec[Box[A]] =
    codec.imap[Box[A]](s => Box(s), b => b.value)

  "should encode and decode using Codec for Double" in {
    encode(666.66) shouldBe "666.66"
    decode[Double]("132.32") shouldBe 132.32
  }

  "should encode and decode using Codec for Box[Double]" in {
    encode(Box(123.3)) shouldBe "123.3"
    decode[Box[Double]]("123.3") shouldBe Box(123.3)
  }
}
