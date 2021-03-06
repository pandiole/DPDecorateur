package exodecorateur_angryballs.modele.comportement;

import java.util.Vector;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.DecorateurBille;
import exodecorateur_angryballs.modele.OutilsBille;

/**
 * represente le comportement de la bille quand celle-ci est attir�e par les autres billes
 * ceci est d� � la force de Newton
 */
public class Newton extends DecorateurBille {

	public Newton(Bille billeDecoree) 
	{
		super(billeDecoree);
	}
	
	public void gestionAcc�l�ration(Vector<Bille> billes)
	{
		super.gestionAcc�l�ration(billes);   // remise � z�ro du vecteur acc�l�ration
		this.getAcceleration().ajoute(OutilsBille.gestionAcc�l�rationNewton(this, billes));     // contribution de l'acc�l�ration due � l'attraction des autres billes
	}

}