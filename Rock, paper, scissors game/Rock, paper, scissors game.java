import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] rps = { "rock", "paper", "scissors" };
        String computerMove, userMove;
        int computerScore = 0, userScore = 0, rounds = 0;

        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("How many rounds would you like to play?");
        int totalRounds = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        while (rounds < totalRounds) {
            System.out.println("Round " + (rounds + 1));
            System.out.println("Please enter your move (rock, paper, or scissors). To exit the game, type \"exit\": ");
            userMove = scanner.nextLine().toLowerCase();

            if (userMove.equals("exit")) {
                break;
            }

            if (!userMove.equals("rock") && !userMove.equals("paper") && !userMove.equals("scissors")) {
                System.out.println("Invalid move, please try again.");
                continue;
            }

            computerMove = rps[random.nextInt(3)];
            System.out.println("Computer move: " + computerMove);

            if (userMove.equals(computerMove)) {
                System.out.println("It's a tie!");
            } else if (userMove.equals("rock") && computerMove.equals("scissors")
                    || userMove.equals("paper") && computerMove.equals("rock")
                    || userMove.equals("scissors") && computerMove.equals("paper")) {
                System.out.println("You win this round!");
                userScore++;
            } else {
                System.out.println("Computer wins this round!");
                computerScore++;
            }

            rounds++;
            System.out.println("Score: You - " + userScore + ", Computer - " + computerScore);
        }

        System.out.println("Game over!");
        System.out.println("Final score: You - " + userScore + ", Computer - " + computerScore);

        if (userScore > computerScore) {
            System.out.println("Congratulations, you won the game!");
        } else if (computerScore > userScore) {
            System.out.println("Computer wins the game. Better luck next time!");
        } else {
            System.out.println("It's a tie game!");
        }
    }
}
