package TP7;

public class Singleton {
	private int grosseValeur;
	static private Singleton instance = null;
	
	private Singleton(){
		grosseValeur = 1000;
	}
	
	public static Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
	
	public int getGrosseValeur(){
		return grosseValeur;
	}
	
	public void add(int i){
		grosseValeur+=i;
	}

	@Override
	public String toString() {
		return "Singleton [grosseValeur=" + grosseValeur + "]";
	}

	
	
	
	
}
