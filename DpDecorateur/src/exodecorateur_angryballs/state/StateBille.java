package exodecorateur_angryballs.state;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.modele.comportement.Pilotee;


public abstract class StateBille{
	
	StateBille next;
	Pilotee billePilotee;
	
	State s;
	
	public StateBille(StateBille next, State s) {
		this.next = next;
		this.s = s;
	}

	abstract void pressed(MouseEvent arg0);
	abstract void dragged(MouseEvent arg0);
	
	abstract void released();
	
	  
}
