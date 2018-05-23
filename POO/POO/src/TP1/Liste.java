package TP1;

import TP1.Entiers.EntIterator;
import TP2.Structure;
import TP6.InitIterator;
import TP6.InsIterator;
import TP6.MonIterable;
import TP6.MonIterator;

/**
 * @author Hugo Desbiolles
 * Exercice 3
 */
public class Liste extends Structure implements Cloneable, MonIterable{
	private Element[] list;
	private int count;
	private int maxSize;
	
	/**
	 * Constructor
	 */
	public Liste(int size) {
		this.maxSize = size;
		count = 0;
		list = new Element[size];
	}
	
	/**
	 * Find the index of the param nb in the list if found. If not found, returns -1
	 * @param nb
	 * @return the index or -1 (int)
	 */
	private int containsAndWhere(int nb) {
		int ret = -1;
		for(int i = 0; (i<count) && (ret==-1); i++){
			if(list[i].getNumber() == nb) {
				ret = i;
			}
		}
		return ret;
	}
	
	/**
	 * Insert the given number at the start of the list if not already in it.
	 * @param nb
	 */
	public void inserer(int nb) {
		if(containsAndWhere(nb) == -1 && count<maxSize) {
			if(count>1) {
				for(int i = count; i>0; i--) {
					list[i] = list[i-1];
				}
			}else if(count==1) {
				list[count] = list[count-1];
			}
			list[0] = new Element(nb);
			count++;
		}
	}
	
	/**
	 * Remove the given number of the list if present.
	 * @param nb
	 * @throws NotElementListe 
	 */
	public void supprimer(int nb) throws NotElementListe {
		int position = containsAndWhere(nb);
		if(position == -1){
			throw new NotElementListe();
		}
		if(position != -1) {
			for(int i = position; i<count-1;i++) {
				list[i] = list[i+1];
			}
			count--;
		}
	}

	@Override
	public String toString() {
		String ret =  "Liste [maxSize=" + maxSize + "] \n\t(";
		for(int i = 0; i<=count-1; i++) {
			ret += list[i].toString() + ",";
		}
		ret += ")";
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
	
	@Override
	public Liste clone(){
		Liste l = new Liste(maxSize);
		for(int i = count-1;i>=0;i--){
			l.inserer(list[i].getNumber());
		}
		
		return l;
	}

	@Override
	public MonIterator createIterator() {
		// TODO Auto-generated method stub
		
		return new ListeIterator();
	}
	
	public class ListeIterator implements InitIterator, InsIterator{
		private int courant;
		
		public ListeIterator() {
			courant = 0;
		}

		Element crt;
		
		@Override
		public int courant() {
			// TODO Auto-generated method stub
			return list[courant].getNumber();
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
		public void inserer(int i) {
			// TODO Auto-generated method stub
			if(count<maxSize) {
				Element ins = new Element(i);
				for(int k = count; k>courant; k--){
					list[k] = list[k--];
				}
				list[courant] = ins;
				count++;
			}
		}

		@Override
		public void init() {
			// TODO Auto-generated method stub
			courant = 0;
		}
	}
}





/**
 * Element containing an int
 */
class Element{
	private int number;

	/**
	 * Constructor
	 * @param number
	 */
	public Element(int number) {
		this.number = number;
	}

	/**
	 * Getter for the number
	 * @return int number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Set the number with the given value
	 * @param number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return " " + number + " ";
	}
	
	
	
}
