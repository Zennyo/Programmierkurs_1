package fachkonzept;

import java.io.*;

public class Bild extends Medium implements Serializable{
	
	private static final long serialVersionUID = 123;
	
	private String ort;
		
	public Bild() {
			super();
			setIdentity("Bild");
			
		}
	
	public String getOrt(){
		return ort;
	}
	
	public void setOrt(String ort){
		this.ort = ort;
	}
	
	@Override
	public void druckeDaten(OutputStream Stream){
		
		String daten = "ID = " + getID() + " \"" + getTitel() + "\" aufgenommen im Jahr " + getJahr() + " in " + getOrt() + "\n";
		
		PrintStream Printer = new PrintStream(Stream);
		Printer.printf(daten);

	}
	
	@Override
	public String toString(){
		String daten = "ID = " + getID() + " \"" + getTitel() + "\" aufgenommen im Jahr " + getJahr() + " in " + ort + "\n";
		return daten;
	}
}
