package pk1.p6.a2;

import javax.swing.JOptionPane;

public class Zeitansage implements TimeListener {
	
	private int sekunde;
	
	@Override
	public void signalPerformed(){
		System.out.println(sekunde + " Sekunden seit Start");
		sekunde++;
	}
	
	public void start(){
		
		Thread timer = new Thread(new Timer(this));
		timer.start();
		
		JOptionPane.showMessageDialog(null, "Zeitansage stoppen");
		timer.interrupt();
		
	}
	
	public static void main(String[] args){
			
		Zeitansage ansage = new Zeitansage();
		
		ansage.start();
	}
}
