package pk1.p7.a1;

public class Bottle {
	
	public Lable lable;
	
	public void printLable(){
		if(lable != null)
			System.out.println("Flasche: Typ " + lable.getType() + " Haltbar bis " + lable.getBestBefore());
		else
			System.out.println("Flasche: Lable fehlt.");
	}
	
	public void stickLable(Lable lable){
		this.lable = lable;
	}

}
