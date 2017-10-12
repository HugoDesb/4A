package TP2;

import TP1.NotElementEntiers;
import TP1.NotElementListe;

public abstract class Structure implements Affichable, Compactable{

	public abstract void inserer(int nb);
	public abstract void supprimer(int nb) throws NotElementEntiers, NotElementListe;
}
