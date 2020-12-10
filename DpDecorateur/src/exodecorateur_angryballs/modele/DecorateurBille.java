package exodecorateur_angryballs.modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public abstract class DecorateurBille implements Bille {

	public Bille billeDecoree;

	public DecorateurBille(Bille billeDecoree) 
	{
		this.billeDecoree = billeDecoree;
	}

	@Override
	public int getClef()
	{
		return this.billeDecoree.getClef();
	}

	@Override
	public double getRayon()
	{
		return this.billeDecoree.getRayon();
	}

	@Override
	public Color getCouleur()
	{
		return this.billeDecoree.getCouleur();
	}

	@Override
	public Vecteur getVitesse() 
	{
		return this.billeDecoree.getVitesse();
	}

	@Override
	public Vecteur getAcceleration() 
	{
		return this.billeDecoree.getAcceleration();
	}

	@Override
	public double masse() {
		return this.billeDecoree.masse();
	}

	@Override
	public Vecteur getPosition()
	{
		return this.billeDecoree.getPosition();
	}

	@Override
	public void deplacer(double deltaT) 
	{
		this.billeDecoree.deplacer(deltaT);
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) 
	{
		this.billeDecoree.gestionAccélération(billes);
	}

	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) 
	{
		return this.billeDecoree.gestionCollisionBilleBille(billes);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur)
	{
		billeDecoree.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}

	@Override
	public String toString()
	{
		return this.billeDecoree.toString();
	}

	public void dessine (Graphics g)//PEUT MIEUX FAIRE
	{
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
}
