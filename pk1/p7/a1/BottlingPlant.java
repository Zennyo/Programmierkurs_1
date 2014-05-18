package pk1.p7.a1;

public class BottlingPlant implements Runnable {
	
	Conveyor bottlingCon;
	
	public BottlingPlant(Conveyor bottlingCon){
		this.bottlingCon = bottlingCon;
	}
	
	public void run(){
		
		while(Thread.currentThread().isInterrupted() == false){
			
			Bottle Fanta = new Bottle();
			
			try{
				synchronized(bottlingCon){
					
					while(bottlingCon.isOverloaded())
					{
						System.out.println("Abfuellanlage: Band ist voll");
						bottlingCon.wait();
					}
					
					bottlingCon.load(Fanta);
					System.out.println("Abfuellanlage: Flasche abgestellt");
					bottlingCon.notifyAll();
	
				}
				Thread.sleep(10);
			}
			catch(InterruptedException e){
				
			}
		}
	}
}
