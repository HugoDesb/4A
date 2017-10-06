package TP2;

public abstract class Forme implements Affichable{

	private Point originPoint;
	
	public Forme(Point originPoint){
		this.originPoint = originPoint;
	}
	
	
	public abstract void dessiner(PileTransformations pt);
	
	public void deplacer(Point p){
		originPoint.add(p);
	}
		
	protected Point getOriginPoint(){
		return originPoint;
	}
	
	public void afficher(){
		System.out.println(toString());
	}
}
