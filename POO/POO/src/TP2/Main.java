package TP2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Exercice 1 ------------------------------------------");
		
		Point p1 = new Point(1,3);
		Point p2 = new Point(4,5);
		System.out.println("Les deux points : ");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("Leur somme : ");
		System.out.println(p1.add(p2));
		
		
		
		System.out.println("\nExercice 2 & 3 --------------------------------------");
		
		Segment s1 = new Segment(p1, p2);
		Cercle c1 = new Cercle(p2, s1);
		PileTransformations pt = new PileTransformations();
		c1.dessiner(pt);
		pt.empiler(new Point(1,1));
		c1.dessiner(pt);

		System.out.println("\nExercice 4 ------------------------------------------");
		Point p3 = new Point(-1,-2);
		Segment s2 = new Segment(p2, p3);
		Image ima1 = new Image(3);
		ima1.ajouter(s1);
		ima1.ajouter(s2);
		ima1.ajouter(c1);
		System.out.println("Image 1 - origin (0,0)-------------\n");
		ima1.dessiner(pt);
		
		
		Image ima2 = new Image(3,new Point(-1,-1));
		ima2.ajouter(s1);
		ima2.ajouter(s2);
		ima2.ajouter(c1);
		System.out.println("Image 2 - origin (-1,-1)-------------\n");
		ima2.dessiner(pt);
		ima2.deplacer(new Point(1,1));
		System.out.println("Image 2 - origin (-1,-1) - deplacer (1,1)-------------\n");
		ima2.dessiner(pt);
		
		
	}

}
