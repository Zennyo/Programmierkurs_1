package pk1.p2.a1;
import pk1.p1.a1.*;

public class Medienverwaltung {

	private Medium[] verwaltung;
	private int menge = 0;
	
	public Medienverwaltung(int groesse){
		verwaltung = new Medium[groesse];
	}
	
	public void aufnehmen(Medium Datei){
		
		if(menge < verwaltung.length){
			verwaltung[menge] = Datei;
			menge++;
		}
		
		else
			System.out.printf("Medienverwaltung ist voll.");
	}
	
	public void zeigeMedien(){
		for(int i = 0; i < menge; i++){
			verwaltung[i].druckeDaten();
		}
	}
	
	public void sucheNeuesMedium(){
		
		if(menge == 0)
			return;
		
		Medium jung = verwaltung[0];
		
		for(int i = 0; i < menge; i++){
			if(verwaltung[i].alter() < jung.alter())
				jung = verwaltung[i];
		}
		
		System.out.println("juengstes Medium: ");
		jung.druckeDaten();
	}
	
	public double berechneErscheinungsjahr(){
		
		if(menge == 0)
			return 0.0;
		
		double durchschnitt = 0;
		
		for(int i = 0; i < menge; i++){
			durchschnitt += verwaltung[i].getJahr();
		}	
		return durchschnitt / menge;
	}
}
