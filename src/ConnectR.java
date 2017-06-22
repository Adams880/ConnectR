import Objects.Board;

import java.util.Scanner;

public class ConnectR {
    public static Scanner sc = new Scanner(System.in);
    private static boolean win = false;
    private static Board board;
    private static int connectNum;

    public static void main(String []args) {
        board = startGame();

        board.displayBoard();

        int currentPlayer = 1;
        do {
            int nextMove;
            nextMove = nextMove(currentPlayer);

            board.placePiece(nextMove, currentPlayer);

            win = board.checkWin(currentPlayer);

            if (win) {
                System.out.println("Victory! Player " + currentPlayer + " won!");
            }

            if (currentPlayer == 1) {
                currentPlayer = 2;
            } else {
                currentPlayer = 1;
            }

            if (!win) {
                board.displayBoard();
            }
        } while (!win);
    }

    private static Board startGame() {
        int rowCount;
        int columnCount;

        System.out.print("Input number of Rows: ");
        rowCount = sc.nextInt();
        System.out.print("Input number of Columns: ");
        columnCount = sc.nextInt();
        System.out.print("Input number in a row to win: ");
        connectNum = sc.nextInt();

        Board board = new Board(rowCount, columnCount, connectNum);

        return board;
    }

    private static int nextMove (int player) {
        int moveChoice;
        System.out.print("Player " + player + ", select a column to place a piece (0 - " + (board.getNumOfColumns()-1) + "): ");
        moveChoice = sc.nextInt();

        return moveChoice;
    }
}
