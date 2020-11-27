package exodecorateur_angryballs.modele.comportement;

import java.util.Vector;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.DecorateurBille;
import exodecorateur_angryballs.state.StateAttrape;
import exodecorateur_angryballs.state.StateLache;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

public class Pilotee extends DecorateurBille{

	Vecteur forceLancer;

	public Pilotee(Bille bille) {
		super(bille);
	}

	public void gestionAccélération(Vector<Bille> billes)
	{
		this.getAcceleration().ajoute(this.forceLancer);
	}

	public Vecteur getForceLancer() {
		return forceLancer;
	}

	public void setForceLancer(Vecteur forceLancer) {
		this.forceLancer = forceLancer;
	}

	
}
