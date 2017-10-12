package TP1;

import java.util.ArrayDeque;
import java.util.Iterator;


/**
 * @author Hugo Desbiolles
 * Exercice 1
 */

public class Pile<E> {
	private ArrayDeque<E> stack;
	private int maxSize;

	/**
	 * Constructor
	 * @param size
	 */
	public Pile(int maxSize) {
		this.maxSize = maxSize;
		this.stack = new ArrayDeque<>(maxSize);
	}
	
	/**
	 * Add if possible the int
	 * @param el
	 */
	public void empiler(E el) {
		if(!pleine()) {
			stack.push(el);
		}
	}
	
	/**
	 * Remove the top of the stack if not already empty, then return the removed integer.
	 * If the stack was empty, then return 0;
	 * @return the removed integer (or 0)
	 * @throws PileVide 
	 */
	public E depiler() throws PileVide {
		if(!vide()) {
			System.out.println(toString());
			return stack.pop();
		}else {
			throw new PileVide();
		}
	}
	
	/**
	 * Return whether the stack is full
	 * @return T/F
	 */
	public boolean pleine() {
		return stack.size() == maxSize;
	}
	
	/**
	 * Return whether the stack is empty
	 * @return T/F
	 */
	public boolean vide() {
		return stack.isEmpty();
	}

	@Override
	public String toString() {
		String ret = "Pile : (count=" + stack.size() + ", size=" + maxSize + ")\n";
		Iterator<E> a = stack.iterator();
		while(a.hasNext()){
			ret = ret + "\t"+a.next()+"\n";
		}
		return ret;
	}
	
	
}
