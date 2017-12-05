package TP7;

public class Invocateur {

	private Commande cDebut;
	private Commande cFin;


	public Invocateur(Commande cDebut, Commande cFin) {
		super();
		this.cDebut = cDebut;
		this.cFin = cFin;
	}

	public static void main(String[] args) {
		Commande cd = new CommandeTrace();
		Commande cf = new CommandeAppel();
		
		Invocateur inc = new Invocateur(cd, cf);
		
		inc.marmotte();
		inc.lapin();
		inc.lapin();
		inc.lapin();
		inc.marmotte();
		
	}
	
	public void lapin(){
		cDebut.executeString("lapin()");
		System.out.println("Je suis un lapin");
		cFin.executeString("lapin");
	}
	
	public void marmotte(){
		cDebut.executeString("marmotte()");
		System.out.println("Je suis une marmotte");
		cFin.executeString("marmotte");
	}

	public Commande getcDebut() {
		return cDebut;
	}

	public void setcDebut(Commande cDebut) {
		this.cDebut = cDebut;
	}

	public Commande getcFin() {
		return cFin;
	}

	public void setcFin(Commande cFin) {
		this.cFin = cFin;
	}
	
}
