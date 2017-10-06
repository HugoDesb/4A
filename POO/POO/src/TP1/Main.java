package TP1;

public class Main {

	public static void main(String[] args) {
		
		/**
		 * Tests Exercice 1
		 */
		System.out.println("-------------------");
		System.out.println("Tests Exercice 1 ");
		System.out.println("-------------------");
		
		Pile a = new Pile(6);
		System.out.println("La pile est-elle vide (oui)"+a.vide());
		a.empiler(1);
		a.empiler(2);
		a.empiler(3);
		System.out.println("La pile est-elle vide (non)"+a.vide());
		System.out.println("La pile est-elle pleine (non)"+a.pleine());
		a.empiler(4);
		a.empiler(5);
		System.out.println(a.toString());
		System.out.println("d�piler " + a.depiler());
		System.out.println(a.toString());
		a.empiler(7);
		a.empiler(9);
		System.out.println("Empiler 7 et 9 : La pile est-elle pleine (oui)"+a.pleine());
		
		System.out.println(a.toString());
		a.empiler(10);
		System.out.println("empiler 10 : La pile doit �tre la m�me que pr�c�demment. "+a.toString());
		
		a.depiler();a.depiler();a.depiler();
		a.depiler();a.depiler();a.depiler();
		System.out.println("on vide la pile " + a.toString());
		a.depiler(); //une erreur est-elle lanc�e (normalement non).
		
		/**
		 * Tests Exercice 2
		 */
		System.out.println("\n-------------------");
		System.out.println("Tests Exercice 2 ");
		System.out.println("-------------------");
		
		Entiers b = new Entiers(6);
		System.out.println("Liste vide : \n"+b.toString());
		b.inserer(1);
		b.inserer(2);
		b.inserer(3);
		System.out.println("La liste : \n"+b.toString());
		
		b.supprimer(4);
		System.out.println("La liste apr�s suppression de 4: \n" + b.toString());
		
		b.supprimer(2);
		System.out.println("La liste apr�s suppression de 2: \n" + b.toString());
		
		b.inserer(7);
		b.inserer(4);
		System.out.println("La liste apr�s insertion de 7 puis 4: \n"+b.toString());
		
		b.inserer(4);
		System.out.println("La liste apr�s insertion de 4 : \n"+b.toString());
		
		
		/**
		 * Tests Exercice 3
		 */
		System.out.println("\n-------------------");
		System.out.println("Tests Exercice 3 ");
		System.out.println("-------------------");
		
		Liste c = new Liste(6);
		
		c.inserer(3);
		c.inserer(4);
		c.inserer(3);
		System.out.println("Insertion de 3, 4 et 3 :");
		System.out.println(c.toString());
		
		c.supprimer(4);
		System.out.println("Suppression de 4 :");
		System.out.println(c.toString());
		
		c.supprimer(6);
		System.out.println("Suppression de 6 :");
		System.out.println(c.toString());
		
		c.inserer(7);
		c.inserer(4);
		c.inserer(37);
		c.inserer(18);
		c.inserer(15);
		System.out.println("Insertion de 7, 4, 37, 18 et 15 :");
		System.out.println(c.toString());
		
		c.inserer(19);
		System.out.println("Insertion de 19 : (normalement pas de changement)");
		System.out.println(c.toString());

		
	}

}
