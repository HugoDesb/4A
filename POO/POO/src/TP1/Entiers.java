package TP1;

import TP2.Structure;

/**
 * Exercice 2
 * @author Hugo Desbiolles
 */
public class Entiers extends Structure {
	private int[] set;
	private int size;
	private int count;
	
	/**
	 * Constructor
	 * @param size
	 */
	public Entiers(int size) {
		this.size = size;
		set = new int[size];
		count = 0;
	}
	
	/**
	 * Insert the integer if possible avoiding repetitions
	 * @param el
	 */
	public void inserer(int el) {
		if((containsAndWhere(el) == -1) && (count<size) ) {
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
		String ret = "Entiers ( size=" + size + ", count=" + count + ")\n\t(";
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
	
	
	
}
