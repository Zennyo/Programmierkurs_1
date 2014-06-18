package gui;

import fachkonzept.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.table.*;

public class Tabelle extends JFrame {
	
	public Tabelle(Medienverwaltung verwaltung, boolean Audio){
		
		setSize(300, 300);
		setLayout(new BorderLayout());
		
		JPanel up = new JPanel();
		JPanel down = new JPanel();
		up.setLayout(new BorderLayout());
		down.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				
			}
		});
		
		JTable tabelle = null;
		
		if(Audio == true){
			String[][] audio = AudioDaten(verwaltung);
			String[] audiotitel = new String[]{"Titel","Interpret","Dauer","Jahr"};
			tabelle = new JTable(audio,audiotitel);
		}
		
		else{
			String[][] Bild = BildDaten(verwaltung);
			String[] Bildtitel = new String[]{"Titel","Ort","Aufnahmejahr"};
			tabelle = new JTable(Bild,Bildtitel);
		}
		
		tabelle.getTableHeader().setVisible(true);
		tabelle.setAutoCreateRowSorter(true);
		JScrollPane Scroller = new JScrollPane(tabelle);
		
		up.add(Scroller, BorderLayout.CENTER);
		down.add(ok);
		
		add(up, BorderLayout.CENTER);
		add(down, BorderLayout.SOUTH);
		
		setVisible(true);
		
	}
	
	public String[][] AudioDaten(Medienverwaltung verwaltung){
		String[][] daten = new String[verwaltung.getSize()][4];
		String[][] datenFormat;
		Iterator<Medium> lauf = verwaltung.iterator();
		int i = 0;
		Medium blick;
		while(lauf.hasNext()){
			blick = lauf.next();
			if(blick.getIdentity().equals("Audio")){
				Audio lied = (Audio)blick;
				daten[i][0] = lied.getTitel();
				daten[i][1] = lied.getInterpret();
				daten[i][2] = Integer.toString(lied.getDauer());
				daten[i][3] = Integer.toString(lied.getJahr());
				i++;
			}
		}
		datenFormat = new String[i][4];
		for(int ii = 0; ii < i; ii++){
			datenFormat[ii] = daten[ii];
		}
		return datenFormat;
	}
	
	public String[][] BildDaten(Medienverwaltung verwaltung){
		String[][] daten = new String[verwaltung.getSize()][3];
		String[][] datenFormat;
		Iterator<Medium> lauf = verwaltung.iterator();
		int i = 0;
		Medium blick;
		while(lauf.hasNext()){
			blick = lauf.next();
			if(blick.getIdentity().equals("Bild")){
				Bild bild = (Bild)blick;
				daten[i][0] = bild.getTitel();
				daten[i][1] = bild.getOrt();
				daten[i][2] = Integer.toString(bild.getJahr());
				i++;
			}
		}
		datenFormat = new String[i][4];
		for(int ii = 0; ii < i; ii++){
			datenFormat[ii] = daten[ii];
		}
		return datenFormat;
	}
}
