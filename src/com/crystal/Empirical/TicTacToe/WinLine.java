package com.crystal.Empirical.TicTacToe;


import com.crystal.Empirical.polygon.Point;
import com.crystal.Empirical.polygon.Polygon;

public class WinLine extends Polygon {

	/**
	*
	* @param start This gets the starting point
	* @param end This get the ending point
	*/

    WinLine(Point start, Point end) {
        addPoint(start.getX(), start.getY());
        addPoint(end.getX(), end.getY());
    }

    /**
    *
    * This calls the funtion remove all which removes all the points
    */
    void delete() {
        removeAll();
    }
}
