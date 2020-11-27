package exodecorateur_angryballs.modele;

import mesmaths.cinematique.Collisions;

/**
 * 
 * Bille rebondissant sur les murs et subissant un mouvement rectiligne uniforme (mouvment en ligne droite � vitesse constante)
 * 
 * 
 *  A MODIFIER
 *  
 *  */
public class BilleMvtRURebond extends DecorateurBille
{

	public BilleMvtRURebond(Bille billeDecoree) 
	{
		super(billeDecoree);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur)
	{
		Collisions.collisionBilleContourAvecRebond( this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}

}


