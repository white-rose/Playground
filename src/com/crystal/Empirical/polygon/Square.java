package com.crystal.Empirical.polygon;

class Square extends Rectangle {
	Square(Point p0, Point p1, Point p2, Point p3) {
		//ASSERT (p0.x == p1.x && p1.y == p2.y) || (p0.y == p1.y && p1.x == p2.x)
		//ASSERT (p2.x == p3.x && p3.y == p0.y) || (p2.y == p3.y && p3.x == p0.x)
		this(p0, p2);
	}
	Square(Point p0, Point p2) {
		super(p0, p2);
	}
}


