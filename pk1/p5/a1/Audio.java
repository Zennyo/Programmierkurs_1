package pk1.p5.a1;
import java.io.*;

public class Audio extends Medium {
	
	private String interpret;
	private int dauer;
	
	public Audio(String titel, int Jahr, String interpret, int dauer){
		super(titel, Jahr);
		this.interpret = interpret;
		this.dauer = dauer;
	}
	
	@Override
	public void druckeDaten(OutputStream Stream){
		
		String daten = "ID = " + getID() + " \"" + getTitel() + "\" von: " + interpret + " aus " + getJahr() + " Spieldauer: " + dauer + " Sekunden.\n";
		
		PrintStream Printer = new PrintStream(Stream);
		Printer.printf(daten);

		
	}

}
