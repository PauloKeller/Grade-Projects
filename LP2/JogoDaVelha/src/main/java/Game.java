import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private int winner = -1;
    private HashMap<Integer, Cell> board = new HashMap<Integer, Cell>();

    private Integer activePlayer = 1;

    public void printBoard() {
        this.board.forEach((index, cell) -> {
            if (cell.x <= 2) {
                System.out.print("ID:" + index + " | " + cell.point + " | ");
                if (cell.y >= 2) {
                    System.out.println();
                }
            }
        });
    }

    public void buildBoard() {
        final HashMap<Integer, Cell> board = new HashMap<Integer, Cell>();
        int index = 1;
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                board.put(index, new Cell(x, y, Point.EMPTY));
                index++;
            }
        }

        this.board = board;
        printBoard();
        printUserSelection();
    }

    public void printUserSelection() {
        System.out.println("Enter cell id: ");

        String userInput = scanner.nextLine();
        int cellId = Integer.parseInt(userInput);
        checkUserPlay(cellId);
    }

    public void checkUserPlay(int cellId) {
        board.forEach((index, cell) -> {
            if (index == cellId) {
                if (cell.point != Point.EMPTY) {
                    printUserSelection();
                    return;
                }
            }
        });

        playGame(cellId);
    }

    private void playGame(Integer cellId) {
        final Cell cell = board.get(cellId);
        if (activePlayer == 1) {
            cell.point = Point.X;
            activePlayer = 2;
        } else {
            cell.point = Point.O;
            activePlayer = 1;
        }

        board.put(cellId, cell);
        checkWinner();
    }


    private void checkWinner() {
        // row 1
        if (board.get(1).point == Point.X && board.get(2).point == Point.X && board.get(3).point == Point.X) {
            winner = 1;
        }
        if (board.get(1).point == Point.O && board.get(2).point == Point.O && board.get(3).point == Point.O) {
            winner = 2;
        }

        // row 2
        if (board.get(4).point == Point.X && board.get(5).point == Point.X && board.get(6).point == Point.X) {
            winner = 1;
        }
        if (board.get(4).point == Point.O && board.get(5).point == Point.O && board.get(6).point == Point.O) {
            winner = 2;
        }

        // row 3
        if (board.get(7).point == Point.X && board.get(8).point == Point.X && board.get(9).point == Point.X) {
            winner = 1;
        }
        if (board.get(7).point == Point.O && board.get(8).point == Point.O && board.get(9).point == Point.O) {
            winner = 2;
        }

        // column 1
        if (board.get(1).point == Point.X && board.get(4).point == Point.X && board.get(7).point == Point.X) {
            winner = 1;
        }
        if (board.get(1).point == Point.O && board.get(4).point == Point.O && board.get(7).point == Point.O) {
            winner = 2;
        }

        // column 2
        if (board.get(2).point == Point.X && board.get(5).point == Point.X && board.get(8).point == Point.X) {
            winner = 1;
        }
        if (board.get(2).point == Point.O && board.get(5).point == Point.O && board.get(8).point == Point.O) {
            winner = 2;
        }

        // column 3
        if (board.get(3).point == Point.X && board.get(6).point == Point.X && board.get(9).point == Point.X) {
            winner = 1;
        }
        if (board.get(3).point == Point.O && board.get(6).point == Point.O && board.get(9).point == Point.O) {
            winner = 2;
        }

        if (winner != -1) {
            if (winner == 1) {
                System.out.println("Player 1 win the game");
                return;
            } else {
                System.out.println("Player 2 win the game");
                return;
            }
        }
        printBoard();
        printUserSelection();

    }

    private void autoPlay() {
        Random random = new Random(9);
        boolean hasToPlay = true;
        do {
            int randomIndex = random.nextInt(9);
            final Cell cell = board.get(randomIndex);
            if (cell.point == Point.EMPTY) {
                playGame(randomIndex);
                hasToPlay = false;
            }
        } while (hasToPlay);
    }
}
