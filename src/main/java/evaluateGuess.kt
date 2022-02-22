
data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

private const val TOTAL_MASTER_MIND_POSITIONS = 4

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var guessList = guess.toCharArray().toMutableList()
    var secretList = secret.toCharArray().toMutableList()
    var removed: Int = 0
    for (i in 0 until TOTAL_MASTER_MIND_POSITIONS) {
        if (guess[i] == secret[i]) {
            guessList.removeAt(i - removed)
            secretList.removeAt(i - removed)
            removed++
        }
    }

    var rightPosition = TOTAL_MASTER_MIND_POSITIONS - secretList.size
    var wrongPosition: Int = 0

    removed = 0
    for (i in 0 until secretList.size) {
        var currentChar = guessList[i - removed]
        if (secretList.contains(currentChar)) {
            secretList.remove(currentChar)
            guessList.remove(currentChar)
            wrongPosition++
            removed++
        }
    }
    return Evaluation(rightPosition, wrongPosition)
}
