package TP4;

import java.util.Scanner;

import TP1.Entiers;
import TP1.NotElementEntiers;

public class ExoUnB {

	public static void main(String[] args) {
		Entiers a = new Entiers(1000);
		boolean continuer = true;
		Scanner sc = new Scanner(System.in);
		int choix,entier;
		do {
			a.afficher();
			System.out.println("Veuillez séléctionner l'action a effectuer :");
			System.out.println("0 - Insérer un entier");
			System.out.println("1 - Supprimer un entier");
			System.out.println("* - Sortir\n");
			choix = sc.nextInt();
			if(choix==0 || choix==1) {
				System.out.println("Quel entier pour cette opérartion ?\n");
				entier = sc.nextInt();
				if(choix==0) {
					//Insertion
					a.inserer(entier);
				}else {
					//Suppression
					try {
						a.supprimer(entier);
					} catch (NotElementEntiers e) {
						e.printStackTrace();
					}
				}
			}else {
				continuer = false;
			}
			
		}while(continuer);
		sc.close();
	}

}
