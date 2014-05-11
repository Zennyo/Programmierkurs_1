package pk1.p5.a1;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Medium implements Comparable<Medium> {

	private static int Anzahl = 0;
	
	private int id;
	private String titel;
	private int jahr;
	
	public Medium(String titel, int Jahr){
		id = Anzahl;
		Anzahl++;	
		this.titel = titel;
		this.jahr = Jahr;
	}

	public int alter(){
		Calendar Heute = new GregorianCalendar();
		return Heute.get(Calendar.YEAR) - jahr;
		
	}
	
	public int getID(){
		return id;
	}
	
	public int getJahr(){
		return jahr;
	}
	
	public String getTitel(){
		return titel;
	}
	
	public int compareTo(Medium Datei){
		
		if(this.getJahr() > Datei.getJahr())
			return -1;
		else if (this.getJahr() == Datei.getJahr())
			return 0;
		else
			return 1;
		
	}
	
	public abstract void druckeDaten(OutputStream Stream);
}
