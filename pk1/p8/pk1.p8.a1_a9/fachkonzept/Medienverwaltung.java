package fachkonzept;

import java.io.*;
import java.util.*;

import datenhaltung.IMvDAO;
import datenhaltung.PersistenzException;

public class Medienverwaltung implements Serializable {

	private static final long serialVersionUID = 123;
	
	private List<Medium> verwaltung;
	private IMvDAO dao;
	
	public Medienverwaltung(IMvDAO dao){
		verwaltung = new LinkedList<Medium>();
		this.dao = dao;
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
	
	public Medium sucheNeuesMedium(){
		
		if (verwaltung.size() != 0){
			Collections.sort(verwaltung);

			return verwaltung.get(verwaltung.size() - 1);

		}
		else
			return null;
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
	
	public Iterator<Medium> iterator(){
		return verwaltung.iterator();
		
	}
	
	public void speichern() throws PersistenzException{
			dao.speichern(verwaltung);
	}
	
	public void laden() throws PersistenzException{
			verwaltung = dao.laden();
			
	}
	
	public int getSize(){
		return verwaltung.size();
	}
	
	public void setAnzahl(){
		if(getSize() == 0){
			Medium regul = new Bild();
			regul.setAnzahl(0);
		}
		
		else {
			Medium regul = new Bild();
			regul.setAnzahl(getSize());
		}
	}
	
}