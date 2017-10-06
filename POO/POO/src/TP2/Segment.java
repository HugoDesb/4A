package TP2;

public class Segment extends Forme implements Cloneable{
	

	private Point p2;

	public Segment(Point p1, Point p2) {
		super(p1);
		this.p2 = p2;
	}
	
	public void dessiner(PileTransformations pt){
		System.out.println("Segment de p1: "+getOriginPoint().add(pt.getCurrentTransformation())+
				" à p2: "+p2.add(pt.getCurrentTransformation())+"\n");
	}
	
	@Override
	public void deplacer(Point p){
		super.deplacer(p);
		p2.add(p);
	}
	
	@Override
	public String toString() {
		return "Segment [p1="+getOriginPoint()+", p2=" + p2 + "]";
	}
	
	@Override
	public Segment clone(){
		Point pp1 = new Point(getOriginPoint().getX(),getOriginPoint().getY());
		Point pp2 = new Point(p2.getX(),p2.getY());
		return new Segment(pp1, pp2);
	}
	
}
