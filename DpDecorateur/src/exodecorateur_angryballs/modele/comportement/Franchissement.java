package exodecorateur_angryballs.modele.comportement;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.DecorateurBille;
import mesmaths.cinematique.Collisions;

/**
 * represente le comportement de la bille quand celle-ci franchis les parois
 * et r�apparait sur le cot� oppos�
 */
public class Franchissement extends DecorateurBille{

	public Franchissement(Bille billeDecoree) {
		super(billeDecoree);
	}
	
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur)
	{
		Collisions.collisionBilleContourPasseMuraille( this.getPosition(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}

}