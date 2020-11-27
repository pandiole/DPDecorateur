package exodecorateur_angryballs.modele.comportement;

import java.util.Vector;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.DecorateurBille;
import mesmaths.mecanique.MecaniquePoint;

public class Frottement extends DecorateurBille {

	public Frottement(Bille billeDecoree) {
		super(billeDecoree);
	}

	public void gestionAccélération(Vector<Bille> billes)
	{
		super.gestionAccélération(billes);   // remise à zéro du vecteur accélération
		this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse()));      // contribution de l'accélération due au frottement dans l'air
	}
}
