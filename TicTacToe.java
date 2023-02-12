import java.util.Scanner;

public class TicTacToe {
    static char[][] board = new char[3][3];
    static Scanner sc = new Scanner(System.in);
    static char turn = 'X';

    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        printBoard();
        while (true) {
            System.out.println("Player " + turn + ", enter your move (row[1-3] column[1-3]): ");
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            if (board[row][col] == ' ') {
                board[row][col] = turn;
                if (checkWin(turn)) {
                    System.out.println("Player " + turn + " wins!");
                    break;
                }
                if (turn == 'X') {
                    turn = 'O';
                } else {
                    turn = 'X';
                }
                printBoard();
            } else {
                System.out.println("Space already occupied, try again");
            }
        }
    }
}
