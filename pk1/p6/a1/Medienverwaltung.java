package pk1.p6.a1;

import java.io.*;
import java.util.*;

public class Medienverwaltung implements Serializable {

	private static final long serialVersionUID = 123;
	
	private List<Medium> verwaltung;
	
	public Medienverwaltung(){
		verwaltung = new LinkedList<Medium>();
	}
	
	public void aufnehmen(Medium Datei){
		verwaltung.add(Datei);
	}
	
	public void druckeMedien(OutputStream Stream){
		
		Collections.sort(verwaltung);
		Iterator<Medium> lauf = verwaltung.iterator();
		

		while(lauf.hasNext()){
			lauf.next().druckeDaten(Stream);
		}
	}
	
	public void sucheNeuesMedium(OutputStream Stream){
		
		if (verwaltung.size() != 0){
			Collections.sort(verwaltung);

			verwaltung.get(verwaltung.size() - 1).druckeDaten(Stream);

		}
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
	
	protected void setAnzahl(){
		Medium regulierer = verwaltung.get(0);
		regulierer.setAnzahl(verwaltung.size());
		regulierer = null;
	}
}
