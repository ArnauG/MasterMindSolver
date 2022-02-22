# MasterMindSolver
Exercise to resolve [Mastermind](https://en.wikipedia.org/wiki/Mastermind_(board_game)) code solver

Mastermind is a code-breaking game for two players. A code is made up 4 coloured pins and their position. I will use 6 colours (that we will represent with letters from A to F) to choose from and the same colour can be repeated multiple times:

    ACDF
    AABC

The game play is as follows:

The second player (the one that is guessing) sets out a series of pins in order to guess the code. The first player (that defined the secret code) then provides some feedback to the player in light of how close they are to the correct combination.

The feedback is as follows:

    Number of pins that are both the right colour and position
    Number of pins that are correct in colour but in the wrong position

Examples:

    Secret:  AABC, Guess: ABED, Result: rightPosition: 1, wrongPosition: 1
    Secret:  AABC, Guess: ABAD, Result: rightPosition: 1, wrongPosition: 2
