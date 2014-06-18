package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import fachkonzept.Medienverwaltung;
import fachkonzept.Medium;

import javax.swing.*;
import javax.swing.border.Border;

import pk1.p6.a1.EmptyFilenameException;
import datenhaltung.PersistenzException;

public class HauptFenster extends JFrame{
	
	private final Medienverwaltung verwaltung;
	private final List Liste = new List();
	
	public HauptFenster(final Medienverwaltung verwaltung){
		super("Medienverwaltung");
		this.verwaltung = verwaltung;
			
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JMenuBar Leiste = new JMenuBar();
		
		JMenu Datei = new JMenu("Datei");
		JMenu Medium = new JMenu("Medium");
		JMenu Anzeige = new JMenu("Anzeige");
		
		JMenuItem Speichern = 		new JMenuItem("Speichern");
		Speichern.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
					try {
						verwaltung.speichern();
						JOptionPane.showMessageDialog(null, "Erfolgreich gespeichert!");
					} 
					catch (PersistenzException i) {
						JOptionPane.showMessageDialog(null, "Fehler in der Datenhaltung!");
						i.printStackTrace();
					}
			}
		});		
				
		JMenuItem Laden = 			new JMenuItem("Laden");
		Laden.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
					try {
						verwaltung.laden();
						verwaltung.setAnzahl();
						Liste.removeAll();
						datenAktualisieren(verwaltung, Liste);
						JOptionPane.showMessageDialog(null, "Erfolgreich geladen!");
						
					} 
					catch (PersistenzException i) {
						
						JOptionPane.showMessageDialog(null, "Fehler in der Datenhaltung!");
						i.printStackTrace();
					}
			}
		});	
		
		JMenuItem Schreiben = 		new JMenuItem("Medienliste in Datei schreiben");
		Schreiben.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				boolean erfolgreich = false;
				
				while (erfolgreich == false){
					try {
						File Dateiname = Datei();
						if(Dateiname.isFile()){
							FileOutputStream Stream = new FileOutputStream(Dateiname);
							verwaltung.druckeMedien(Stream);
							JOptionPane.showMessageDialog(null, "Erfolgreich geschrieben in " + Dateiname.toString());
							erfolgreich = true;
						}
						else
							JOptionPane.showMessageDialog(null, "Angabe war keine Datei");	
					} 
					
					catch (EmptyFilenameException i){
						JOptionPane.showMessageDialog(null, "Dateiname darf nicht leer sein");
					}
				
					catch (FileNotFoundException i) {
						i.printStackTrace();
					}
				}
			}
		});	
		
		JMenuItem Audio = 			new JMenuItem("Audio neu");
		Audio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				AudioErfassung Audio = new AudioErfassung(verwaltung, Liste);
				
			}
		});
		
		JMenuItem Bild = 			new JMenuItem("Bild neu");
		Bild.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				BildErfassung Bild = new BildErfassung(verwaltung, Liste);
			}
		});
		
		JMenuItem Erscheinung = 	new JMenuItem("Durchschnittliches Erscheinungsjahr");
		Erscheinung.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Das Durchschnittliche Erscheinungsjahr ist: " + verwaltung.berechneErscheinungsjahr());
			}
		});
		
		JMenuItem Neustes = 		new JMenuItem("Neustes Medium");
		Neustes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Das Neuste Medium ist: " + verwaltung.sucheNeuesMedium().toString());
			}
		});
		
		JMenuItem AlleAudio = 		new JMenuItem("Alle Audio-Einträge");
		AlleAudio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Tabelle AudioA = new Tabelle(verwaltung, true);
			}
		});
		
		JMenuItem AlleBilder = 		new JMenuItem("Alle Bild-Einträge");
		AlleBilder.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Tabelle BilderA = new Tabelle(verwaltung, false);
			}
		});
		
		JMenuItem Beenden = 		new JMenuItem("Beenden");
		Beenden.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		
		Laden.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Event.CTRL_MASK));
		Speichern.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
		Schreiben.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.ALT_MASK));
		Audio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
		Bild.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, Event.CTRL_MASK));
		Erscheinung.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, Event.CTRL_MASK));
		Neustes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
		AlleAudio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.ALT_MASK));
		AlleBilder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, Event.ALT_MASK));
		Beenden.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, Event.SHIFT_MASK));
		
		Datei.add(Speichern);
		Datei.add(Laden);
		Datei.add(Schreiben);
		Datei.addSeparator();
		Datei.add(Beenden);
		Datei.setMnemonic(KeyEvent.VK_D);
		
		Medium.add(Audio);
		Medium.add(Bild);
		Medium.setMnemonic(KeyEvent.VK_M);
		
		Anzeige.add(Erscheinung);
		Anzeige.add(Neustes);
		Anzeige.addSeparator();
		Anzeige.add(AlleAudio);
		Anzeige.add(AlleBilder);
		Anzeige.setMnemonic(KeyEvent.VK_A);
		
		Leiste.add(Datei);
		Leiste.add(Medium);
		Leiste.add(Anzeige);
		
		setJMenuBar(Leiste);

		JPanel Bereich = new JPanel();
		Bereich.setLayout(new BorderLayout());

		Border titel = BorderFactory.createTitledBorder("Medienliste");
		Bereich.setBorder(titel);
	
		datenAktualisieren(verwaltung, Liste);
		
		Bereich.add(Liste, BorderLayout.CENTER);
		add(Bereich, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public void datenAktualisieren (Medienverwaltung verwaltung, List Liste){

		Iterator<Medium> lauf = verwaltung.iterator();
		while(lauf.hasNext()){
			Liste.add(lauf.next().toString());
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
}
