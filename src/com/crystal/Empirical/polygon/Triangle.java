package com.crystal.Empirical.polygon;

class Triangle extends Polygon {
	Triangle(Point p1, Point p2, Point p3) {
		addPoint(p1.getX(), p1.getY());
		addPoint(p2.getX(), p2.getY());
		addPoint(p3.getX(), p3.getY());
	}

	double area() {
		Point a = points.get(0);
		Point b = points.get(1);
		Point c = points.get(2);
		return Math.abs(
			a.getX() * (b.getY() - c.getY()) +
			b.getX() * (c.getY() - a.getY()) +
			c.getX() * (a.getY() - b.getY()));
	}
}


