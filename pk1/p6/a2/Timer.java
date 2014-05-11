package pk1.p6.a2;

public class Timer implements Runnable{
	
	TimeListener timer = null;
	
	@Override
	public void run() {
		
		while(Thread.currentThread().isInterrupted() == false){
			
			timer.signalPerformed();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				System.out.println("Timer unterbrochen");
				Thread.currentThread().interrupt();
			}
		}
	}
	
	public Timer(TimeListener timer){
		this.timer = timer;
	}
}
