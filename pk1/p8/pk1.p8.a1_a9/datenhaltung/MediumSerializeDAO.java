package datenhaltung;

import java.io.*;
import java.util.*;

import fachkonzept.Medium;

public class MediumSerializeDAO implements IMvDAO {

	File speicherort;
	File ladeort;

	public MediumSerializeDAO(String SpeicherOrt,String LadeOrt){
		
		this.speicherort = new File(SpeicherOrt);
		this.ladeort = new File(LadeOrt);
	}
		
	public void speichern(List<Medium> liste) throws PersistenzException {
			
		ObjectOutputStream speicherStream = null;
		FileOutputStream dateiStream = null;
		
		try {
			dateiStream = new FileOutputStream(speicherort);
			speicherStream = new ObjectOutputStream(dateiStream);
			
			speicherStream.writeObject(liste);
			speicherStream.close();
			
		} 
		catch (FileNotFoundException e) {
			
			throw new PersistenzException();
		}
		catch (IOException e) {
			
			throw new PersistenzException();
		}	
		
	}

	public List<Medium> laden() throws PersistenzException {
		
		List<Medium> Liste = null;
		
		ObjectInputStream ladeStream = null;
		FileInputStream dateiStream = null;
		
		try {
			dateiStream = new FileInputStream(ladeort);
			ladeStream = new ObjectInputStream(dateiStream);
			Liste = (List)ladeStream.readObject();
			ladeStream.close();
		}
			
		catch (ClassNotFoundException e) {
				
			throw new PersistenzException();
		}	
		catch (FileNotFoundException e) {
			
			throw new PersistenzException();
		}
		catch (IOException e) {
			
			throw new PersistenzException();
		}
			
		return Liste;
	}
}
