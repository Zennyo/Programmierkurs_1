package pk1.p1.a1;

import java.util.*;

public abstract class Medium {

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
	
	public abstract void druckeDaten();
	

}
