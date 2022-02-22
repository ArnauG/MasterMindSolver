
data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

private const val TOTAL_MASTER_MIND_POSITIONS = 4
// secret: ABCD, guess: AFED
fun evaluateGuess(secret: String, guess: String): Evaluation {
    return secret.zip(guess)
        //[(A,A),(B,F),(C,E),(D,D)]
        .filter { it.first != it.second }
        //[(B,F),(C,E)]
        .unzip()
        //[BC,FE]
        .let {
            var rightPosition = TOTAL_MASTER_MIND_POSITIONS - it.first.size
            generateEvaluationWithNumberOfAppearances(Evaluation(rightPosition, 0), it.first, it.second)
        }
}

private fun generateEvaluationWithNumberOfAppearances(
    evaluation: Evaluation,
    secret: List<Char>,
    guess: List<Char>): Evaluation =

    guess.firstOrNull()
        .let {
            if(it == null)
                return evaluation
            var position = secret.indexOf(it)
            var secretMutable = secret.toMutableList()//Kotlin list interface not allow mutability
            var wrongPosition = 0
            if (position >= 0) {
                secretMutable.removeAt(position)
                wrongPosition++
            }
            // Flow control using recurrency
            wrongPosition +=
                generateEvaluationWithNumberOfAppearances(evaluation, secretMutable, guess.drop(1)).wrongPosition
            Evaluation(evaluation.rightPosition, wrongPosition)
        }