package exodecorateur_angryballs.modele.comportement;

import java.util.Vector;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.DecorateurBille;
import mesmaths.geometrie.base.Vecteur;

/**
 * represente le comportement de la bille quand celle-ci est attirée vers le bas
 * ceci est dû à la pesanteur
 */
public class Pesanteur extends DecorateurBille {
	
	protected Vecteur pesanteur;
	
	public Pesanteur(Bille billeDecoree, Vecteur pesanteur) 
	{
		super(billeDecoree);
		this.pesanteur = pesanteur;
	}
	
	public void gestionAccélération(Vector<Bille> billes)
	{
		super.gestionAccélération(billes);  // remise à zéro du vecteur accélération
		this.getAcceleration().ajoute(this.pesanteur);          
	}

}
