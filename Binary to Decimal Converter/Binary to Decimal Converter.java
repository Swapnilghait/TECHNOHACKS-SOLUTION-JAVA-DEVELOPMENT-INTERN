import java.util.Random;

public class DiceRollSimulation {

    public static void main(String[] args) {
        // Create a Random object for rolling dice
        Random random = new Random();

        // Roll the dice
        int dice1 = rollDice(random);
        int dice2 = rollDice(random);

        // Display the result
        System.out.println("Dice 1: " + dice1);
        System.out.println("Dice 2: " + dice2);
    }

    public static int rollDice(Random random) {
        // Generate a random number between 1 and 6 (inclusive) for dice roll
        return random.nextInt(6) + 1;
    }
}
