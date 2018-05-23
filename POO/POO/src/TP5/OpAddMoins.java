package TP5;

public class OpAddMoins extends OpAdd{

	
	@Override
	double evaluer() {
		// TODO Auto-generated method stub
		return gauche.evaluer() - droite.evaluer();
	}

	
	
}
