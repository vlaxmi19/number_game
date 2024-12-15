import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;
    private static int totalScore = 0;
    private static int roundsPlayed = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playGame(scanner);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");
        } while (playAgain);

        System.out.println("Thanks for playing! You played " + roundsPlayed + " rounds and your final score is " + totalScore + ".");
        scanner.close();
    }

    private static void playGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the number.");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                totalScore += (10 - attempts); // Score based on attempts
                roundsPlayed++;
                return; // Exit the method after a correct guess
            }
        }

        System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
        totalScore += 0; // No points for failing
        roundsPlayed++;
    }
}