package datenhaltung;

import java.util.List;

import fachkonzept.Medium;

public interface IMvDAO {
	
	void speichern(List<Medium> liste) throws PersistenzException;
	
	List<Medium> laden() throws PersistenzException;

}
