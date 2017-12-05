package TP5;

public class OpAddPlus extends OpAdd{

	@Override
	double evaluer() {
		// TODO Auto-generated method stub
		return gauche.evaluer() + droite.evaluer();
	}
}
