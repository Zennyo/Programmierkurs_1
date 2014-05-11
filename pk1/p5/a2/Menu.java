package pk1.p5.a2;

import pk1.p5.a1.*;
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
		System.out.println("7. Beenden");
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
		
		File Datei = new File(JOptionPane.showInputDialog("Dateiname:",null));
		
		try {
			FileOutputStream Stream = new FileOutputStream(Datei);
			verwaltung.druckeMedien(Stream);
		} 
	
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
}
