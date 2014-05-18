package pk1.p7.a1;

public class LabelingMachine implements Runnable {
	
	Conveyor labelingCon;
	Bottle fanta;
	Lable lable;
	
	public LabelingMachine(Conveyor labelingCon){
		this.labelingCon = labelingCon;
	}
	
	public void run(){
		
		while (Thread.currentThread().isInterrupted() == false){
			try{
				synchronized(labelingCon){
					
					while(labelingCon.isEmpty()){
						System.out.println("Druckanlage: Band ist leer ");
						labelingCon.wait();
					}
					
					fanta = labelingCon.withdraw();
					lable = new Lable("Fanta", 2015);
					fanta.stickLable(lable);
					System.out.println("Druckanlage: Flasche bedruckt");
					fanta.printLable();
					labelingCon.notifyAll();
				}
				Thread.sleep(20);
			}
			catch(InterruptedException e){
				
			}
		}
		
	}

}
