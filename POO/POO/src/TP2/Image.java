package TP2;

public class Image extends Forme {
	
	private Point origin;
	private Forme[] formes;
	private int nbFormes;
	private int nbMax;

	public Image(int nbMax) {
		this.nbFormes = 0;
		this.nbMax = nbMax;
		this.formes = new Forme[nbMax];
		this.origin = new Point(0,0);
	}
	
	public Image(int nbMax, Point p) {
		// TODO Auto-generated constructor stub
		this.nbFormes = 0;
		this.nbMax = nbMax;
		this.formes = new Forme[nbMax];
		this.origin = p;
	}

	public void ajouter(Forme f){
		if(nbFormes<nbMax){
			formes[nbFormes] = f;
			nbFormes++;
		}
	}
	
	@Override
	public void dessiner(PileTransformations pt) {
		pt.empiler(origin);
		for(int i = 0; i<nbFormes;i++){
			formes[i].dessiner(pt);
		}
		pt.depiler();

	}

	@Override
	public void deplacer(Point p) {
		// TODO Auto-generated method stub
		origin = origin.add(p);
	}

}
