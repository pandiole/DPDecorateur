package exodecorateur_angryballs.vues;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Vector;

import exo_decorateur_angryballs.modele.dessin.Dessin;
import exo_decorateur_angryballs.modele.dessin.DessinOrdi;
import exodecorateur_angryballs.modele.Bille;


/**
 * responsable du dessin des billes
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 * 
 * */
public class Billard extends Canvas
{
	Vector<Bille> billes;
	public Billard(Vector<Bille> billes)
	{
		this.billes = billes;
	}
	/* (non-Javadoc)
	 * @see java.awt.Canvas#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics graphics)
	{
		int i;
		Dessin dessin = new DessinOrdi(graphics);
		
		for ( i = 0; i < this.billes.size(); ++i)
			this.billes.get(i).dessine(dessin);

		//System.out.println("billes dans le billard = " + billes);
	}



}
