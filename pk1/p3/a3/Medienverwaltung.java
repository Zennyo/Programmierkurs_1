package pk1.p3.a3;
import java.util.*;


public class Medienverwaltung {
	
private List<Medium> verwaltung;
	
	public Medienverwaltung(){
		verwaltung = new LinkedList<Medium>();
	}
	
	public void aufnehmen(Medium Datei){
		verwaltung.add(Datei);
	}
	
	public void zeigeMedien(){
		
		Collections.sort(verwaltung);
		Iterator<Medium> lauf = verwaltung.iterator();
		
		while(lauf.hasNext()){
			lauf.next().druckeDaten();
		}
	}
	
	public void sucheNeuesMedium(){
		
		Collections.sort(verwaltung);
		
		if (verwaltung.size() != 0)
			verwaltung.get(verwaltung.size() - 1).druckeDaten();
		else
			System.out.println("Verwaltung ist Leer");
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
