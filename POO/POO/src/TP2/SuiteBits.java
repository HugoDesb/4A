package TP2;

public class SuiteBits extends Structure {
	private final int BITSLONG = 64;
	
	private long[] tab;
	private long maxInteger;
	private int nbLong;
	
	public SuiteBits(int maxInteger) {
		maxInteger++;
		if(maxInteger%BITSLONG==0){
			nbLong = maxInteger/BITSLONG;
		}else{
			nbLong = maxInteger/BITSLONG +1;
		}
		tab = new long[nbLong];
		this.maxInteger = maxInteger;
		for (int i = 0; i < tab.length; i++) {
			tab[i] = (long)0;
		}
	}
	
	@Override
	public void afficher() {
		// TODO Auto-generated method stub
		String ret = "{ ";
		long nb;
		for(int i = 0; i < nbLong ; i++){
			if(tab[i]!=0){
				System.out.println("i: "+i +" tab: "+tab[i]);
				for(int j=BITSLONG-1 ; j>=0 ; j--){
					
					long maskJ = 1 << j;
					boolean bitJSetToOne = ((tab[i] & maskJ) == maskJ); 
					if(bitJSetToOne){
						System.out.println("\t j: "+j);
						nb = (i*BITSLONG)+(BITSLONG -j-1);
						ret += " "+nb+" ";
					}
				}
			}
		}
		System.out.println(ret+" }");
		
		/*
		for(int i = 0; i<nbLong ; i++){
			System.out.println(tab[i]);
		}
		*/
	}

	@Override
	public void compacter(int nbElementASupprimer) {
		// TODO Auto-generated method stub
		System.out.println("Not yet implemented");
	}

	@Override
	public void inserer(int nb) {
		if(nb<=maxInteger){
			int index = nb/BITSLONG;
			System.out.println(index);
			int bitNb = BITSLONG - (nb%BITSLONG)-1;
			System.out.println(bitNb);
			long mask = 1 << bitNb;// 0 partout sauf au bit bitNb
			System.out.println(mask);
			tab[index] = tab[index] | mask;
		}
	}

	@Override
	public void supprimer(int nb) {
		if(nb<=maxInteger){
			int index = nb/BITSLONG;
			int bitNb = BITSLONG - (nb%BITSLONG)-1;
			long mask = 1 << bitNb;// 0 partout sauf au bit bitNb
			long ones = 2^(BITSLONG-1);
			mask = mask ^ ones;// on inverse
			tab[index] = tab[index] & mask;
		}
	}

}
