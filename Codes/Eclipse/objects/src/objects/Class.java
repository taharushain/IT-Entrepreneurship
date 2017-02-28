package objects;

public class Class {
	int roomno = 0;
	int capacity = 0;
	Student[] students;
	Chair[] chairs;
	
	Class(int roomno, int capacity){
		this.roomno = roomno;
		this.capacity = capacity;
	}
	
	public void printStudentStatus(){
		for(int i=0; i < students.length; i++){
			String str = students[i].onLeave();
			System.out.println(str);
		}
	}
	
	public void setChairs(Chair[] chairs){
		this.chairs = chairs;
	}
	
	
	

}
