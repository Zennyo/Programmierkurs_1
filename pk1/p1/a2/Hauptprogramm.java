package pk1.p1.a2;
import pk1.p1.a1.*;

public class Hauptprogramm {
	
	public static void main(String[] args){
		
		Audio ItMeansNothing = new Audio("It Means Nothing", 2007, "Stereophonics", 229);
		Bild FBInformatik = new Bild("Gebaaude FB Informatik", 2014, "Dortmund");
		
		System.out.printf("\"It Means Nothing\" ist %d Jahre alt.", ItMeansNothing.alter());
	}

}
