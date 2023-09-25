// Created by Pooria, November 2022

import java.util.Scanner;
import java.util.Random;


public class BullsAndCows {
    public static void main(String[] args) {
        // Generate a random number and feed it as a seed to the game-simulation method
        int randomNumber = (int) (Math.random() * 1000);
        // Call game-simulation method
        playBullsAndCows(randomNumber);

    }


    // Method to check if an element is contained in a given array
    public static boolean contains(int[] array, int element) {

        for (int i : array) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }

    // Method to generate the secret number
    public static int[] generateSecretDigits(int seed) {
        Random random = new Random(seed);
        int numberOfGeneratedDigits = 0;
        int length = 4;
        int bound = 10;
        int initialValue = -1;

        // Initialize values in the array so zeros won't be discarded as repeated
        int[] generatedDigits = new int[length];
        for (int i = 0; i < length; i++) {
            generatedDigits[i] = initialValue;
        }

        // Put unique values in the array and discard the repeated ones
        while (numberOfGeneratedDigits < length) {
            int temp = random.nextInt(bound);
            if (!contains(generatedDigits, temp))
                generatedDigits[numberOfGeneratedDigits++] = temp;
        }
        return generatedDigits;
    }


    // Method to get the number of bulls in a guess
    public static int getNumOfBulls(int[] secret, int[] guess) {
        int numberOfBulls = 0;
        if (repeated(guess)) {
            throw new RuntimeException("Each digit should be unique!");
        }
        if (secret.length != guess.length) {
            throw new ArrayIndexOutOfBoundsException("Enter a four-digit number!");
        }

        for (int i = 0; i < secret.length; i++) {
            if (secret[i] == guess[i]) {
                numberOfBulls++;
            }
        }
        return numberOfBulls;
    }


    // Method to get the number of cows in a guess
    public static int getNumOfCows(int[] secret, int[] guess) {
        int numberOfCows = 0;
        if (repeated(guess)) {
            throw new RuntimeException("Each digit should be unique!");
        }
        if (secret.length != guess.length) {
            throw new ArrayIndexOutOfBoundsException("Enter a four-digit number!");
        }

        for (int i = 0; i < secret.length; i++) {
            if (secret[i] != guess[i]) {
                if (contains(guess, secret[i])) {
                    numberOfCows++;
                }
            }
        }
        return numberOfCows;
    }


    // Method to simulate the game
    public static void playBullsAndCows(int seed) {
        int[] secretNumber = generateSecretDigits(seed);
        System.out.println("Welcome to the game of Bulls and Cows! Guess the secret four-digit number. Good luck!");
        int attempts = 1;

        // To see if the game is won, to override 'finally'
        boolean gameIsWon = false;
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                String encouragement = "Guess #" + attempts + " -" + " Enter a four-digit number, " + "each digit should be unique: ";
                System.out.print(encouragement);

                // To get the length of the input and account for leading left zeros
                String userGuess = input.nextLine();
                int length = userGuess.length();
                if (length != 4) {
                    throw new ArrayIndexOutOfBoundsException("You must enter a four-digit number. You just wasted one guess!");
                }

                // Get user input as an integer
                int guess = Integer.parseInt(userGuess);
                if (guess < 0) {
                    throw new NumberFormatException("You must enter a positive number. You just wasted one guess!");
                }
                int bulls = getNumOfBulls(secretNumber, guessToArray(guess, length));
                int cows = getNumOfCows(secretNumber, guessToArray(guess, length));
                System.out.println("Bulls: " + bulls);
                System.out.println("Cows: " + cows);
                if (bulls == 4) {
                    System.out.println("Congratulations, you guessed the secret number! It took you " + attempts + " attempt(s).");

                    // Update the variable
                    gameIsWon = true;
                    break;
                }

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("You must enter a positive four-digit number. You just wasted one guess!");
            } catch (RuntimeException e) {
                System.out.println("Each digit should be unique. You just wasted one guess!");
            } finally {

                // To skip this if user has won
                if (gameIsWon) {
                    break;
                }

                if (attempts >= 5) {
                    System.out.print("Do you want to quit the game? (y/n): ");
                    String response = input.nextLine();

                    // To deal with times when the user enters no input
                    try {
                        if (response.charAt(0) == 'y' || response.charAt(0) == 'Y') {
                            System.out.println("You've decided to quit the game, after making " + attempts + " attempts.");
                            break;
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("I take it as a no!");
                    }
                }
                attempts++;
            }
        }
    }

    // Method to convert the input to an array
    public static int[] guessToArray(int userGuess, int length) {
        int[] guess = new int[length];

        // Start from the end to account for leading left zeros
        for (int i = length - 1; i >= 0; i--) {
            guess[i] = userGuess % 10;
            userGuess /= 10;
        }
        return guess;
    }

    // Method to check if there's a repetition in the array
    public static boolean repeated(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }


}
