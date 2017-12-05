package TP7;

import TP2.Point;

public class PointCritique extends Point {

	
	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		super.setX(x);
		setChanged();
		notifyObservers(0);
		
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		super.setY(y);
		setChanged();
		notifyObservers(0);
	}

}
