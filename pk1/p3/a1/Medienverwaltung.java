package pk1.p3.a1;
import pk1.p1.a1.*;
import java.util.*;

public class Medienverwaltung {
	
	private Collection verwaltung;
	
	public Medienverwaltung(){
		verwaltung = new LinkedList();
	}
	
	public void aufnehmen(Medium Datei){
		verwaltung.add(Datei);
	}
	
	public void zeigeMedien(){
		
		Iterator lauf = verwaltung.iterator();
		Medium speicher;
		
		while(lauf.hasNext()){
			speicher = (Medium)lauf.next();
			speicher.druckeDaten();
		}
		
	}
	
	public void sucheNeuesMedium(){
		
		if(verwaltung.size() == 0)
			return;
		
		Iterator lauf = verwaltung.iterator();
		Medium jung = (Medium)lauf.next();
		Medium speicher;
		while(lauf.hasNext()){
			
			speicher = (Medium)lauf.next();
			
			if (speicher.alter() < jung.alter())
				jung = speicher;
		}
		
		jung.druckeDaten();
		
	}
	
	public double berechneErscheinungsjahr(){
		
		double durchschnitt = 0;
		
		if(verwaltung.size() == 0)
			return 0;
		
		Medium Datei;
		
		for(Object i : verwaltung){
			Datei = (Medium)i;
			durchschnitt += Datei.getJahr();
			
		}
		
		return durchschnitt / verwaltung.size();
		
	}

}
