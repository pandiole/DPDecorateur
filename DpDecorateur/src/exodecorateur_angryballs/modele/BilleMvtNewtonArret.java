package exodecorateur_angryballs.modele;

import java.util.Vector;

import mesmaths.cinematique.Collisions;

/**
 * 
 * Bille s'arr�tant sur les bords et subissant l'attraction des autres billes
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
	 
	 public void gestionAcc�l�ration(Vector<Bille> billes)
	 {
		 super.gestionAcc�l�ration(billes);    // remise � z�ro du vecteur acc�l�ration
		 this.getAcceleration().ajoute(OutilsBille.gestionAcc�l�rationNewton(this, billes));  // contribution de l'acc�l�ration due � l'attraction des autres billes
	 }
	 
	
	 @Override
	 public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur)
	 {
		 Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
		 Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(), ordonn�eCoinHautGauche, hauteur);
	 }

}
