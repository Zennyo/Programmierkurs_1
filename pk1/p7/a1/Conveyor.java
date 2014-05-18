package pk1.p7.a1;

import java.util.*;

public class Conveyor {
	
	private Queue<Bottle> belt = new LinkedList<Bottle>();
	private final int size = 49;
	private int count = 0;
	
	public void load (Bottle b){
		belt.add(b);
		count++;
		System.out.println("Band: Zahl der Flaschen " + count);
	}
	
	public Bottle withdraw(){
		count--;
		System.out.println("Band: Zahl der Flaschen " + count);
		return belt.poll();
		
	}
	
	public boolean isEmpty(){
		if(belt.isEmpty())
			return true;
		else
			return false;
	}
	
	public boolean isOverloaded(){
		if(count == size)
			return true;
		else
			return false;
	}
}
