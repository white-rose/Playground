package com.crystal.Empirical.polygon;

class Rectangle extends Polygon {

	enum QuadType {SQUARE, RECTANGLE}

	Rectangle(Point p0, Point p2) {
		addPoint(p0.getX(), p0.getY());
		addPoint(p0.getX(), p2.getY()); 
		addPoint(p2.getX(), p2.getY());
		addPoint(p2.getX(), p0.getY());
	}

	double area() {
		Point a = points.get(0);
		Point b = points.get(1);
		Point c = points.get(2);
		return a.distance(b) * b.distance(c);
	}
}


