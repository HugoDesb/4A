package TP7;

public class CommandeTrace implements Commande{

	@Override
	public void executeString(String str) {
		System.out.println("--"+str);
	}

}
