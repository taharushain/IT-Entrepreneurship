package objects;

public class Baby {
	
	static int size=0;
	
	String name;
	double weight;
	boolean isMale;
	Baby[] siblings;
	
	
	Baby(String name, double weight, boolean isMale){
		this.name = name;
		this.weight = weight;
		this.isMale=isMale;
		size++;
	}
	
	public void addSiblings(Baby[] siblings){
		this.siblings = siblings;
	}
	
	public void printSiblings(){
		System.out.println(this.siblings[0].name);
		System.out.println(this.siblings[1].name);
	}
	
	public static void cry(Baby baby){
		System.out.println(baby.name+" is crying");
	}

}
