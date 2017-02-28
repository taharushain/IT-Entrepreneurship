package objects;

public class Student {
	
	private String name = "";
	private int student_id = 0;
	private int age = 0;
	private boolean isOnLeave = false;
	
	public void setStudentId(int id){
		student_id = id;
	}
	public int getStudentId(){
		return student_id;
	}
	
	public void setStudentAge(int age){
		this.age = age;
	}
	
	public int getStudentAge(){
		return age;
	} 
	
	public void setName(String name){
		this.name = name;
	}
	
	
	public String getName(){
		return this.name;
	}
	
	Student(String name, int id, int age){
		this.name = name;
		student_id = id;
		this.age = age;
	}
	
	public void setOnLeave(){
		if(isOnLeave){
			isOnLeave = false;
		}else{
			isOnLeave = true;
		}
	}
	
	public String onLeave(){
		if(isOnLeave){
			return name+" is on leave!";
		}else{
			return name+" is not on leave!";
		}		
	}
}
