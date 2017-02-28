package oop;

public class Line {
	private Point start;
	private Point end;
	
	public Line(Point start, Point end) {
		super();
		this.start = start;
		this.end = end;
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}
	
	
	public String toString(){
		return "Line[begin=("+start.getX()+","
				+start.getY()+"),end=("+end.getX()
				+","+end.getY()+")]";
	}

}
