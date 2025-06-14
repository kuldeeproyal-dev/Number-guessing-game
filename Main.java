import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame
 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int bestScore = Integer.MAX_VALUE;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;

        while (playAgain) 
        {
            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1; 
            int guess;
            int attempts = 0;

            System.out.println("\nGuess a number between 1 and 100:");

            while (true) 
            {
                System.out.print("Enter your guess: ");
                if (scanner.hasNextInt()) 
                {
                    guess = scanner.nextInt();
                    attempts++;

                    if (guess == randomNumber) 
                    {
                        System.out.println("🎉 Congratulations! You guessed the number in " + attempts + " attempts.");
                        if (attempts < bestScore) 
                        {
                            bestScore = attempts;
                            System.out.println("🏆 New best score!");
                        }
                        System.out.println("⭐ Best score so far: " + bestScore + " attempts");
                        break;
                    } 
                    else if (guess < randomNumber) 
                    {
                        System.out.println("Too low!");
                    } 
                    else 
                    {
                        System.out.println("Too high!");
                    }
                } 
                else 
                {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
            }

            System.out.print(" play again? (yes/no): ");
            scanner.nextLine(); 
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }
}
