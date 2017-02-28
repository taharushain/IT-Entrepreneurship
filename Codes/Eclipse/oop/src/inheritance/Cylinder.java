package inheritance;

public class Cylinder extends Circle{
	private double height = 1.0;

	public Cylinder() {
	}

	public Cylinder(double height) {
		this.height = height;
	}
	
	public Cylinder(double height, double radius) {
		super(radius);
		this.height = height;
	}
	
	public Cylinder(double height, 
			double radius, String color) {
		super();
		this.height = height;
		setRadius(radius);
		setColor(color);
	}
	public String toString(){
		return "Cylinder";
	}
	public double getVolume(){
		return Math.PI * Math.pow(getRadius(),2) * getHeight();
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public String defineMe(){
		return super.defineMe()+", Mein hun ek Cylinder";
	}
	
	public String superDefineMe(){
		return super.defineMe();
	}
	
}
