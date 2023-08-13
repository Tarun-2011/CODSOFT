import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        int Min_Num = 1;
        int Max_Num = 100;
        int TotalAttempts = 0;
        int Rounds = 0;

        String PlayAgain;

        do {
            int secretNumber = random.nextInt(Max_Num - Min_Num + 1) + Min_Num;
            int attempts = 0;
            int MaxAttempts = 5;
            boolean isCorrect = false;

            System.out.println("\nRound " + ++Rounds);
            System.out.println("Guess the number between " + Min_Num + " and " + Max_Num + ".");

            while (!isCorrect && attempts < MaxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number " + secretNumber + " in " + attempts + " attempts.");
                    TotalAttempts += attempts;
                    isCorrect = true;
                }
            }

            if (!isCorrect) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            PlayAgain = scanner.next();

        } while (PlayAgain.equalsIgnoreCase("yes"));

        System.out.println("\nThank you for playing! Your total score is based on the number of attempts: " + TotalAttempts + " attempts.");
        scanner.close();
    }
}
