package pk1.p5.a3;

import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import pk1.p5.a1.*;

public class Medienverwaltung {
	
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
}
