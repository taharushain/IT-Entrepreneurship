package objects;

public class Chair {
	private String quality = "Fazool";
	private String color = "Black";
	private String type = "Plastic";
	
	
	
	
	Chair(int quality, String color, String type){
		setQuality(quality);
		this.color = color;
		this.type = type;
	}
	
//	Chair(){
//		this.Chair(15,"Gray","Plastic");
//	}

	public Chair getInstance(){
		return this;
	}
	public void setQuality(int quality){
		if(quality >=0  && quality <= 10){
			this.quality = "Low";
		}else if(quality >=11  && quality <= 20){
			this.quality = "Normal";
		}
		else if(quality >=21  && quality <= 30){
			this.quality = "High";
		}else{
			this.quality = "Not specied";
		}
	}
	
	public void setColor(String color){
		this.color = color;
	}
	public void setColor(String color, int type){
		this.color = color;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getQuality(){
		return quality;
	}
	
	public String getColor(){
		return color;
	}
	
	public String getType(){
		return type;
	}

}
