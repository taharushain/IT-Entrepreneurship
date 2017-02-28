package oop;

import inheritance.Cylinder;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Author author = new Author("John Doe","j@j.com",'m');
//		Book book = new Book("My book", author, 89, 10);
//		
//		System.out.println(book);
//		
//		Point point = new Point(2,3);
//		Point point_2 = new Point(3,3);
//		
//		Line line = new Line(point, point_2);
//		
//		System.out.println(line);
		
		
		Cylinder myCylinder = new Cylinder();
		System.out.println(myCylinder.getColor());
		System.out.println(myCylinder.getHeight());
		System.out.println(myCylinder.getRadius());
		System.out.println(myCylinder.getVolume());
		System.out.println("=====================");
		Cylinder myCylinderTwo = new Cylinder(2.0);
		myCylinderTwo.setColor("Blue");
		System.out.println(myCylinderTwo.getColor());
		System.out.println(myCylinderTwo.getHeight());
		System.out.println(myCylinderTwo.getRadius());
		System.out.println(myCylinderTwo.getVolume());
		

		System.out.println(myCylinderTwo.defineMe());
//		System.out.println(myCylinderTwo.superDefineMe());
		
	}

}
