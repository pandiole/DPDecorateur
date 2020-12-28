package exodecorateur_angryballs.modele.comportement;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.DecorateurBille;
import mesmaths.cinematique.Collisions;

/**
 * represente le comportement de la bille quand celle-ci rebondit sur les bords
 */
public class Rebond extends DecorateurBille{

	public Rebond(Bille billeDecoree) {
		super(billeDecoree);
	}
	
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur)
	{
		Collisions.collisionBilleContourAvecRebond( this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}
}