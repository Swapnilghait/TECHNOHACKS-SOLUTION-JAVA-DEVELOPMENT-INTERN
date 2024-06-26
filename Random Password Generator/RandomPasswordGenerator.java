import java.security.SecureRandom;
import java.util.Scanner;

public class RandomPasswordGenerator {

    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[{]}|;:,<.>/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get password length from user
        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Get complexity from user
        System.out.println("Choose complexity (enter numbers separated by spaces):");
        System.out.println("1. Uppercase Letters");
        System.out.println("2. Lowercase Letters");
        System.out.println("3. Digits");
        System.out.println("4. Special Characters");
        System.out.print("Enter your choice(s): ");
        String choices = scanner.nextLine();

        // Generate password based on user input
        String password = generatePassword(length, choices);

        // Display the generated password
        System.out.println("Generated Password: " + password);

        scanner.close();
    }

    public static String generatePassword(int length, String choices) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Create a string with characters based on user choices
        StringBuilder validChars = new StringBuilder();
        if (choices.contains("1")) {
            validChars.append(UPPER_CASE);
        }
        if (choices.contains("2")) {
            validChars.append(LOWER_CASE);
        }
        if (choices.contains("3")) {
            validChars.append(DIGITS);
        }
        if (choices.contains("4")) {
            validChars.append(SPECIAL_CHARS);
        }

        // Generate random password
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(validChars.length());
            password.append(validChars.charAt(index));
        }

        return password.toString();
    }
}
