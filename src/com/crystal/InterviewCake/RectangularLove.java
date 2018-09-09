package com.crystal.InterviewCake;

/*
A crack team of love scientists from OkEros (a hot new dating site) have devised a way to represent dating profiles as rectangles on a two-dimensional plane.

They need help writing an algorithm to find the intersection of two users' love rectangles. They suspect finding that intersection is the key to a matching algorithm so powerful it will cause an immediate acquisition by Google or Facebook or Obama or something.

Write a method to find the rectangular intersection of two given love rectangles.

As with the example above, love rectangles are always "straight" and never "diagonal." More rigorously: each side is parallel with either the x-axis or the y-axis.

They are defined as objects of Rectangle class:

*/

public class RectangularLove {

    static class Rectangle {

        private int leftX;
        private  int bottomY;

        private int width;
        private int height;

        public Rectangle() {}

        public Rectangle(int leftX, int bottomY, int width, int height) {

            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width  = width;
            this.height = height;

        }

        public int getLeftX() {
            return leftX;
        }

        public int getBottomY() {
            return bottomY;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

    }

    public static Rectangle findRectangularOverlap(Rectangle rect1, Rectangle rect2) {

        // get the x and y overlap points and lengths
        RangeOverlap xOverlap = findRangeOverlap(rect1.getLeftX(), rect1.getWidth(),
                rect2.getLeftX(), rect2.getWidth());
        RangeOverlap yOverlap = findRangeOverlap(rect1.getBottomY(), rect1.getHeight(),
                rect2.getBottomY(), rect2.getHeight());

        // return "zero" rectangle if there is no overlap
        if (xOverlap.getLength() == 0 || yOverlap.getLength() == 0) {
            return new Rectangle();
        }

        return new Rectangle(
                xOverlap.getStartPoint(),
                yOverlap.getStartPoint(),
                xOverlap.getLength(),
                yOverlap.getLength()
        );
    }

    private static RangeOverlap findRangeOverlap(int point1, int length1, int point2, int length2) {

        // find the highest start point and lowest end point.
        // the highest ("rightmost" or "upmost") start point is
        // the start point of the overlap.
        // the lowest end point is the end point of the overlap.
        int highestStartPoint = Math.max(point1, point2);
        int lowestEndPoint = Math.min(point1 + length1, point2 + length2);

        // return empty overlap if there is no overlap
        if (highestStartPoint >= lowestEndPoint) {
            return new RangeOverlap(0, 0);
        }

        // compute the overlap length
        int overlapLength = lowestEndPoint - highestStartPoint;

        return new RangeOverlap(highestStartPoint, overlapLength);
    }

    public static void main (String[] args) {

        Rectangle loveRec = new Rectangle(1, 1, 6, 3);
        Rectangle loveRec2 = new Rectangle(5, 2, 3, 6);


        loveRectangle(loveRec, loveRec2);

    }

    private static class RangeOverlap {

        private int startPoint;
        private int length;

        public RangeOverlap(int startPoint, int length) {
            this.startPoint = startPoint;
            this.length = length;
        }

        public int getStartPoint() {
            return startPoint;
        }

        public void setStartPoint(int startPoint) {
            this.startPoint = startPoint;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }

}


