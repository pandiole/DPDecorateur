package exodecorateur_angryballs.modele;

import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 * 
 * Bille rebondissant sur les murs, subissant un mouvement rectiligne (mouvement en ligne droite) et subissant le frottement dans l'air
 * 
 * Soumis � un vecteur pesanteur
 * 
 * 
 *  A MODIFIER
 *  
 *  */
public class BilleMvtPesanteurFrottementRebond extends DecorateurBille
{
	private Vecteur pesanteur;
	
	public BilleMvtPesanteurFrottementRebond(Bille billeDecoree, Vecteur pesanteur) 
	{
		super(billeDecoree);
		this.pesanteur = pesanteur;
	}
	
	public void gestionAcc�l�ration(Vector<Bille> billes)
	{
		super.gestionAcc�l�ration(billes);          // remise � z�ro du vecteur acc�l�ration
		this.getAcceleration().ajoute(this.pesanteur);          // contribution du champ de pesanteur (par exemple)
		this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); // contribution de l'acc�l�ration due au frottement dans l'air
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur)
	{
		Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}

}
