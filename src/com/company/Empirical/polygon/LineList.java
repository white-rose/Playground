package com.company.Empirical.polygon;

import java.util.ArrayList;

/**
 * List of DrawableLine objects
 */
abstract public class LineList {

    private ArrayList<DrawableLine> lines;
    private boolean withVertices;

    /*
     * Instantiate with no lines
     */
    protected LineList() {
        this(true);
    }

    protected LineList(boolean withVertices) {
        this.withVertices = withVertices;
        lines = new ArrayList<DrawableLine>();
    }

    /*
     * Add a new DrawableLine from specified points
     * @param start starting Point
     * @param end end Point
     */
    protected void addLine(Point start, Point end) {
        lines.add(new DrawableLine(start, end, withVertices));
    }

    /*
     * Removes first occurrence from list of line with matching start and end points
     * @param start starting Point
     * @param end end Point
     * @return whether or not a line was removed
     */
    protected boolean removeLine(Point start, Point end) {
        for (DrawableLine line : lines) {
            if (line.getStart().equals(start) && line.getEnd().equals(end)) {
                line.remove();
                lines.remove(line);
                return true;
            }
        }
        return false;
    }

    protected void setWithVertices(boolean withVertices) {
        this.withVertices = withVertices;
    }

    /*
     * Removes all lines
     */
    protected void removeAll() {
        for (DrawableLine line : lines) {
            line.remove();
        }
        lines.clear();
    }
}
