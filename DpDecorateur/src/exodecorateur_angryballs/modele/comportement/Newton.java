package exodecorateur_angryballs.modele.comportement;

import java.util.Vector;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.DecorateurBille;
import exodecorateur_angryballs.modele.OutilsBille;

public class Newton extends DecorateurBille {

	public Newton(Bille billeDecoree) 
	{
		super(billeDecoree);
	}
	
	public void gestionAccélération(Vector<Bille> billes)
	{
		super.gestionAccélération(billes);   // remise à zéro du vecteur accélération
		this.getAcceleration().ajoute(OutilsBille.gestionAccélérationNewton(this, billes));     // contribution de l'accélération due à l'attraction des autres billes
	}

}
