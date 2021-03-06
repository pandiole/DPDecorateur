package exodecorateur_angryballs.state;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.vues.Billard;

/**
 * State : PERMET DE DONNER LES ACTIONS EN FONCTION DE CE QUI EST FAIT AVEC LA SOURIS
 * */

public class State implements MouseMotionListener, MouseListener{
	

	StateBille sBille;
	StateAttrape sAttrape;
	StateLache sLache;
	
	Vector<Bille> billes;
	Billard billard;
	
	
	public State(Vector<Bille> billes, Billard billard) {
		this.billes = billes;
		this.billard = billard;
		
		this.billard.addMouseListener(this);
		this.billard.addMouseMotionListener(this);
		
		this.initState();
	}
	
	/**
	 * INITIALISATION
	 * PAR DEFAUT : StateLache
	 * LE PROCHAIN ETAT EST DONC StateAttrape
	 * 
	 * */
	
	private void initState() {
		this.sLache = new StateLache(null, this);
		this.sAttrape = new StateAttrape(this.sLache, this);
		
		this.sLache.next = this.sAttrape;
		
		this.sBille = this.sLache;
	}	
	
	public StateBille getsBille() {
		return sBille;
	}

	public void setsBille(StateBille sBille) {
		this.sBille = sBille;
	}

	/**
	 * ACTION LORSQUE LA BILLE EST TIREE
	 * */
	@Override
	public void mouseDragged(MouseEvent mEvent) {		
		System.err.println("Bille tir�e");
		this.sBille.dragged(mEvent);
	}
	
	/**
	 * ACTION LORSQUE LE BOUTON DE LA SOURIS EST PRESSE
	 * */
	@Override
	public void mousePressed(MouseEvent mEvent) {
		System.err.println("Bille attrap�e");
		this.sBille.pressed(mEvent);
	}

	/**
	 * ACTION LORSQUE LE BOUTON DE LA SOURIS EST RELACHE
	 * */
	@Override
	public void mouseReleased(MouseEvent mEvent) {
		System.err.println("Bille lachee");
		this.sBille.released();
	}

	
	@Override
	public void mouseMoved(MouseEvent mEvent) {
		System.err.println("Bille bouge");
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
