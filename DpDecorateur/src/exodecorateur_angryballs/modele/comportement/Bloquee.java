package exodecorateur_angryballs.modele.comportement;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.DecorateurBille;
import mesmaths.cinematique.Collisions;

public class Bloquee extends DecorateurBille {

	public Bloquee(Bille billeDecoree) {
		super(billeDecoree);
	}
	
	 @Override
	 public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur)
	 {
		 Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
		 Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(), ordonn�eCoinHautGauche, hauteur);
	 }

}
