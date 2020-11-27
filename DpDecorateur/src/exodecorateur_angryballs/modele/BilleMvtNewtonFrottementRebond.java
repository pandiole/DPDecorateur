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
	 
	public void gestionAcc�l�ration(Vector<Bille> billes)
	{
		super.gestionAcc�l�ration(billes);   // remise � z�ro du vecteur acc�l�ration
		this.getAcceleration().ajoute(OutilsBille.gestionAcc�l�rationNewton(this, billes));     // contribution de l'acc�l�ration due � l'attraction des autres billes
		this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse()));      // contribution de l'acc�l�ration due au frottement dans l'air
	}


	
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur)
	{
		Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}

}
