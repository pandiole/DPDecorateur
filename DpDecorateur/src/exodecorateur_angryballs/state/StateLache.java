package exodecorateur_angryballs.state;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.comportement.Pilotee;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

public class StateLache extends StateBille{
	
	public StateLache(StateBille next, State s) {
		super(next, s);
	}

	/**
	 * LORSQU'ON LACHE LA BILLE
	 * */
	@Override
	public void pressed(MouseEvent me) {
		for(Bille b : this.state.billes) {
			if(Geop.appartientDisque(new Vecteur(me.getX(), me.getY()), b.getPosition(), b.getRayon())) {
				this.billePilotee = new Pilotee(b);
				this.state.billes.remove(b);
				this.state.billes.add(this.billePilotee);
				this.state.setsBille(this.next);
				break;
			}
		}		
	}
}
