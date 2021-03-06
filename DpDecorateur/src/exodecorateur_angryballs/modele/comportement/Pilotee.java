package exodecorateur_angryballs.modele.comportement;

import java.util.Vector;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.DecorateurBille;
import exodecorateur_angryballs.state.StateBille;
import mesmaths.geometrie.base.Vecteur;
/**
 * CLASS PILOTEE : LORSQUE L'UTILISATEUR BOUGE LA BILLE AVEC LA SOURIS
 * */
public class Pilotee extends DecorateurBille{

	Vecteur forceLancer;

	public Pilotee(Bille bille) {
		super(bille);
		this.forceLancer = Vecteur.VECTEURNUL;
	}

	/**
	 * GERE L'ACCELERATION EN FONCTION DE LA FORCE DU LANCER ET DU POIDS DE LA BILLE
	 * */
	public void gestionAccélération(Vector<Bille> billes)
	{
		super.gestionAccélération(billes); 
		this.getAcceleration().ajoute(this.forceLancer);
	}

	public Vecteur getForceLancer() {
		return forceLancer;
	}

	public void setForceLancer(Vecteur forceLancer) {
		this.forceLancer = forceLancer;
	}


	
}
