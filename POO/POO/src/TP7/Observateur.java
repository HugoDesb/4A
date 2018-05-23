package TP7;

import java.util.Observable;
import java.util.Observer;

import TP2.Point;

public class Observateur implements Observer {

	Point mp;
	
	@Override
	public void update(Observable o, Object arg) {
		PointCritique p = (PointCritique)o;
		
		if((int)arg==0){
			mp.setX(p.getX());
		}else{
			mp.setY(p.getY());
		}
		System.out.println("I'm notified");
		// TODO Auto-generated method stub
		
	}

}
