package TP2;

public class Cercle extends Forme{
	private int rayon;
	
	
	public Cercle(Point centre, int rayon) {
		super(centre);
		this.rayon = rayon;
	}
	
	public void dessiner(PileTransformations pt){
		System.out.println("Cercle de centre "+getOriginPoint().add(pt.getCurrentTransformation()));
		System.out.println("et de rayon : "+rayon+"");
	}
	
	@Override
	public void deplacer(Point p){
		super.deplacer(p);
	}

	@Override
	public String toString() {
		return "Cercle [centre=" + getOriginPoint() + ", rayon=" + rayon + "]";
	}
	
	
	
}
