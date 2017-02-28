package oop;

public class Point {
	private int x;
	private int y;
	
	public Point() {
		super();
	}
	
	

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}



	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public double distance(int x, int y){
		// root(x2-x1)2 + (y2-y1)2
		double diffX = this.x - x;
		diffX = Math.pow(diffX, 2);
		double diffY = this.y - y;
		diffY = Math.pow(diffY, 2);
		double sum = diffX + diffY;
		return Math.sqrt(sum);
	}
	public double distance(Point point){
		return distance(point.x, point.y);
	}
	public double distance(){
		return distance(0, 0);
	}
	

}
