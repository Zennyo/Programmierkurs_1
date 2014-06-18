package fachkonzept;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Medium implements Comparable<Medium>, Serializable {

	private static final long serialVersionUID = 123;
	
	private static int Anzahl = 0;
	
	private int id;
	private String titel;
	private int jahr;
	private String identity = "Medium";
	
	public Medium(){
		id = Anzahl;
		Anzahl++;	
	}
	
	public int alter(){
		Calendar Heute = new GregorianCalendar();
		return Heute.get(Calendar.YEAR) - jahr;
		
	}
	
	public int getID(){
		return id;
	}
	
	protected void setAnzahl(int i){
		Anzahl = i;
	}
	
	public void setIdentity(String identity){
		this.identity = identity;
	}
	
	public String getIdentity(){
		return identity;
	}
	
	public int getJahr(){
		return jahr;
	}
	
	public void setJahr(int jahr){
		this.jahr = jahr;
	}
	
	public String getTitel(){
		return titel;
	}
	
	public void setTitel(String titel){
		this.titel = titel;
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
