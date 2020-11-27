package exodecorateur_angryballs.modele;

import mesmaths.cinematique.Collisions;

/**
 * 
 * Bille traversant les murs et subissant un mouvement rectiligne uniforme (mouvment en ligne droite � vitesse constante)
 * 
 * 
 *  A MODIFIER
 *  
 *  */

public class BilleMvtRUPasseMurailles extends DecorateurBille
{

	public BilleMvtRUPasseMurailles(Bille billeDecoree) 
	{
		super(billeDecoree);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur)
	{
		Collisions.collisionBilleContourPasseMuraille( this.getPosition(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}

}



