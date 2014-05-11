package pk1.p4.a1;
import pk1.p3.a3.*;
import java.util.*;
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
						AudioA();
						break;
					case 2:
						BildA();
						break;
					case 3:
						showA();
						break;
					case 4:
						showN();
						break;
					case 5:
						Durchschnitt();
						break;
					case 6:
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
		System.out.println("4. Zeige neues Medium");
		System.out.println("5. Berechne durchschnittliches Erscheinungsjahr");
		System.out.println("6. Beenden");
		System.out.println();
		System.out.println("Bitte Menüpunkt wählen:");
		System.out.println("----------------------------------------------------------");
	}
	
	private void AudioA(){
		
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
	
	private void BildA(){
		
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
	
	private void showA(){
		verwaltung.zeigeMedien();
	}
	
	private void showN(){
		verwaltung.sucheNeuesMedium();
	}
	
	private void Durchschnitt(){
		System.out.print("Durchschnittliches Erscheinungsjahr: " + verwaltung.berechneErscheinungsjahr());
	}
}
