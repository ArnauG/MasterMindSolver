import jdk.jshell.spi.ExecutionControl.NotImplementedException

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
   //TODO
    throw NotImplementedException("FAIL")
}
