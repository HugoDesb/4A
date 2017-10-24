package TP3;

import java.util.HashSet;

import TP2.Point;

public class HashPoint {
	
	public static void main(String[] args) {
		MonHashSet<Point> hop = new MonHashSet<>();
		hop.add(new Point(0,0));hop.add(new Point(0,1));hop.add(new Point(1,0));
		hop.add(new Point(-1,6));hop.add(new Point(-1,-5));hop.add(new Point(7,5));
		hop.add(new Point(-3,0));hop.add(new Point(3,2));hop.add(new Point(3,2));
		
		System.out.println("{");
		for(Point p : hop){
			System.out.println("\t"+p);
		}
		System.out.println("}");
		
		
		MonHashSet<Point> hep = hop.sousEnsembleAleatoire(4);
		
		System.out.println("modified : {");
		for(Point p : hep){
			System.out.println("\t"+p);
		}
		System.out.println("}");
		
	}
	
	
}
