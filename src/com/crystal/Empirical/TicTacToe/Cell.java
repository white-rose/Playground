package com.crystal.Empirical.TicTacToe;

public class Cell {

    private BoardView view;
    private int row;
    private int column;
    private MarkerType type;
    private Marker marker;

    /**
    *
    * @param view Initiates view into cell with this method
    * @param row Initiates row into cell with the this method
    * @param column Initiates column into cell with the this method
    * <p> Collects row and column to put either an X or an O in the cell  </p>
    */

    Cell(BoardView view, int row, int column) {
        this.view = view;
        this.row = row;
        this.column = column;
        type = null;
    }

    /**
    *
    * @param type Type of marker is either an X or an O
    * <p> Set type sets the player with a marker of either X or O </p>
    */

    void setType(MarkerType type) {
        //override whatever may be there
        if (marker != null && this.type != type) {
            marker.delete();
            marker = null;
        }
        this.type  = type;
        if (type != null) {
            marker = view.displayMarker(this);
        }
    }

    /**
    *
    * @return It checks the cell to see whether or not it is filled
    */

    public boolean isFilled() {
        return type != null;
    }

    /**
    *
    * @return type It returns the marker type (X or O)
    */

    public MarkerType getType() {
        return type;
    }

    /**
    *
    * @return row It returns the row
    */

    public int getRow() {
        return row;
    }

    /**
    *
    * @return column It returns the column
    */
    public int getColumn() {
        return column;
    }

}
