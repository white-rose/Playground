package com.crystal.Empirical.TicTacToe;

public class MarkerFactory {

	/**
	*
	* @param type This just gets the marker type
	* @param size Gets the size to make an x or o
	* @param left This give the left position
	* @param top This gives the top position
	*/

    public static Marker getMarker(MarkerType type, int size,  int left, int top) {

        switch(type) {
            case O:
                return new OMarker(size, left, top);

            case X:
                return new XMarker(size, left, top);

        }
        return null;
    }
}
