package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import fachkonzept.Audio;
import fachkonzept.Bild;
import fachkonzept.Medienverwaltung;

public class AudioErfassung extends JDialog  {
	

	public AudioErfassung(final Medienverwaltung verwaltung, final List Liste){
		super();
		setModal(true);
		setSize(350, 250);
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
		
		JPanel Dauer = new JPanel();
		Dauer.setLayout(new FlowLayout(FlowLayout.RIGHT));
		final JTextField DauerTxt = new JTextField(20);
		Dauer.add(new JLabel("Dauer:"));
		Dauer.add(DauerTxt);
		
		JPanel Interpret = new JPanel();
		Interpret.setLayout(new FlowLayout(FlowLayout.RIGHT));
		final JTextField InterpTxt = new JTextField(20);
		Interpret.add(new JLabel("Interpret:"));
		Interpret.add(InterpTxt);
		
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
				int Dauer;
				try{
					Jahr = Integer.parseInt(JahrTxt.getText());
					Dauer = Integer.parseInt(DauerTxt.getText());
					
					Audio Aufnahme = new Audio();
					Aufnahme.setJahr(Jahr);
					Aufnahme.setTitel(TitelTxt.getText());
					Aufnahme.setDauer(Dauer);
					Aufnahme.setInterpret(InterpTxt.getText());
	
					Liste.add(Aufnahme.toString());
					verwaltung.aufnehmen(Aufnahme);
	
					setVisible(false);
					dispose();
				}
				
				catch(NumberFormatException i){
					JOptionPane.showMessageDialog(null, "Jahr und Dauer müssen eine Zahlen sein!");
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
		up.add(Interpret);
		up.add(Dauer);
		up.add(Jahr);
		
		down.add(Buttons);
		
		setVisible(true);
	}	
}
