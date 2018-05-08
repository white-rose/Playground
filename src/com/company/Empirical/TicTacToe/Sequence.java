package com.company.Empirical.TicTacToe;

public class Sequence {

    private int startRow;
    private int startColumn;
    private int endRow;
    private int endColumn;

    /**
    *
    * @param startRow This starts the row, first point
    * @param startColumn Gets the column, first point
    * @param endRow End of the row
    * @param endColumn This ends the column
    * Initiates the variables
    */

    Sequence(int startRow, int startColumn,  int endRow, int endColumn) {
        this.startRow = startRow;
        this.startColumn = startColumn;
        this.endRow = endRow;
        this.endColumn = endColumn;
    }

    /**
    *
    * @param cells Gets the cells
    * @param inRowToWin This sees if there is three in a row
    */

    Sequence getWinner(Cell[][] cells, int inRowToWin) {
        Cell startCell = cells[startRow][startColumn];
        int deltaX = startRow == endRow ? 0 : (startRow < endRow ? 1 : -1);
        int deltaY = startColumn == endColumn ? 0 : (startColumn < endColumn ? 1 : -1);
        MarkerType currentType = startCell.getType();
        int count = 1;
        for (
                int row = startRow + deltaX, column = startColumn + deltaY;
                row * deltaX <= endRow * deltaX && column * deltaY <= endColumn * deltaY;
                row += deltaX, column += deltaY) {
            if (cells[row][column].getType() != currentType) {
                count = 0;
                startCell = cells[startRow][startColumn];
                currentType = startCell.getType();
                continue;
            }
            count++;
            if (currentType != null && count == inRowToWin) {
                //we have a winner
                return new Sequence(startCell.getRow(), startCell.getColumn(),
                        cells[row][column].getRow(), cells[row][column].getColumn());
            }
        }
        return null;
    }

    /**
    *
    * @return startRow this checks where the row starts
    */

    public int getStartRow() {
        return startRow;
    }

    /**
    *
    * @return startColumn This checks where the column starts
    */

    public int getStartColumn() {
        return startColumn;
    }

    /**
    *
    * This checks where the row ends
    */

    public int getEndRow() {
        return endRow;
    }

    /**
    *
    * @return endColumn This checks to see the end of the row
    */

    public int getEndColumn() {
        return endColumn;
    }


}
