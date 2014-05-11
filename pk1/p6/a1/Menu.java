package pk1.p6.a1;

import java.util.*;
import java.io.*;

import javax.swing.JOptionPane;

public class Menu {
	
	Scanner eingabe;
	Medienverwaltung verwaltung;
	
	public Menu (Medienverwaltung verwaltung){
		this.verwaltung = verwaltung;
	}
	
	public void Auswahl(){
	
	boolean beendet = false;
	int wahl;
	
	while(beendet == false){
		
			Print();
		
			try{
				
				eingabe = new Scanner(System.in);
				wahl = eingabe.nextInt();
				
					switch(wahl){
					
					case 1:
						nimmAudio();
						break;
					case 2:
						nimmBild();
						break;
					case 3:
						zeigeAlleMedien();
						break;
					case 4:
						medienSchreiben();
						break;
					case 5:
						zeigeNeustesMedium();
						break;
					case 6:
						durchschnitt();
						break;
					case 7:
						listeSpeichern();
						break;
					case 8:
						ListeLaden();
						break;
					case 9:
						beendet = true;
						break;
					default:
						break;
					}
			}
			
			catch (java.util.InputMismatchException Fehler){
				
				System.out.println("Bitte Zahlen zwischen 1 und 6 Eingeben.");			
			}
		}
	}
		
	private void Print(){
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println("1. Audio aufnehmen");
		System.out.println("2. Bild aufnehmen");
		System.out.println("3. Zeige alle Medien");
		System.out.println("4. Medienliste in Datei schreiben");
		System.out.println("5. Zeige neues Medium");
		System.out.println("6. Berechne durchschnittliches Erscheinungsjahr");
		System.out.println("7. Medienliste Speichern");
		System.out.println("8. Medienliste Laden");
		System.out.println("9. Beenden");
		System.out.println();
		System.out.println("Bitte Menüpunkt wählen:");
		System.out.println("----------------------------------------------------------");
	}
	
	private void nimmAudio(){
		
		String titel;
		String interpret;
		int jahr = 0;
		int dauer = 0;		
		boolean erfolgreich = false;
		
		titel = JOptionPane.showInputDialog("Titel:",null);
		interpret = JOptionPane.showInputDialog("Interpret:",null);
		
		while(erfolgreich == false){
			try{
				jahr = Integer.parseInt(JOptionPane.showInputDialog("Jahr:",null));
				erfolgreich = true;
			}
			catch (java.lang.NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Bitte gültiges Jahr eingeben");
			}
		}
		
		erfolgreich = false;
		
		while(erfolgreich == false){
			try{
				dauer = Integer.parseInt(JOptionPane.showInputDialog("Dauer:",null));
				erfolgreich = true;
			}
			catch (java.lang.NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Bitte gültige Dauer eingeben");
			}
		}
		
		Audio i = new Audio(titel,jahr,interpret,dauer);
		verwaltung.aufnehmen(i);
	}
	
	private void nimmBild(){
		
		String titel;
		String ort;
		int jahr = 0;
		boolean erfolgreich = false;
		
		titel = JOptionPane.showInputDialog("Titel:",null);
		ort = JOptionPane.showInputDialog("Ort:",null);
		
		while(erfolgreich == false){
			try{
				jahr = Integer.parseInt(JOptionPane.showInputDialog("Jahr:",null));
				erfolgreich = true;
			}
			catch (java.lang.NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Bitte gültiges Jahr eingeben");
			}
		}
		
		Bild i = new Bild(titel,jahr,ort);
		verwaltung.aufnehmen(i);
		
	}
	
	private void zeigeAlleMedien(){
		
			verwaltung.druckeMedien(System.out);
	}
	
	private void zeigeNeustesMedium(){
		
			verwaltung.sucheNeuesMedium(System.out);
	}
	
	private void durchschnitt(){
		System.out.print("Durchschnittliches Erscheinungsjahr: " + verwaltung.berechneErscheinungsjahr());
	}

	private void medienSchreiben(){
		
		boolean erfolgreich = false;
		
		while (erfolgreich == false){
			try {
				File Dateiname = Datei();
				if(Dateiname.isFile()){
					FileOutputStream Stream = new FileOutputStream(Dateiname);
					verwaltung.druckeMedien(Stream);
					erfolgreich = true;
				}
				else
					JOptionPane.showMessageDialog(null, "Angabe war keine Datei");
					
			} 
			
			catch (EmptyFilenameException e){
				JOptionPane.showMessageDialog(null, "Dateiname darf nicht leer sein");
			}
		
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private File Datei() throws EmptyFilenameException{
		
		String pfad;
		File datei = null;
		
		if((pfad = JOptionPane.showInputDialog("Dateiname:",null)) != null){
			datei = new File(pfad);
			return datei;
		}
		
		else 
			throw new EmptyFilenameException();
	}

	private void listeSpeichern(){
		File speicherort = new File("C:/Users/Zen/Desktop/datB.txt");
		ObjectOutputStream speicherStream = null;
		FileOutputStream dateiStream = null;
		
		try {
			dateiStream = new FileOutputStream(speicherort);
			speicherStream = new ObjectOutputStream(dateiStream);
			
			speicherStream.writeObject(verwaltung);
			speicherStream.close();
			
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}	
	}
	
	private void ListeLaden(){
		
		File ladeerort = new File("C:/Users/Zen/Desktop/datB.txt");
		ObjectInputStream ladeStream = null;
		FileInputStream dateiStream = null;
		
		try {
			dateiStream = new FileInputStream(ladeerort);
			ladeStream = new ObjectInputStream(dateiStream);
			verwaltung = (Medienverwaltung)ladeStream.readObject();
			verwaltung.setAnzahl();
			ladeStream.close();
		}
			
		catch (ClassNotFoundException e) {
				
			System.out.println("Problem mit klasse");
		}	
		catch (FileNotFoundException e) {
			
			System.out.println("Problem mit Datei");
		}
		catch (IOException e) {
			
			System.out.println("IO Problem");
		}
		
		
	}

}
