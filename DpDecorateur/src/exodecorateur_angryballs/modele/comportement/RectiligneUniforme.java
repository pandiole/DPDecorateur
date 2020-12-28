package exodecorateur_angryballs.modele.comportement;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.DecorateurBille;

/**
 * represente le comportement de la bille quand celle-ci n'a aucune acceleration
 * c'est a dire qu'elle bouge en ligne droite avec une vitesse constante
 */
public class RectiligneUniforme extends DecorateurBille {

	public RectiligneUniforme(Bille billeDecoree) {
		super(billeDecoree);
	}

}