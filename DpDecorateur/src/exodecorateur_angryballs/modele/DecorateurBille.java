package exodecorateur_angryballs.modele;

import java.awt.Color;
import java.util.Vector;

import exo_decorateur_angryballs.modele.dessin.Dessin;
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

	public void dessine (Dessin dessin)
	{
		this.billeDecoree.dessine(dessin);
	}
}
