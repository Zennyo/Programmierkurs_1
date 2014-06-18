package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import fachkonzept.Bild;
import fachkonzept.Medienverwaltung;

public class BildErfassung extends JDialog  {
	
	public BildErfassung(final Medienverwaltung verwaltung, final List Liste){
		super();
		setModal(true);
		setSize(350, 200);
		setResizable(false);
			
		JPanel up = new JPanel();
		
		up.setLayout(new FlowLayout(FlowLayout.TRAILING));
		
		JPanel down = new JPanel();
		down.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		setLayout(new BorderLayout());
		
		add(up, BorderLayout.CENTER);
		add(down, BorderLayout.SOUTH);
		
		JPanel Titel = new JPanel();
		Titel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		final JTextField TitelTxt = new JTextField(20);
		Titel.add(new JLabel("Titel:"));
		Titel.add(TitelTxt);
		
		JPanel Ort = new JPanel();
		Ort.setLayout(new FlowLayout(FlowLayout.RIGHT));
		final JTextField OrtTxt = new JTextField(20);
		Ort.add(new JLabel("Ort:"));
		Ort.add(OrtTxt);
		
		JPanel Jahr = new JPanel();
		Jahr.setLayout(new FlowLayout(FlowLayout.RIGHT));
		final JTextField JahrTxt = new JTextField(20);
		Jahr.add(new JLabel("Aufnahmejahr:"));
		Jahr.add(JahrTxt);
		
		JPanel Buttons = new JPanel();
		JButton neu = new JButton("Neu");
		neu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int Jahr;
				try{
					Jahr = Integer.parseInt(JahrTxt.getText());
					
					Bild Aufnahme = new Bild();
					Aufnahme.setJahr(Jahr);
					Aufnahme.setTitel(TitelTxt.getText());
					Aufnahme.setOrt(OrtTxt.getText());
	
					Liste.add(Aufnahme.toString());
					verwaltung.aufnehmen(Aufnahme);
	
					setVisible(false);
					dispose();
				}
				
				catch(NumberFormatException i){
					JOptionPane.showMessageDialog(null, "Jahr muss eine Zahl sein!");
					i.printStackTrace();
				}
				
			}
		});
	
		JButton abbrechen = new JButton("Abbrechen");
		abbrechen.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		
		
		Buttons.add(neu);
		Buttons.add(abbrechen);
		
		up.add(Titel);
		up.add(Ort);
		up.add(Jahr);
		down.add(Buttons);
		
		setVisible(true);
	}	
}
