package pk1.p7.a1;

public class Lable {
	
	private String type;
	private int bestBefore;
	
	public Lable(String type, int bestBefore){
		this.type = type;
		this.bestBefore = bestBefore;
	}
	
	public String getType(){
		return type;
	}
	
	public int getBestBefore(){
		return bestBefore;
	}

}
