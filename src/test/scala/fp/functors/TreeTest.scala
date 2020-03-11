package fp.functors

import cats.syntax.functor._
import fp.functors.Tree.{ Branch, Leaf }
import org.scalatest.freespec.AnyFreeSpecLike
import org.scalatest.matchers.should.Matchers

class TreeTest extends AnyFreeSpecLike with Matchers {

  "should increment on one every tree value" in {
    val tree: Tree[Int] = Branch(
      Branch(Leaf(123), Leaf(321)),
      Leaf(666)
    )

    tree.map(_ + 1) shouldBe Branch(
      Branch(Leaf(124), Leaf(322)),
      Leaf(667)
    )
  }
}
