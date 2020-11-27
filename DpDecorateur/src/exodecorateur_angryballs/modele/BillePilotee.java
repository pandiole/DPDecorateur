package exodecorateur_angryballs.modele;

import java.util.Vector;

import exodecorateur_angryballs.state.StateAttrape;
import exodecorateur_angryballs.state.StateLache;

public class BillePilotee extends DecorateurBille{



	public BillePilotee(Bille bille) {
		super(bille);
	}

	//LORSQU'ON ATTRAPE LA BILLE
	public void prendre() {
		etatBille = new StateAttrape(billeDecoree);
		billeDecoree.action();
	}

	//LORSQU'ON LACHE LA BILLE
	public void lacher() {
		etatBille = new StateLache(billeDecoree);
	}

}
