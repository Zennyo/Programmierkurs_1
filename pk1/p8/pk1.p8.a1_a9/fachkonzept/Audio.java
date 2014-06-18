package fachkonzept;

import java.io.*;

public class Audio extends Medium implements Serializable {

	private static final long serialVersionUID = 123;
	
	private String interpret;
	private int dauer;
	
	public Audio(){
		super();
		setIdentity("Audio");
	}
	
	public void setInterpret(String interpret){
		this.interpret = interpret;
	}
	
	public void setDauer(int dauer){
		this.dauer = dauer;
	}
	
	public String getInterpret(){
		return interpret;
	}
	
	public int getDauer(){
		return dauer;
	}
	
	@Override
	public void druckeDaten(OutputStream Stream){
		
		String daten = "ID = " + getID() + " \"" + getTitel() + "\" von: " + getInterpret() + " aus " + getJahr() + " Spieldauer: " + getDauer() + " Sekunden.\n";
		PrintStream Printer = new PrintStream(Stream);
		Printer.printf(daten);
	}
	
	@Override
	public String toString(){
		String daten = "ID = " + getID() + " \"" + getTitel() + "\" von: " + interpret + " aus " + getJahr() + " Spieldauer: " + dauer + " Sekunden.\n";
		return daten;
	}

}
