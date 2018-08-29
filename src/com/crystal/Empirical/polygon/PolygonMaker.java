package com.crystal.Empirical.polygon;

import java.util.Scanner;

public class PolygonMaker {
	
	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Making Polygons");
/*
		new Square(new Point(150,150), new Point(240,240));
		Polygon t1 = new Triangle(new Point(5,5), new Point(200,200), new Point(0,200));

		//Polygon t2 = makeTriangle(scanner);
		Polygon t2 = new Triangle(new Point(205,15), new Point(200,200), new Point(19,300));
		System.out.println("t1 bounding rectangle:" + t1.boundingRectangle());
*/


		while (true) {

			System.out.print("Make Polygon(P), Triangle(T), Rectangle(R), Square(S) or quit: ");
			String doMore = scanner.nextLine();

			if (doMore.length() == 0 || doMore.toUpperCase().startsWith("Q")) {
				break;
			}
			String type = doMore.toUpperCase().substring(0, 1);
			switch (type) {
				case "P":
					makePolygon(scanner);
					break;
				case "T":
					makeTriangle(scanner);
					break;
				case "R":
				case "S":
					makeQuadrilateral(scanner,
							type.equals("S") ? Rectangle.QuadType.SQUARE : Rectangle.QuadType.RECTANGLE);
					break;
				default:
					System.out.println("Bad input");
			}

		}
		System.out.println("bye");
		System.exit(0);
	}

	static Polygon makePolygon(Scanner scanner) {
		System.out.println("Constructing a new Polygon\n"
			+ "Enter some points, x,y; simply hit enter to end polygon.");
		
		//Construct the polygon here
		Polygon polygon = new Polygon();

		while(true) {
			System.out.print("Enter next point: ");
			Point point = getPoint(scanner);

			if (point == null) {
				break;
			}

			//Add a point to the polygon
			polygon.addPoint(point.getX(), point.getY());

			//say how many points now in the polygon
			System.out.println("Polygon now has " + polygon.getNumberVertices() + " point"
					+ (polygon.getNumberVertices() != 1 ? "s" : ""));
		} 

		//say what the perimeter is of polygon
		System.out.println("Polygon perimeter is " + polygon.perimeter());

		return polygon;
	}
	
	static Polygon makeTriangle(Scanner scanner) {
		System.out.println("Constructing a new Triangle\n"
			+ "Enter three points x,y"); 
		
		Point[] points = new Point[3];
		int validPoints = 0;
		while (validPoints < 3) {
			System.out.print("Enter point #" + validPoints + ": ");
			points[validPoints] = getPoint(scanner);

			if (points[validPoints] == null) {
				System.out.println("You must enter 3 points!");
				continue;
			}
			validPoints++;
		} 
		Triangle triangle = new Triangle(points[0], points[1], points[2]);

		//say what the perimeter is of triangle
		System.out.println("Triangle perimeter is " + triangle.perimeter());
		System.out.println("Triangle area is " + triangle.area());
		return triangle;
	}
	
	static Polygon makeQuadrilateral(Scanner scanner, Rectangle.QuadType type) {
		System.out.println("Constructing a new " + type + "\n" +
				"Enter two diagonally opposite vertices x,y"); 
		
		Point[] points = new Point[4];
		while (points[0] == null) {
			System.out.print("Enter point #0: ");
			points[0] = getPoint(scanner);

			if (points[0] == null) {
				System.out.println("You must enter the point!");
			}
		}

		while (points[2] == null) {
			System.out.print("Enter the diagonally opposite point #2: ");
			points[2] = getPoint(scanner);

			if (points[2] == null) {
				System.out.println("You must enter point #2!");
			}
		}
		if (type == Rectangle.QuadType.SQUARE) {
			Square square = new Square(points[0], points[2]);
			System.out.println("Square perimeter is " + square.perimeter());
			System.out.println("Square area is " + square.area());
			return square;
		} 
		//rectangle
		Rectangle rectangle = new Rectangle(points[0], points[2]);
		System.out.println("Rectangle perimeter is " + rectangle.perimeter());
		System.out.println("Rectangle area is " + rectangle.area());
		return rectangle;
	}

	static public Point getPoint(Scanner scanner) {

		while(true) {
			String pointString = scanner.nextLine();
			
			if (pointString.length() == 0) {
				return null;
			}

			//comma separated; report error and continue if no comma
			int index = pointString.indexOf(",");
			if (index == -1) {
				System.out.println("Values must be comma-separated, try again.");
				continue;
			}
			String xString = pointString.substring(0, index).trim();
			String yString = pointString.substring(index + 1).trim();
			int x = 0;
			int y = 0;

			try {
				//make integers out of xString and yString
				x = Integer.parseInt(xString);
				y = Integer.parseInt(yString);
			} catch (NumberFormatException e) {
				//handle bad input
				System.out.println("Values must be integers, try again.");
				continue;
			} 
			return new Point(x, y);
		}
	}
}

