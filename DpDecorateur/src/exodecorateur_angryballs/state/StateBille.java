package exodecorateur_angryballs.state;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.modele.comportement.Pilotee;


public abstract class StateBille{
	
	protected StateBille next;
	protected Pilotee billePilotee;
	
	protected State state;
	
	public StateBille(StateBille next, State s) {
		this.next = next;
		this.state = s;
	}

	public void pressed(MouseEvent arg0) {}
	public void dragged(MouseEvent arg0) {}
	
	public void released() {}
	
	  
}
