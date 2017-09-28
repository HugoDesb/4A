package TP2;

public class Cercle extends Forme{
	private Point centre;
	private Segment rayon;
	
	
	public Cercle(Point centre, Segment rayon) {
		super();
		this.centre = centre;
		this.rayon = rayon;
	}
	
	public void dessiner(PileTransformations pt){
		System.out.println("Cercle de centre "+centre.add(pt.getCurrentTransformation()));
		System.out.println("et de rayon : \t");
		rayon.dessiner(pt);
	}
	
	public void deplacer(Point p){
		centre.add(p);
		rayon.deplacer(p);
	}
	
	
}
