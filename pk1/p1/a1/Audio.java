package pk1.p1.a1;

public class Audio extends Medium {
	
	private String interpret;
	private int dauer;
	
	public Audio(String titel, int Jahr, String interpret, int dauer){
		super(titel, Jahr);
		this.interpret = interpret;
		this.dauer = dauer;
	}
	
	@Override
	public void druckeDaten(){
		
		System.out.println("ID = " + getID() + " \"" + getTitel() + "\" von: " + interpret + " aus " + getJahr() + " Spieldauer: " + dauer + " Sekunden.");
	}

}
