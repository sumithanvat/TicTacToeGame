package org.example.TicTacToe;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

    private char[] board;
    char currentPlayer;

    public TicTacToeGame() {
        board = new char[10]; // Create a char array of size 10
        Arrays.fill(board, ' '); // Assign empty spaces to each element of the array
        currentPlayer = ' ';
    }

    public void displayBoard() {
        System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3] + " "); // Display the board's first row
        System.out.println("-----------"); // Display the separator line
        System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6] + " "); // Display the board's second row
        System.out.println("-----------"); // Display the separator line
        System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9] + " "); // Display the board's third row
    }

    public void chooseLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a letter (X or O): ");
        char letter = scanner.nextLine().toUpperCase().charAt(0);
        if (letter == 'X' || letter == 'O') { // Check if the letter is valid
            currentPlayer = letter; // Set the chosen letter as the current player's letter
            System.out.println("You chose: " + currentPlayer);
        } else {
            System.out.println("Invalid letter choice. Please try again.");
            chooseLetter(); // Recursive call to allow the player to choose again
        }
    }

    public void showBoard() {
        System.out.println("Current Board:");
        displayBoard(); // Display the current state of the board
    }

    public void makeMove(int position) {
        if (position >= 1 && position <= 9) { // Check if the position is within the valid range
            if (board[position] == ' ') { // Check if the position is empty
                board[position] = currentPlayer; // Set the current player's letter at the chosen position
                System.out.println("Move successful.");
            } else {
                System.out.println("Position is already occupied. Please choose a different position.");
            }
        } else {
            System.out.println("Invalid position. Please choose a position from 1 to 9.");
        }
    }

    public boolean checkWinner() {
        // Define the winning combinations
        int[][] winningCombinations = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, // Rows
                {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, // Columns
                {1, 5, 9}, {3, 5, 7} // Diagonals
        };

        // Check for a winning combination
        for (int[] combination : winningCombinations) {
            int pos1 = combination[0];
            int pos2 = combination[1];
            int pos3 = combination[2];
            if (board[pos1] == board[pos2] && board[pos2] == board[pos3] && board[pos1] != ' ') {
                return true; // We have a winner
            }
        }

        return false; // No winner yet
    }

    public boolean isBoardFull() {
        for (int i = 1; i <= 9; i++) {
            if (board[i] == ' ') {
                return false; // There are still empty positions on the board
            }
        }
        return true; // The board is full
    }

    public int getRandomEmptyPosition() {
        Random random = new Random();
        int position;
        do {
            position = random.nextInt(9) + 1; // Generate a random position from 1 to 9
        } while (board[position] != ' '); // Repeat if the position is not empty
        return position;
    }

    public int getWinningMove() {
        for (int i = 1; i <= 9; i++) {
            if (board[i] == ' ') {
                board[i] = currentPlayer; // Try making the move
                if (checkWinner()) {
                    board[i] = ' '; // Reset the move
                    return i; // Return the winning move
                } else {
                    board[i] = ' '; // Reset the move
                }
            }
        }
        return -1; // No winning move found
    }
}