package org.example.TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();

        game.chooseLetter();
        game.showBoard();

        // Toss to determine who plays first
        Random random = new Random();
        int tossResult = random.nextInt(2); // Generates 0 or 1 randomly
        String firstPlayer;
        if (tossResult == 0) {
            firstPlayer = "Computer";
        } else {
            firstPlayer = "User";
        }
        System.out.println("Toss result: " + firstPlayer + " plays first.");

        // Perform the game moves
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a position to make your move (1-9): ");
            int position = scanner.nextInt();
            game.makeMove(position);
            game.showBoard();
        }
    }
}