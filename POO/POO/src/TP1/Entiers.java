
package TP1;

import java.util.Iterator;

import TP2.Structure;
import TP6.BidirInterator;
import TP6.MonIterable;
import TP6.MonIterator;
import TP6.SupIterator;

/**
 * Exercice 2
 * @author Hugo Desbiolles
 * @param <T>
 */
public class Entiers<T> extends Structure implements MonIterable{
	private int[] set;
	private int maxSize;
	private int count;
	
	/**
	 * Constructor
	 * @param size
	 */
	public Entiers(int size) {
		this.maxSize = size;
		set = new int[size];
		count = 0;
	}
	
	/**
	 * Insert the integer if possible avoiding repetitions
	 * @param el
	 */
	public void inserer(int el) {
		if((containsAndWhere(el) == -1) && (count<maxSize) ) {
			int i = 0;
			while (el > set[i] && i<count) {
				i++;
			}
			for(int j = count; j>i; j--) {
				set[j] = set[j-1];
			}
			set[i] = el;
			count++;
		}
	}
	
	/**
	 * Delete the integer if found
	 * @param el
	 * @throws NotElementEntiers 
	 */
	public void supprimer(int el) throws NotElementEntiers {
		int position = containsAndWhere(el);
		if(position == -1){
			throw new NotElementEntiers(el);
		}else{
			for(int i=position; i<count-1; i++) {
				set[i] = set[i+1];
			}
			count--;
			System.out.println("Element " + el + " supprim�.");
		}
	}
	
	/**
	 * Return the count of the element if found (if not, returns -1)
	 * @param el
	 * @return the count of the element (-1 if not found)
	 */
	private int containsAndWhere(int el) {
		int ret = -1;
		for(int i=0; (i<count) && (ret==-1); i++) {
			if(set[i] == el) {
				ret=i;
			}
		}
		return ret;
	}

	@Override
	public String toString() {
		String ret = "Entiers ( size=" + maxSize + ", count=" + count + ")\n\t(";
		int i;
		for(i = 0; i<count-1;i++) {
			ret += set[i]+", ";
		}
		ret += set[i]+")";
		return ret;
	}
	
	public void afficher(){
		System.out.println(toString());
	}

	@Override
	public void compacter(int nbElementASupprimer) {
		count = count - nbElementASupprimer;
		if(count < 0){
			count=0;
		}	
	}
	
	/**
	 * Returns the nb at the specified index
	 * @param i
	 * @return an int
	 * @throws HorsLimite
	 */
	public int get(int i) throws HorsLimite{
		if(i<0 || i>=count){
			throw new HorsLimite(i);
		}else{
			return set[i];
		}
	}
	
	
	
	


	public MonIterator createIterator() {
		// TODO Auto-generated method stub
		return new EntIterator();
	}
	
	public class EntIterator implements BidirInterator, SupIterator{
		private int courant;
		
		public EntIterator() {
			// TODO Auto-generated constructor stub
			courant = 0;
		}
		
		@Override
		public int courant() {
			// TODO Auto-generated method stub
			return set[courant];
		}

		@Override
		public void suivant() {
			// TODO Auto-generated method stub
			courant++;
		}

		@Override
		public boolean fin() {
			// TODO Auto-generated method stub
			return courant == count;
		}
		@Override
		public void supprime() {
			if(count>=1){
				for(int i = courant; i<count;i++){
					set[courant] = set[courant+1];
				}
				count--;
			}
		}

		@Override
		public void precedent() {
			courant--;
		}

		
	}
	
}
