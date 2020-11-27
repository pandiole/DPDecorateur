package exodecorateur_angryballs.modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import exodecorateur_angryballs.state.StateBille;
import mesmaths.cinematique.Cinematique;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

public class BilleNue implements Bille {
	
	protected  Vecteur position;  // centre de la bille
	protected  double rayon;  // rayon > 0
	protected  Vecteur vitesse;
	protected  Vecteur acceleration;
	protected int clef;   // identifiant unique de cette bille

	protected Color couleur;

	protected static int prochaineClef = 0;

	protected static double ro = 1;  // masse volumique
	
	/**
	 * @param centre
	 * @param rayon
	 * @param vitesse
	 * @param accélération
	 * @param couleur
	 */
	private BilleNue(Vecteur centre, double rayon, Vecteur vitesse, Vecteur acceleration, Color couleur)
	{
		this.position = centre;
		this.rayon = rayon;
		this.vitesse = vitesse;
		this.acceleration = acceleration;
		this.couleur = couleur;
		this.clef = BilleNue.prochaineClef ++;
	}
	
	/**
	 * @param position
	 * @param rayon
	 * @param vitesse
	 * @param couleur
	 */
	public BilleNue(Vecteur position, double rayon, Vecteur vitesse, Color couleur)
	{
		this(position,rayon,vitesse,new Vecteur(),couleur);
	}
	
	@Override
    public Vecteur getPosition() 
	{
        return this.position;
    }
	
	@Override
    public double getRayon() 
	{
        return this.rayon;
    }
	
	@Override
    public Vecteur getVitesse() 
	{
        return this.vitesse;
    }
	
	@Override
    public Vecteur getAcceleration() 
	{
        return this.acceleration;
    }
	
	@Override
	public Color getCouleur()
	{
		 return this.couleur;
	}
	
	@Override
    public int getClef()
	{
        return this.clef;
    }

	@Override
	public double masse() 
	{
		return ro*Geop.volumeSphère(rayon);
	}
	
	@Override
	public void deplacer(double deltaT)
	{
		Cinematique.mouvementUniformémentAccéléré( this.getPosition(), this.getVitesse(), this.getAcceleration(), deltaT);
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes)
	{
		this.getAcceleration().set(Vecteur.VECTEURNUL);
	}
	
	//PEUT ETRE TRUC A RAJOUTER
	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes)
	{
		return OutilsBille.gestionCollisionBilleBille(this, billes);
	}
	
	@Override
    public String toString() 
	{
        return "centre = " + this.getPosition() + " rayon = " + this.getRayon() + " vitesse = " + this.getVitesse() + " accélération = " + this.getAcceleration() +  "clef = "
                + this.getClef();
    }

	
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur,
			double hauteur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dessine(Graphics g) {
		 int width, height;
		  int xMin, yMin;
		  
		  xMin = (int)Math.round(this.getPosition().x-this.getRayon());
		  yMin = (int)Math.round(this.getPosition().y-this.getRayon());
		
		  width = height = 2*(int)Math.round(this.getRayon()); 
		
		  g.setColor(this.getCouleur());
		  g.fillOval( xMin, yMin, width, height);
		  g.setColor(Color.CYAN);
		  g.drawOval(xMin, yMin, width, height);
		
	}

	@Override
	public void setState(StateBille bille) {
		// TODO Auto-generated method stub
		
	}
}