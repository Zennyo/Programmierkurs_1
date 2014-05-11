package pk1.p4.a1;
import pk1.p3.a3.*;

public class Hauptprogramm {
	
	public static void main (String[] args){
		
		Medienverwaltung verwaltung = new Medienverwaltung();
		Menu frontend = new Menu(verwaltung);
		frontend.Auswahl();
	}
}
