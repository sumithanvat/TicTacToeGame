package org.example.TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();

        game.chooseLetter();
        game.showBoard();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a position to make your move (1-9): ");
        int position = scanner.nextInt();

        game.makeMove(position);
        game.showBoard();
    }
}
