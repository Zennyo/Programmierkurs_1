package hauptprogramm;
import datenhaltung.*;
import fachkonzept.*;
import gui.*;

public class Hauptprogramm {
	
	public static void main(String[] args){
		
		IMvDAO dao = new MediumSerializeDAO();
		
		Medienverwaltung verwaltung = new Medienverwaltung(dao);
		
		/*
		Bild test = new Bild();
		test.setJahr(1988);
		test.setOrt("Dortmund");
		test.setTitel("Moritz");
		
		
		Bild test1 = new Bild();
		test1.setJahr(1989);
		test1.setOrt("Bremen");
		test1.setTitel("Bob");
		
		
		Bild test2 = new Bild();
		test2.setJahr(1990);
		test2.setOrt("Hamburg");
		test2.setTitel("Hubert");
		
		Audio test3 = new Audio();
		test3.setJahr(1990);
		test3.setInterpret("Hamburg");
		test3.setTitel("Hubert");
		test3.setDauer(234);
		
		verwaltung.aufnehmen(test);
		verwaltung.aufnehmen(test1);
		verwaltung.aufnehmen(test2);
		verwaltung.aufnehmen(test3);*/
		
		HauptFenster programm = new HauptFenster(verwaltung);
	}

}
