import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {

    private static final int WIDTH = 20; // Width of the game area
    private static final int HEIGHT = 10; // Height of the game area

    private static LinkedList<int[]> snake; // Snake represented as a linked list of positions
    private static int[] food; // Position of the food
    private static char[][] board; // Game board

    private static boolean gameOver = false; // Game over flag
    private static Direction direction = Direction.RIGHT; // Initial direction of the snake
    private static Random random = new Random();

    public static void main(String[] args) {
        initializeGame();
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            printBoard();
            System.out.println("Enter a direction (WASD keys): ");
            char input = scanner.next().toUpperCase().charAt(0);
            changeDirection(input);
            moveSnake();
            checkCollision();
            placeFood();
        }

        System.out.println("Game Over! Your score: " + (snake.size() - 1));
        scanner.close();
    }

    private static void initializeGame() {
        snake = new LinkedList<>();
        snake.add(new int[] { 0, 0 }); // Initial position of the snake head
        board = new char[HEIGHT][WIDTH];
        food = new int[] { random.nextInt(HEIGHT), random.nextInt(WIDTH) };
        placeFood();
    }

    private static void printBoard() {
        // Clear the board
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                board[i][j] = ' ';
            }
        }

        // Place the snake on the board
        for (int[] segment : snake) {
            int row = segment[0];
            int col = segment[1];
            board[row][col] = '*';
        }

        // Place the food on the board
        int foodRow = food[0];
        int foodCol = food[1];
        board[foodRow][foodCol] = '@';

        // Print the board
        for (int i = 0; i < WIDTH + 2; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < HEIGHT; i++) {
            System.out.print("|");
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("|");
        }

        for (int i = 0; i < WIDTH + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static void changeDirection(char input) {
        switch (input) {
            case 'W':
                if (direction != Direction.DOWN)
                    direction = Direction.UP;
                break;
            case 'A':
                if (direction != Direction.RIGHT)
                    direction = Direction.LEFT;
                break;
            case 'S':
                if (direction != Direction.UP)
                    direction = Direction.DOWN;
                break;
            case 'D':
                if (direction != Direction.LEFT)
                    direction = Direction.RIGHT;
                break;
        }
    }

    private static void moveSnake() {
        int[] head = snake.getFirst().clone();
        switch (direction) {
            case UP:
                head[0]--;
                break;
            case DOWN:
                head[0]++;
                break;
            case LEFT:
                head[1]--;
                break;
            case RIGHT:
                head[1]++;
                break;
        }
        snake.addFirst(head);

        // Remove the tail if not on food
        if (head[0] != food[0] || head[1] != food[1]) {
            snake.removeLast();
        }
    }

    private static void checkCollision() {
        int[] head = snake.getFirst();
        // Check wall collision
        if (head[0] < 0 || head[0] >= HEIGHT || head[1] < 0 || head[1] >= WIDTH) {
            gameOver = true;
            return;
        }
        // Check self collision
        for (int i = 1; i < snake.size(); i++) {
            if (head[0] == snake.get(i)[0] && head[1] == snake.get(i)[1]) {
                gameOver = true;
                return;
            }
        }
    }

    private static void placeFood() {
        if (snake.getFirst()[0] == food[0] && snake.getFirst()[1] == food[1]) {
            do {
                food[0] = random.nextInt(HEIGHT);
                food[1] = random.nextInt(WIDTH);
            } while (isSnakeOnFood());
        }
    }

    private static boolean isSnakeOnFood() {
        for (int[] segment : snake) {
            if (food[0] == segment[0] && food[1] == segment[1]) {
                return true;
            }
        }
        return false;
    }

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
}
