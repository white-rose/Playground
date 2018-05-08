package com.company.Empirical.Human;

import com.company.Empirical.TicTacToe.Board;
import com.company.Empirical.TicTacToe.MarkerType;
import com.company.Empirical.TicTacToe.Player;
import com.company.Empirical.polygon.Point;
import com.company.Empirical.polygon.PolygonMaker;


import java.util.Scanner;

/**
 * Takes console input for plays
 */
public class HumanPlayer extends Player {

    private Scanner scanner;

    public HumanPlayer(String name) {
        super(name);
        scanner = new Scanner(System.in);
    }

    /**
     * Gets a row and column input and returns as a "Point"
     * @param type the type of marker used by this player
     * @param board the current board position
     * @return play at row and column (as a Point)
     */
    public Point getPlay(MarkerType type, Board board) {
        System.out.print(getName()  + ", select play(row, column): ");
        //since we already created a method in PolygonMaker to get a point, use it
        return PolygonMaker.getPoint(scanner);
    }
}
