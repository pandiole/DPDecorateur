package exodecorateur_angryballs.modele.comportement;

import java.util.Vector;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.DecorateurBille;
import mesmaths.geometrie.base.Vecteur;

public class Pesanteur extends DecorateurBille {
	
	protected Vecteur pesanteur;
	
	public Pesanteur(Bille billeDecoree, Vecteur pesanteur) 
	{
		super(billeDecoree);
		this.pesanteur = pesanteur;
	}
	
	public void gestionAcc�l�ration(Vector<Bille> billes)
	{
		super.gestionAcc�l�ration(billes);          // remise � z�ro du vecteur acc�l�ration
		this.getAcceleration().ajoute(this.pesanteur);          // contribution du champ de pesanteur (par exemple)
	}




	
	

}
