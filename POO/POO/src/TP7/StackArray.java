package TP7;

import java.util.ArrayList;

public class StackArray<E> extends ArrayList<E> implements StackAdapter<E>{

	@Override
	public void push(E el) {
		// TODO Auto-generated method stub
		add(0, el);
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return get(0);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return remove(0);
	}

	

}
