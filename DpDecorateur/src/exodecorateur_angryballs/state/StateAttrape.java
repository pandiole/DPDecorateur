package exodecorateur_angryballs.state;

import java.awt.event.MouseEvent;

public class StateAttrape extends StateBille{

	public StateAttrape(StateBille next, State s) {
		super(next, s);

	}
	
	@Override
	void pressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	//LORSQU'ON TIRE LA BILLE
	public void dragged(MouseEvent arg0) {
		System.out.println("Bille tiree");
		this.next.billePilotee.setForceLancer();

	}
	
	//LORSQU'ON LACHE LA BILLE
	public void released() {
	}

}