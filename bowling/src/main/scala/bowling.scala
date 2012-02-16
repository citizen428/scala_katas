object Bowling {
  private def scoreValue(score: Char): Int = {
    score match {
      case 'x' => 10
      case '-' => 0
      case digit => digit.toString.toInt
    }
  }

  private def scoreFrames(frames: List[Char]): List[Int] = {
    frames match {
      case Nil => List()
      case 'x' :: _ :: '/' :: _ =>
        20 :: scoreFrames(frames.drop(1)) // strike + spare == 20
      case 'x' :: _ => 
        frames.take(3).map(scoreValue).sum :: scoreFrames(frames.drop(1))
      case _ :: '/' :: nextRoll :: _ =>
        (10 + scoreValue(nextRoll)) :: scoreFrames(frames.drop(2))
      case _ =>
        frames.take(2).map(scoreValue).sum :: scoreFrames(frames.drop(2))
    }
  }
  
  def score(scores: String): Int = {
    assert(scores.matches("[0-9x/-]{10,22}"), "Invalid scores!")
    scoreFrames(scores.toList).take(10).sum // don't count bonus frames as normal frames
  }

  def main(args: Array[String]): Unit = {
    print("Enter frame scores: ")
    val result = score(readLine())
    println("Total score: " + result)
  }
}
