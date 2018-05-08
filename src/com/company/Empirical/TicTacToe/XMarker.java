package com.company.Empirical.TicTacToe;


import com.company.Empirical.polygon.LineList;
import com.company.Empirical.polygon.Point;

/**
*
* extends LineList to make it an X marker
*/

public class XMarker extends LineList implements Marker {

    /**
    *
    * @param size gets the size
    * @param left gets the left point
    * @param top gets the top point
    * Adds a point
    */

    XMarker(int size, int left, int top) {
        super(false);
        addLine(new Point(left, top), new Point(left + size, top + size));
        addLine(
            new Point(left, top + size),
            new Point(left + size, top));
    }

    public void delete() {
        removeAll();
    }
}
