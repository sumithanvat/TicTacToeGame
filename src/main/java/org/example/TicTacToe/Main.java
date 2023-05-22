package org.example.TicTacToe;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();

        // Display the initial board
        System.out.println("Initial Board:");
        game.displayBoard();
        // Choose a letter
        game.chooseLetter();
    }
}
