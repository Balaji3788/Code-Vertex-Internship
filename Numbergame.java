package Numbergame_java;
import java.util.Scanner;
import java.util.Random;

public class Numbergame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        Scanner scanner = new Scanner(System.in);
		        Random random = new Random();
		        
		        int rounds = 0;
		        int totalScore = 0;
		        String playAgain;
		        
		        System.out.println("Welcome to the Number Guessing Game!");
		        
		        do {
		            rounds++;
		            int attempts = 0;
		            int numberToGuess = random.nextInt(100) + 1;
		            int maxAttempts = 10;
		            
		            System.out.println("\nRound " + rounds + ": Guess the number between 1 and 100. You have " + maxAttempts + " attempts!");
		            
		            boolean guessedCorrectly = false;
		            
		            while (attempts < maxAttempts) {
		                System.out.print("Enter your guess: ");
		                int guess = scanner.nextInt();
		                attempts++;
		                
		                if (guess < numberToGuess) {
		                    System.out.println("Too low!");
		                } else if (guess > numberToGuess) {
		                    System.out.println("Too high!");
		                } else {
		                    System.out.println("Correct! You've guessed the number in " + attempts + " attempts.");
		                    totalScore += (maxAttempts - attempts + 1);  // More points for fewer attempts
		                    guessedCorrectly = true;
		                    break;
		                }
		            }
		            
		            if (!guessedCorrectly) {
		                System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ".");
		            }
		            
		            System.out.print("Do you want to play another round? (yes/no): ");
		            playAgain = scanner.next();
		            
		        } while (playAgain.equalsIgnoreCase("yes"));
		        
		        System.out.println("\nGame Over! You played " + rounds + " rounds with a total score of " + totalScore + ".");
		        
		        scanner.close();
			}
}

