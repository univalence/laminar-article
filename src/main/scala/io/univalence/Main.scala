package io.univalence

import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom
import scala.util.Random

object Main {

  def main(args: Array[String]): Unit = {
    val state: Var[Int] = Var(0)

    val display = div(
      child <-- state.signal.map(span(_)),
      className := "display"
    )

    val generator = button(
      "Generate a new number",
      onClick.map { _ => Random.nextInt() } --> state,
      className := "generator"
    )

    val app = div(
      display,
      generator,
      className := "container"
    )

    renderOnDomContentLoaded(dom.document.querySelector("#app"), app)
  }
}
