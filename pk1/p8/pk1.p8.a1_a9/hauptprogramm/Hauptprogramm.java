package hauptprogramm;
import datenhaltung.*;
import fachkonzept.*;
import gui.*;

public class Hauptprogramm {
	
	public static void main(String[] args){
		
		String LadenVon = "C:/Users/Zen/Desktop/datB.txt";
		String SpeichernIn = "C:/Users/Zen/Desktop/datB.txt";
		
		IMvDAO dao = new MediumSerializeDAO(SpeichernIn, LadenVon);
		
		Medienverwaltung verwaltung = new Medienverwaltung(dao);
		
		HauptFenster programm = new HauptFenster(verwaltung);
	}

}
