package com.crystal.Empirical.TicTacToe;


import com.crystal.Empirical.polygon.Polygon;

/**
*
* This just creates the O Marker while extending Polygon and impliments Marker
*/ 

public class OMarker extends Polygon implements Marker {

    static private final int NUMBER_VERTICES = 24;

    /**
    *
    * @param size This gives the size of the shape
    * @param left This give the left position
    * @param top This gives the top position
    * This makes the O marker
    */ 

    OMarker(int size, int left, int top) {
        setWithVertices(false);
        //while not exactly right use half size
        double radius = size/2.0;
        for (int i = 0; i < NUMBER_VERTICES; i++) {
            addPoint(
                    (int)(left + size/2.0 +
                            radius * Math.cos(2 * Math.PI * i / NUMBER_VERTICES)),
                    (int)(top + size/2.0 +
                            radius * Math.sin(2 * Math.PI * i / NUMBER_VERTICES)));
        }
    }

    /*
    * Calls the remove all method to make all the cells into null
    */

    public void delete() {
        removeAll();
    }
}

