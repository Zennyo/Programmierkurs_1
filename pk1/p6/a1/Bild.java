package pk1.p6.a1;
import java.io.*;


public class Bild extends Medium implements Serializable{
	
	private static final long serialVersionUID = 123;
	
	private String ort;
		
	public Bild(String Titel, int Jahr, String ort) {
			super(Titel, Jahr);
			this.ort = ort;
		}
	
	@Override
	public void druckeDaten(OutputStream Stream){
		
		String daten = "ID = " + getID() + " \"" + getTitel() + "\" aufgenommen im Jahr " + getJahr() + " in " + ort + "\n";
		
		PrintStream Printer = new PrintStream(Stream);
		Printer.printf(daten);

	}
}
