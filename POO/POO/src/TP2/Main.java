package TP2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import TP1.Entiers;
import TP1.Liste;

public class Main {

	public static void main(String[] args) {
		Point p1, p2, p3, pDeplacer1, pDeplacer2;
		Segment s1,s2;
		Cercle c1,c2;
		Image ima1, ima2, ima3;
		PileTransformations pt;
		
		
		
		System.out.println("Exercice 1 ------------------------------------------");
		
		p1 = new Point(1,3);
		p2 = new Point(4,5);
		System.out.println("Les deux points : ");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("Leur somme : ");
		System.out.println(p1.add(p2));
		
		
		
		System.out.println("\nExercice 2 & 3 --------------------------------------");
		
		s1 = new Segment(p1, p2);
		c1 = new Cercle(p2, 4);
		pt = new PileTransformations(10);
		c1.dessiner(pt);
		pt.empiler(new Point(1,1));
		c1.dessiner(pt);

		
		
		System.out.println("\nExercice 4 ------------------------------------------");
		p3 = new Point(-1,-2);
		s2 = new Segment(p2, p3);
		ima1 = new Image(3);
		ima1.ajouter(s1);
		ima1.ajouter(s2);
		ima1.ajouter(c1);
		System.out.println("Image 1 - origin (0,0)-------------\n");
		ima1.dessiner(pt);
		
		
		ima2 = new Image(3,new Point(-1,-1));
		ima2.ajouter(s1);
		ima2.ajouter(s2);
		ima2.ajouter(c1);
		System.out.println("Image 2 - origin (-1,-1)-------------\n");
		ima2.dessiner(pt);
		ima2.deplacer(new Point(1,1));
		System.out.println("Image 2 - origin (-1,-1) - deplacer (1,1)-------------\n");
		ima2.dessiner(pt);
		
		
		
		System.out.println("\nExercice 5 ------------------------------------------");
		s1 = new Segment(new Point(1,1), new Point(-1,1));
		c1 = new Cercle(new Point(0,0),4);
		p1 = new Point(-5,4);
		pt = new PileTransformations(10);
		
		pt.empiler(p1);
		c1.dessiner(pt);
		s1.dessiner(pt);
		pDeplacer1 = new Point(3,3);
		c1.deplacer(pDeplacer1);
		s1.deplacer(pDeplacer1);
		ima1 = new Image(10);
		ima1.ajouter(c1);
		ima1.ajouter(s1);
		ima1.dessiner(pt);
		pDeplacer2 = new Point(-3,-3);
		ima1.deplacer(pDeplacer2);
		ima1.dessiner(pt);
		pt.depiler();
		
		
		
		System.out.println("\nExercice 6 ------------------------------------------");
		s1 = new Segment(new Point(1,1), new Point(-1,1));
		s2 = new Segment(new Point(1,1), new Point(1,-2));
		c1 = new Cercle(new Point(0,0),4);
		c2 = new Cercle(new Point(1,1),4);
		p1 = new Point(-5,4);
		ima1 = new Image(10);
		ima2 = new Image(10);
		ima3 = new Image(10);
		pt = new PileTransformations(10);
		
		pt.empiler(p1);
		ima1.ajouter(s1);ima1.ajouter(c1);
		ima2.ajouter(s2);ima2.ajouter(c2);
		ima1.dessiner(pt);
		ima2.dessiner(pt);
		pDeplacer1 = new Point(3,3);
		ima1.deplacer(pDeplacer1);
		ima3.ajouter(ima1);
		ima3.ajouter(ima2);
		ima3.dessiner(pt);
		pt.depiler();
		
		
		System.out.println("\nExercice 8 ------------------------------------------");		
		Structure [] s = new Structure[2];
		s[0] = new Entiers(5);
		s[1] = new Liste(5);
		for(int i = 0; i<10;i++){
			s[i%2].inserer(i);
		}
		System.out.println("Structure de taille "+2);
		System.out.println("["+s[0].toString()+" , "+s[1].toString()+"]");
		for(int i = 0; i<10;i++){
			if(i%2==1){
				s[i%2].supprimer(i);
			}
		}
		System.out.println("RE : Structure de taille "+2);
		System.out.println("["+s[0].toString()+" , "+s[1].toString()+"]");
		
		
		
		System.out.println("\nExercice 9 ------------------------------------------");		
		for(int i = 0; i<10;i++){
			s[i%2].inserer(i);
		}
		System.out.println("RE : Structure de taille "+2);
		s[0].afficher();
		s[1].afficher();
		
		System.out.println("ET FORME ...");
		Forme [] f = new Forme[4];
		f[0] = s1;
		f[1] = s2;
		f[2] = c1;
		f[3] = c2;
		for(int i = 0; i<4; i++){
			f[i].afficher();
		}
		
		System.out.println("\nExercice 10 ------------------------------------------");		
		Compactable [] cc = new Compactable[2];
		cc[0] = s[0];
		cc[1] = ima2;
		cc[0].compacter(2);
		cc[1].compacter(2);
		
		System.out.println("\nExercice 11 ------------------------------------------");
		Image [] images = new Image[3];
		images[0] = ima1;
		images[1] = ima2;
		images[2] = ima3;
		for(int i = 0;i<3;i++){
			images[i].afficher();
		}
		Arrays.sort(images);
		for(int i = 0;i<3;i++){
			images[i].afficher();
		}
		
		System.out.println("\nExercice 12 ------------------------------------------");
		ArrayList<Image> imagesList = new ArrayList<>();
		imagesList.add(ima1);
		imagesList.add(ima2);
		imagesList.add(ima3);
		Image imageMax = Collections.max(imagesList);
		imageMax.afficher();
		
		System.out.println("\nExercice 13 ------------------------------------------");
		System.out.println("test segment");
		s1.afficher();
		Segment sClone = s1.clone();
		sClone.afficher();
		
		Liste ll = new Liste(10);
		for(int i = 0; i<10;i++){
			ll.inserer(i);
		}
		ll.afficher();
		Liste lClone = ll.clone();
		lClone.afficher();
		
		
		System.out.println("\nExercice 14 ------------------------------------------");
		SuiteBits sb = new SuiteBits(128);
		sb.inserer(64);
		//sb.inserer(33);
		//sb.inserer(69);
		sb.afficher();
	}

}
