package TP3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class MonHashSet<E> extends HashSet<E> {
	
	
	public MonHashSet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonHashSet(Collection<? extends E> c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	public MonHashSet(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
		// TODO Auto-generated constructor stub
	}

	public MonHashSet(int initialCapacity) {
		super(initialCapacity);
		// TODO Auto-generated constructor stub
	}

	public MonHashSet<E> sousEnsembleAleatoire(int n){
		MonHashSet<E> mhs = new MonHashSet<>(this);
		int cardinality = mhs.size();
		Iterator<E> it = mhs.iterator();
		int toSuppress = 0;
		
		if(n<=cardinality){
			toSuppress = cardinality-n;		
		}else{
			System.out.println("WOWOWOWOWOH n est plus gd que la taille du set !!!!");
		}
		
		while(it.hasNext()){
			if(toSuppress>0){
				System.out.println(it.next());
				it.remove();
				toSuppress--;
			}else{
				return mhs;
			}
		}
		return mhs;
	}
}
