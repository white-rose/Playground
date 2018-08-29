package com.crystal.Empirical.TicTacToe;


import com.crystal.Empirical.polygon.Point;

import java.util.ArrayList;

abstract public class Player {

    //creates an arraylist of players
    private static ArrayList<Player> players = new ArrayList<>();

    private String name;

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    /**
    *
    * @param name Gets the name of the players
    * this also adds the name to the arraylist
    */
    protected Player(String name) {
        this.name = name;
        players.add(this);
    }

    /**
    *
    * @param type Gets marker type
    * @param board Gets the board
    * This gets the play from the user or computer
    */

    abstract public Point getPlay(MarkerType type, Board board);

    public String getName() {
        return name;
    }
}
