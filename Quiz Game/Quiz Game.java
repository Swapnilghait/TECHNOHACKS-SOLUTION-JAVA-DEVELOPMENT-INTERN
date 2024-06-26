import java.util.Scanner;

public class QuizGame {

    private static Scanner scanner = new Scanner(System.in);
    private static String[] questions = {
            "What is the capital of France?",
            "Who wrote 'Hamlet'?",
            "What is the chemical symbol for water?",
            "Which planet is known as the Red Planet?",
            "Who painted the Mona Lisa?"
    };
    private static String[][] options = {
            { "1. Berlin", "2. Madrid", "3. Paris", "4. Rome" },
            { "1. Charles Dickens", "2. William Shakespeare", "3. Mark Twain", "4. Jane Austen" },
            { "1. H2O", "2. CO2", "3. O2", "4. NaCl" },
            { "1. Earth", "2. Mars", "3. Jupiter", "4. Saturn" },
            { "1. Vincent van Gogh", "2. Pablo Picasso", "3. Leonardo da Vinci", "4. Claude Monet" }
    };
    private static int[] answers = { 3, 2, 1, 2, 3 };

    public static void main(String[] args) {
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }
            int userAnswer = getUserAnswer();
            if (userAnswer == answers[i]) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was " + answers[i] + ".\n");
            }
        }

        System.out.println("Quiz Over! Your score is " + score + " out of " + questions.length);
    }

    private static int getUserAnswer() {
        int choice = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print("Your answer (1-4): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 4) {
                    valid = true;
                } else {
                    System.out.println("Please enter a number between 1 and 4.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear invalid input
            }
        }
        return choice;
    }
}
