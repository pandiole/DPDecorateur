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
	
	Billard billard;
	
	public State(Vector<Bille> billes, Billard billard) {
		
		this.billard = billard;
		
		this.billard.addMouseListener(this);
		this.billard.addMouseMotionListener(this);
		
		this.sBille = this.sLache;
		
		this.initState();
	}
	
	private void initState() {
		this.sLache = new StateLache(null, this);
		this.sAttrape = new StateAttrape(this.sLache, this);
		
		this.sLache.next = this.sAttrape;
		
		this.sBille = this.sLache;
	}
	
	@Override
	public void mouseDragged(MouseEvent mEvent) {		
		//this.attrape.prendre(arg0);
		this.sBille.dragged(mEvent);
	}
	
	@Override
	public void mousePressed(MouseEvent mEvent) {
		System.out.println("Bille attrapée");
		
	}

	@Override
	public void mouseReleased(MouseEvent mEvent) {
		System.out.println("Bille lachee");
		
	}

	@Override
	public void mouseMoved(MouseEvent mEvent) {
		System.out.println("Bille bouge");
		
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
