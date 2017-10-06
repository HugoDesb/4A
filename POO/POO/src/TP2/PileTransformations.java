package TP2;

public class PileTransformations {
	private Point[] pile;
	private int nbMax;
	private int nbTransformations;

	public PileTransformations(int nbMax) {
		this.pile = new Point[nbMax];
		this.nbMax = nbMax;
		nbTransformations = 0;
	}
	
	public Point getCurrentTransformation(){
		if(nbTransformations==0){
			return new Point(0,0);
		}
		return pile[nbTransformations-1];
	}
	
	public void empiler(Point p){
		if(nbTransformations==0){
			pile[nbTransformations] = p;
			nbTransformations++;
		}else if(nbMax > nbTransformations){
			pile[nbTransformations] = pile[nbTransformations-1].add(p);
			nbTransformations++;
			
		}
	}
	
	public void depiler(){
		if(nbTransformations>0){
			nbTransformations--;
		}
	}
}
