package pk1.p6.a1;

public class Hauptprogramm {
	
	public static void main(String[] args){
	
		Medienverwaltung verwaltung = new Medienverwaltung();
		Menu frontend = new Menu(verwaltung);
		frontend.Auswahl();
	}

}
