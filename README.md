# Bulls and Cows Game

## Overview

This Java program implements the classic game of Bulls and Cows, where players attempt to guess a secret four-digit number through a series of guesses while receiving feedback on the number of correct digits in the correct position (bulls) and the correct digits in the wrong position (cows).

To play the game, you need to copy the `BullsAndCows.java` file from this repository and compile it using the Java Development Kit (JDK) in the command prompt or terminal.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your computer.

### Playing the Game

1. Clone or download this repository to your local machine.

2. Open your command prompt (Windows) or terminal (macOS/Linux).

3. Navigate to the directory where you saved the `BullsAndCows.java` file using the `cd` command. For example:

```bash
cd /path/to/bulls-and-cows
```

4. Compile the `BullsAndCows.java` file using the `javac` command:

```bash
javac BullsAndCows.java
```

5. Run the compiled program:

```bash
java BullsAndCows
```

6. Follow the on-screen instructions to play the game. Enter four-digit guesses until you either guess the secret number or choose to quit.

## How to Play

1. The game will generate a random four-digit secret number with unique digits (no repeating digits).

2. You will be prompted to enter your guess. Ensure that you enter a four-digit number with unique digits (no repeating digits).

3. The game will provide feedback in the form of "Bulls" and "Cows" for each guess:
   - "Bulls" indicate the number of correct digits in the correct position.
   - "Cows" indicate the number of correct digits in the wrong position.

4. Continue guessing and receiving feedback until you correctly guess the secret number (all "Bulls") or decide to quit.

## Rules

- Each digit in your guess must be unique; otherwise, you will receive an error message.
- The secret number and your guess must both be four-digit numbers.
- You must enter a positive number for your guess.
- You can choose to quit the game after a certain number of attempts.

## Sample Gameplay

```
Welcome to the game of Bulls and Cows! Guess the secret four-digit number. Good luck!

Guess #1 - Enter a four-digit number, each digit should be unique: 1234
Bulls: 0
Cows: 2

Guess #2 - Enter a four-digit number, each digit should be unique: 5678
Bulls: 0
Cows: 0

Guess #3 - Enter a four-digit number, each digit should be unique: 8901
Bulls: 1
Cows: 0

Guess #4 - Enter a four-digit number, each digit should be unique: 7890
Bulls: 0
Cows: 2

Guess #5 - Enter a four-digit number, each digit should be unique: 1980
Bulls: 1
Cows: 2

Guess #6 - Enter a four-digit number, each digit should be unique: 1987
Bulls: 2
Cows: 2

Guess #7 - Enter a four-digit number, each digit should be unique: 1982
Bulls: 3
Cows: 1

Guess #8 - Enter a four-digit number, each digit should be unique: 1983
Bulls: 4
Cows: 0

Congratulations, you guessed the secret number! It took you 8 attempt(s).
```

## Acknowledgments

- This Java implementation of Bulls and Cows was created by Pooria in November 2022.
- The game is based on the classic code-breaking game known as Bulls and Cows.
- The program provides a fun and challenging experience for players to test their deductive reasoning skills.

Enjoy playing Bulls and Cows!
