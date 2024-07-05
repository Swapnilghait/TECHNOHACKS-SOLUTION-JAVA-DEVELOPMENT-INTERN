import java.util.Scanner;

public class BinaryToDecimalConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a binary number
        System.out.print("Enter a binary number: ");
        String binaryString = scanner.nextLine();

        // Convert the binary number to a decimal number
        int decimal = binaryToDecimal(binaryString);

        // Display the result
        System.out.println("The decimal equivalent of binary " + binaryString + " is: " + decimal);
    }

    public static int binaryToDecimal(String binaryString) {
        int decimal = 0;
        int length = binaryString.length();

        for (int i = 0; i < length; i++) {
            // Get the current character (bit) from the binary string
            char bit = binaryString.charAt(length - 1 - i);

            // Convert the bit to an integer (0 or 1) and calculate its decimal value
            if (bit == '1') {
                decimal += Math.pow(2, i);
            }
        }

        return decimal;
    }
}
