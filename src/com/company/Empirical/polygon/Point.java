package com.company.Empirical.polygon;

public class Point {

	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	double distance(Point other) {
		return Math.sqrt(Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Point)) {
			return false;
		}
		Point otherPoint = (Point)other;
		return (otherPoint.x == x && otherPoint.y == y);
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + x;
		result = 31 * result + y;
		return result;
	}
}
