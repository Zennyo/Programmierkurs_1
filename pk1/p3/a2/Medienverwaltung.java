package pk1.p3.a2;
import pk1.p1.a1.*;
import java.util.*;

public class Medienverwaltung {
	
private Collection<Medium> verwaltung;
	
	public Medienverwaltung(){
		verwaltung = new LinkedList<Medium>();
	}
	
	public void aufnehmen(Medium Datei){
		verwaltung.add(Datei);
	}
	
	public void zeigeMedien(){
		
		Iterator<Medium> lauf = verwaltung.iterator();
		
		while(lauf.hasNext()){
			lauf.next().druckeDaten();
		}
	}
	
	public void sucheNeuesMedium(){
		
		if(verwaltung.size() == 0)
			return;
		
		Iterator <Medium>lauf = verwaltung.iterator();
		Medium jung = lauf.next();
		Medium speicher;
		while(lauf.hasNext()){
			
			speicher = lauf.next();
			if (speicher.alter() < jung.alter())
				jung = speicher;
		}
		
		jung.druckeDaten();
		
	}
	
	public double berechneErscheinungsjahr(){
		
		if(verwaltung.size() == 0)
			return 0;
	
		double durchschnitt = 0;
	
		for(Medium i : verwaltung){
			durchschnitt += i.getJahr();
			
		}
		
		return durchschnitt / verwaltung.size();
		
	}
}
