package TP3;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;

public class MainCollecEntiers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> array = new ArrayList<>();
		LinkedList<Integer> linked = new LinkedList<>();
		
		long aStart = System.currentTimeMillis();
		int i;
		for(i = 0; i<100000; i++){
			array.add(i);
		}
		long aEnd = System.currentTimeMillis();
		long aTime = aEnd - aStart;
		System.out.println("Elapsed Time for the array and "+i+" elements : "+aTime+"ms");
		
		
		long lStart = System.currentTimeMillis();
		for(i = 0; i<100000; i++){
			linked.add(i);
		}
		long lEnd = System.currentTimeMillis();
		long lTime = lEnd - lStart;
		System.out.println("Elapsed Time for the array and "+i+" elements : "+lTime+"ms");
		for(i = 0; i<100000; i++){
			linked.add(i);
		}
		
		
		aStart = System.currentTimeMillis();
		for(i = 0; i<1000000; i++){
			array.add(i);
		}
		aEnd = System.currentTimeMillis();
		aTime = aEnd - aStart;
		System.out.println("Elapsed Time for the array and "+i+" elements : "+aTime+"ms");
		
		
		lStart = System.currentTimeMillis();
		for(i = 0; i<100000; i++){
			linked.add(i);
		}
		lEnd = System.currentTimeMillis();
		lTime = lEnd - lStart;
		System.out.println("Elapsed Time for the array and "+i+" elements : "+lTime+"ms");
		for(i = 0; i<100000; i++){
			linked.add(i);
		}
	}

}
