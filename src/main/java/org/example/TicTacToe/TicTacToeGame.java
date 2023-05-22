package org.example.TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
    private char[] board;
    private char currentPlayer;

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
        if (letter == 'X' || letter == 'O') {
            currentPlayer = letter;
            System.out.println("You chose: " + currentPlayer);
        } else {
            System.out.println("Invalid letter choice. Please try again.");
            chooseLetter();
        }
    }
}
