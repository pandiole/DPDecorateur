package exodecorateur_angryballs.modele;

import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.mecanique.MecaniquePoint;

/**
 * 
 * Bille rebondissant sur les bords, subissant le frottement dans l'air et subissant l'attraction des autres billes
 * 
 * 
 *  A MODIFIER
 *  
 *  */
public class BilleMvtNewtonFrottementRebond extends DecorateurBille
{
	
	public BilleMvtNewtonFrottementRebond(Bille billeDecoree) 
	{
		super(billeDecoree);
	}
	 
	public void gestionAccélération(Vector<Bille> billes)
	{
		super.gestionAccélération(billes);   // remise à zéro du vecteur accélération
		this.getAcceleration().ajoute(OutilsBille.gestionAccélérationNewton(this, billes));     // contribution de l'accélération due à l'attraction des autres billes
		this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse()));      // contribution de l'accélération due au frottement dans l'air
	}


	
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur)
	{
		Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}

}
