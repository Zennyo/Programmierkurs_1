package pk1.p1.a1;

public class Bild extends Medium{
	
private String ort;
		
	public Bild(String Titel, int Jahr, String ort) {
			super(Titel, Jahr);
			this.ort = ort;
		}
	
	@Override
	public void druckeDaten(){
		
		System.out.println("ID = " + getID() + " \"" + getTitel() + "\" aufgenommen im Jahr " + getJahr() + " in " + ort);	
	}
}
