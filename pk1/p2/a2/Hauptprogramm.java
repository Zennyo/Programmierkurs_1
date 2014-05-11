package pk1.p2.a2;
import pk1.p1.a1.*;
import pk1.p2.a1.*;


public class Hauptprogramm {
	
	public static void main(String[] args){
	
		Medienverwaltung Verwaltung = new Medienverwaltung(10);
		
		Audio ItMeansNothing = new Audio("It Means Nothing", 2007, "Stereophonics", 229);
		Audio Briefe = new Audio("Briefe an Patty Smith", 2014, "Pascow", 145);
		Audio Panic = new Audio("Panic Station", 2012, "Muse", 318);
		
		Bild FBInformatik = new Bild("Gebaaude FB Informatik", 2009, "Dortmund");
		Bild Urlaub = new Bild("FerienOrt500", 2002, "Prag");
		Bild Test = new Bild("Testbild", 1986, "Berlin");
		
		
		Verwaltung.aufnehmen(ItMeansNothing);
		Verwaltung.aufnehmen(Briefe);
		Verwaltung.aufnehmen(Panic);
		Verwaltung.aufnehmen(FBInformatik);
		Verwaltung.aufnehmen(Urlaub);
		Verwaltung.aufnehmen(Test);
		
		
		Verwaltung.sucheNeuesMedium();
		System.out.println();
		Verwaltung.zeigeMedien();
		System.out.println();
		System.out.println("Durchschnittliches Erscheinungsjahr: " + Verwaltung.berechneErscheinungsjahr());
		
	}
}
