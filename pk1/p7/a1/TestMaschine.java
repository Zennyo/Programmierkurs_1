package pk1.p7.a1;

public class TestMaschine {

	public static void main(String[] args){
		
		Conveyor Band = new Conveyor();
		BottlingPlant Abfuell = new BottlingPlant(Band);
		LabelingMachine Etikett = new LabelingMachine(Band);
		
		Thread Ab = new Thread(Abfuell);
		Thread Et = new Thread(Etikett);
		
		Ab.start();
		Et.start();
		
		
		
		
	}
	
}
