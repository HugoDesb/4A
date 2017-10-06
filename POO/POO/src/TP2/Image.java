package TP2;

import java.util.Comparator;

public class Image extends Forme implements Compactable, Comparable<Image>, Comparator<Image>{
	
	

	private Forme[] formes;
	private int nbFormes;
	private int nbMax;

	public Image(int nbMax) {
		super(new Point(0,0));
		this.nbFormes = 0;
		this.nbMax = nbMax;
		this.formes = new Forme[nbMax];
	}
	
	public Image(int nbMax, Point p) {
		super(p);
		this.nbFormes = 0;
		this.nbMax = nbMax;
		this.formes = new Forme[nbMax];
	}

	public void ajouter(Forme f){
		if(nbFormes<nbMax){
			formes[nbFormes] = f;
			nbFormes++;
		}
	}
	
	@Override
	public void dessiner(PileTransformations pt) {
		pt.empiler(getOriginPoint());
		for(int i = 0; i<nbFormes;i++){
			formes[i].dessiner(pt);
		}
		pt.depiler();
	}

	@Override
	public void compacter(int nbElementASupprimer) {
		nbFormes = nbFormes - nbElementASupprimer;
		if(nbFormes < 0){
			nbFormes=0;
		}	
	}

	@Override
	public int compareTo(Image o) {
		if(nbFormes < o.nbFormes){
			return -1;
		}else if(nbFormes > o.nbFormes){
			return 1;
		}else{
			return 0;
		}
	}

	@Override
	public int compare(Image o1, Image o2) {
		return Integer.compare(o1.getOriginPoint().getY(), o2.getOriginPoint().getY());
	}
	
	@Override
	public String toString() {
		String ret =  "Image [formes= {";
		for(int i = 0; i<nbFormes; i++){
			ret+=formes[i].toString() + " \n\t";
		}
		ret+= "}, nbFormes=" + nbFormes + ", nbMax=" + nbMax + "]";
		return ret;
	}


}
