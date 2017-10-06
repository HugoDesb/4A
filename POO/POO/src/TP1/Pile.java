package TP1;


/**
 * @author Hugo Desbiolles
 * Exercice 1
 */

public class Pile {
	private int [] stack;
	private int count;
	private int size;

	/**
	 * Constructor
	 * @param size
	 */
	public Pile(int size) {
		this.count = 0;
		this.size = size;
		this.stack = new int[size];
	}
	
	/**
	 * Add if possible the int
	 * @param el
	 */
	public void empiler(int el) {
		if(!pleine()) {
			stack[count] = el;
			count++;
		}
	}
	
	/**
	 * Remove the top of the stack if not already empty, then return the removed integer.
	 * If the stack was empty, then return 0;
	 * @return the removed integer (or 0)
	 */
	public int depiler() {
		if(!vide()) {
			count--;
			return stack[count];
		}else {
			return 0;
		}
	}
	
	/**
	 * Return whether the stack is full
	 * @return T/F
	 */
	public boolean pleine() {
		return count==size;
	}
	
	/**
	 * Return whether the stack is empty
	 * @return T/F
	 */
	public boolean vide() {
		return count==0;
	}

	@Override
	public String toString() {
		String ret = "Pile : (count=" + count + ", size=" + size + ")\n";
		for(int i = count-1; i>= 0; i--) {
			ret = ret + "\t"+stack[i]+"\n";
		}
		return ret;
	}
	
	
}
