package oop;

public class Author {
	private String name;
	private String email;
	private char gender;  // 'm' or 'f'
	
	public Author(String name, 
			String email, 
			char gender){
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String toString(){
		return name+" ("+gender+") at"+ email;
	}

}
