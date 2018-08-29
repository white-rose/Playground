package com.crystal.Empirical.TicTacToe;


import com.crystal.Empirical.polygon.LineList;
import com.crystal.Empirical.polygon.Point;

public class BoardView extends LineList {

    private static final int CELL_SIDE = 130;
    private static final int MARGIN = 10; //margin around board
    private static final int PADDING = 5; //padding between cell boundaries and marker

    private int rows;
    private int columns;
    private WinLine winLine;

    /**
    *
    * @param rows Takes in rows
    * @param columns Takes in columns
    * <p> This just creates the board </p>
    */

    BoardView(int rows, int columns) {
        setWithVertices(false);
        this.rows = rows;
        this.columns = columns;
        winLine = null;

        //vertical lines
        for(int i = 1; i < columns; i++) {
            addLine(
                    new Point(MARGIN + CELL_SIDE * i, MARGIN),
                    new Point(MARGIN + CELL_SIDE * i, MARGIN + columns * CELL_SIDE)
            );
        }
        //horizontal lines
        for(int i = 1; i < rows; i++) {
            addLine(
                    new Point(MARGIN, MARGIN + CELL_SIDE * i),
                    new Point(MARGIN + rows * CELL_SIDE, MARGIN + CELL_SIDE * i)
            );
        }
    }

    /**
    *
    * @param cell It takes in cell to determine which cells are marked
    */

    Marker displayMarker(Cell cell) {
        //assert no mark in specified location
        //assert row and column valid
        return MarkerFactory.getMarker(cell.getType(), CELL_SIDE - 2 * PADDING,
                MARGIN + cell.getColumn() * CELL_SIDE + PADDING,
                MARGIN + cell.getRow() * CELL_SIDE + PADDING);
    }


    /**
     * Draw a line including margin between cells
     * @param sequence where win is
     */
    void declareWinner(Sequence sequence) {
        int startRow = sequence.getStartRow();
        int startColumn = sequence.getStartColumn();
        int endRow = sequence.getEndRow();
        int endColumn = sequence.getEndColumn();

        double startXOffset = 0;
        double startYOffset = 0;
        double endXOffset = 0;
        double endYOffset = 0;
        if (startRow == endRow) {
            startYOffset = 0.5;
            endYOffset = 0.5;
            endXOffset = 1;
        } else if (startColumn == endColumn) {
            startXOffset = 0.5;
            endXOffset = 0.5;
            endYOffset = 1;
        } else if (startRow < endRow){ //diagonal down
            endXOffset = 1;
            endYOffset = 1;
        } else { //diagonal up
            startYOffset = 1;
            endXOffset = 1;
        }
        Point startPoint = new Point(
                (int)(MARGIN +  CELL_SIDE * (startColumn + startXOffset)),
                (int)(MARGIN + CELL_SIDE * (startRow + startYOffset)));
        Point endPoint = new Point(
                (int)(MARGIN +  CELL_SIDE * (endColumn + endXOffset)),
                (int)(MARGIN + CELL_SIDE * (endRow + endYOffset)));
        winLine = new WinLine(startPoint, endPoint);
    }

    /**
    *
    * This just resets the baord and winner
    */
    void resetWinner() {
        if (winLine != null) {
            winLine.delete();
            winLine = null;
        }
    }
}
