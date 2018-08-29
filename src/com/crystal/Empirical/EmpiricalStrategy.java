package com.crystal.Empirical;

import com.crystal.Empirical.TicTacToe.Board;
import com.crystal.Empirical.TicTacToe.MarkerType;
import com.crystal.Empirical.TicTacToe.Player;
import com.crystal.Empirical.polygon.Point;

import java.util.Random;

public class EmpiricalStrategy extends Player{

    Boolean isFirst;

    public EmpiricalStrategy(String name) {
        super(name);
    }

    @Override
    public Point getPlay(MarkerType type, Board board) {
        return CreateStrategy.findBestMove(type, board);

//        return randomPlay(board);
    }

    private void printBoard(Board board) {

        // Print the board
        for (int i = 0; i < board.getCells().length; i++) {
            for (int k = 0; k < board.getCells()[i].length; k++) {
                System.out.println(board.getCells()[i][k].getType());
            }
        }

    }

    private void moves(Board board) {

        int moves = 0;

        for (int i = 0; i < board.getCells().length; i++) {
            for (int k = 0; k < board.getCells()[i].length; k++) {
                if (board.getCells()[i][k].getType() != null) {
                    moves += 1;
                }
            }
        }

        System.out.println("The amount of moves so far is " + moves);
    }

    public static Point randomPlay(Board board) {
        boolean found = false;
        Random rand = new Random();
        Point point = new Point(0,0);
        while (!found) {
            int x = rand.nextInt(2);
            int y = rand.nextInt(2);
            if (!board.getCells()[x][y].isFilled() && board.getCells()[x][y] != null) {
                found = true;
                point = new Point(x, y);
            }
        }
        return point;
    }
}
