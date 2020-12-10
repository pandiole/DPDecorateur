package exodecorateur_angryballs.state;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.vues.Billard;

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

	@Override
	public void mouseDragged(MouseEvent mEvent) {		
		System.err.println("Bille tirée");
		this.sBille.dragged(mEvent);
	}
	
	@Override
	public void mousePressed(MouseEvent mEvent) {
		System.err.println("Bille attrapée");
		this.sBille.pressed(mEvent);
	}

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
