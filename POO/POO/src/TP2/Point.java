package TP2;

import java.util.Observable;

/**
 * @author d16023863
 *	Classe représentant un Point
 */
public class Point extends Observable{
	
	private int x,y;
	
	/**
	 * Constructeur par défaut
	 */
	public Point(){
		this.x = 0; 
		this.y = 0;
	}
	
	/**
	 * Constructeur
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Ajoute le Point p avec le point de référence.
	 * @param p
	 * @return un nouveau point
	 */
	public Point add(Point p){
		return new Point(this.x+p.getX(),this.y+p.getY());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if(arg0.getClass()==this.getClass()) {
			Point a = (Point)arg0;
			if((a.getX()==this.getX()) && (a.getY()==this.getY())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return getX()+getY();
	}

	
	
	
}
