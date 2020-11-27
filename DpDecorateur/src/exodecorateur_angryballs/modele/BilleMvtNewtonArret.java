package exodecorateur_angryballs.modele;

import java.util.Vector;

import mesmaths.cinematique.Collisions;

/**
 * 
 * Bille s'arrêtant sur les bords et subissant l'attraction des autres billes
 * 
 * 
 *  A MODIFIER
 *  
 *  */

public class BilleMvtNewtonArret extends DecorateurBille
{
	 public BilleMvtNewtonArret(Bille billeDecoree) 
	 {
		 super(billeDecoree);
	 }
	 
	 public void gestionAccélération(Vector<Bille> billes)
	 {
		 super.gestionAccélération(billes);    // remise à zéro du vecteur accélération
		 this.getAcceleration().ajoute(OutilsBille.gestionAccélérationNewton(this, billes));  // contribution de l'accélération due à l'attraction des autres billes
	 }
	 
	
	 @Override
	 public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur)
	 {
		 Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
		 Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(), ordonnéeCoinHautGauche, hauteur);
	 }

}
