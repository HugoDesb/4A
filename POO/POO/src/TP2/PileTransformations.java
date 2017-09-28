package TP2;

import java.util.Stack;

public class PileTransformations {
	private Stack<Point> pile;

	public PileTransformations() {
		this.pile = new Stack<Point>();
	}
	
	public Point getCurrentTransformation(){
		if(pile.empty()){
			return new Point(0,0);
		}
		return pile.peek();
	}
	
	public void empiler(Point p){
		pile.push(p.add(getCurrentTransformation()));
	}
	
	public void depiler(){
		if(!pile.empty()){
			pile.pop();
		}
	}
}
