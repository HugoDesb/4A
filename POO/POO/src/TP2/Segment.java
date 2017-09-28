package TP2;

public class Segment extends Forme{
	private Point p1,p2;

	public Segment(Point p1, Point p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void dessiner(PileTransformations pt){
		System.out.println("Segment de p1: "+p1.add(pt.getCurrentTransformation())+
				" à p2: "+p2.add(pt.getCurrentTransformation())+"\n");
	}
	
	public void deplacer(Point p){
		p1.add(p);
		p2.add(p);
	}
	
	
}
