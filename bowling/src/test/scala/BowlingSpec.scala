import org.specs2.mutable._

class BowlingSpec extends Specification {
  "For an open frame it" should {
    "add the points of the two rolls" in {
      Bowling.score("11--------") must_== 2
    }
  }

  "For a spare it" should {
    "award the next frame as bonus" in {
      Bowling.score("9/3-------") must_== 16
    }
  }

  "For a strike it" should {
    "award the next 2 frames as bonus" in {
      Bowling.score("x34-------") must_== 24
    }
  }
  "For an entire game it" should {
      "score a perfect game with 300" in {
        Bowling.score("xxxxxxxxxxxx") must_== 300
      }

      "give 0 points for all in gutter" in {
        Bowling.score("----------") must_== 0
      }

    "score a game of 9s with 90" in {
        Bowling.score("9-9-9-9-9-9-9-9-9-9-") must_== 90
    }

    "score a game of 5-spares with 150" in {
      Bowling.score("5/5/5/5/5/5/5/5/5/5/5") must_== 150
    }
    "score an average game with 168" in {
      Bowling.score("x7/729/xxx236/7/3") must_== 168
    }
  }
}


