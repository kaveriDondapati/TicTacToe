import java.util.Scanner;

public class TicTacToe {
    static char[][] board = new char[3][3];
// my comments
    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameEnded = false;

        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + ", enter your row and column (0, 1, or 2): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != '-') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board[row][col] = currentPlayer;
            printBoard();

            if (checkWin(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (isDraw()) {
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        sc.close();
    }

    static void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '-';
    }

    static void printBoard() {
        System.out.println("Board:");
        for (char[] row : board) {
            for (char cell : row)
                System.out.print(cell + " ");
            System.out.println();
        }
    }

    static boolean checkWin(char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++)
            if ((board[i][0] == player && 
            board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player
                 && board[1][i] == player && 
                 board[2][i] == player))
                return true;

        // Check diagonals
        return (board[0][0] == player && 
        board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && 
               board[1][1] == player && board[2][0] == player);
    }

    static boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == '-')
                    return false;
        return true;
    }
}
