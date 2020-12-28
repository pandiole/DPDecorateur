package exodecorateur_angryballs.state;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.modele.Bille;
import mesmaths.geometrie.base.Vecteur;

public class StateAttrape extends StateBille{

	public StateAttrape(StateBille next, State s) {
		super(next, s);

	}
	/**
	 * LORSQU'ON TIRE LA BILLE
	 * */
	public void dragged(MouseEvent me) {
		System.err.println("Bille tiree");
		//CALCULE LA DIFFERENCE ENTRE LA POSITION DU POINTEUR DE LA SOURIS ET LA POSITION DE LA BILLE
		Vecteur force = new Vecteur(me.getX(), me.getY()).difference(this.next.billePilotee.getPosition());
		force.multiplie(1/this.next.billePilotee.masse());
		//MISE A JOUR DE LA FORCE
		this.next.billePilotee.setForceLancer(force);
	}

	/**
	 * LORSQU'ON LACHE LA BILLE
	 * */
	public void released() {
		Bille billeSuivant = this.next.billePilotee.billeDecoree;
		this.state.billes.remove(this.next.billePilotee);
		this.state.billes.add(billeSuivant);
		
		this.state.setsBille(this.next);		
	}
}