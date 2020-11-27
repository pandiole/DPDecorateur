package outilsvues;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Vector;

import mesmaths.geometrie.base.TransformationAffine;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.geometrie.base.awt.VecteurAWT;



public class MonGraphics 
{
protected Graphics2D g;



/**
 * @return the g
 */
public Graphics getG()
{
return g;
}
/**
 * @param g
 */
public MonGraphics(Graphics g)
{
this.g = (Graphics2D)g;
}
public  void drawLine(Vecteur A, Vecteur B)
{
this.g.drawLine((int)A.x,(int)A.y,(int)B.x,(int)B.y);
}

public void fillPolygon(Vecteur [] t)
{
this.g.fillPolygon(VecteurAWT.toPolygon(t));
}

public  void drawString(String str, Point A)
{
this.g.drawString(str, A.x + 5, A.y + 10);
}


public  void drawString(String str, Point A, int r)
{
this.g.drawString(str, A.x + r+2, A.y + r+2);
}

public void traceCourbe(Vector<Point> l)
{
int i;
for (i = 0; i < l.size(); ++i)    
    tracePoint(l.get(i),2);
}

public void tracePoint( Point p, int r)
{
int r2 = r*2;
this.g.fillOval(p.x-r,p.y-r, r2, r2);
}


public  void traceVecteur( Vecteur v, int r)
{
tracePoint(new VecteurAWT(v).toPoint(),r);
}

public void traceRep�re( Point o, Point a, Point b, Point c, Point d)
{
this.g.drawLine(a.x, a.y, c.x, c.y);
this.g.drawLine(b.x, b.y, d.x, d.y);
tracePoint(a,2);
tracePoint(b,2);
tracePoint(c,2);
tracePoint(d,2);

drawString("(0,0)", o);
drawString("(1,0)", a);
drawString("(0,1)", b);
drawString("(-1,0)", c);
drawString("(0,-1)", d);


}
/**
 * dessine un point a accompagn� du libell� 'libell�'.
 * 
 * @param a : les coordonn�es de a dans le monde
 * @param t_1 : changement de rep�re monde ---> �cran. C'est � dire que quand on l'applique, 
 * on transforme des coordonn�es monde en coordonn�es �cran
 * @param libell� : message accopagnant le point dessin�
 * @param r : rayon du point trac�
 * @param couleur : couleur du point et du message
 * 
 * */
public void tracePoint(TransformationAffine t_1, Vecteur a, String libell�, int r,
        Color couleur)
{
Vecteur a1 = t_1.applique(a);
Point pa = new VecteurAWT(a1).toPoint();
Color couleurAvant = this.g.getColor();
this.g.setColor(couleur);
this.tracePoint(pa, r);
this.drawString(libell�, pa, r);
this.g.setColor(couleurAvant);
}

/**
 * trace le segment [A,B].
 * 
 * @param A : les coordonn�es de A dans le monde
 * @param B : les coordonn�es de B dans le monde
 * @param t_1 : changement de rep�re monde ---> �cran. C'est � dire que quand on l'applique, 
 * on transforme des coordonn�es monde en coordonn�es �cran
 * @param couleur : couleur du segment trac�
 * 
 * */
public void drawLine(TransformationAffine t_1, Vecteur A,
        Vecteur B, Color couleur)
{
Color couleurAvant = this.g.getColor();
this.g.setColor(couleur);
this.drawLine(t_1.applique(A), t_1.applique(B));
this.g.setColor(couleurAvant);
}


/**
 * trace la ligne bris�e ligne.
 * 
 * @param ligne : les points de la ligne. Leurs coordonn�es sont dans le monde
 * @param t_1 : changement de rep�re monde ---> �cran. C'est � dire que quand on l'applique, 
 * on transforme des coordonn�es monde en coordonn�es �cran
 * @param couleur : couleur du trac�
 * 
 * */
public void traceCourbe(TransformationAffine t_1, Vector<Vecteur> ligne,
        Color couleur)
{
Color couleurAvant = this.g.getColor();
this.g.setColor(couleur);

int i;

Vecteur ancienPoint = t_1.applique(ligne.get(0));
for ( i = 1; i < ligne.size(); ++i)
    {
    Vecteur nouveauPoint = t_1.applique(ligne.get(i));
    this.drawLine(ancienPoint, nouveauPoint);
    ancienPoint = nouveauPoint;
    }

this.g.setColor(couleurAvant);
}

/**
 * trace la ligne bris�e ligne.
 * 
 * @param ligne : les points de la ligne. Leurs coordonn�es sont dans le monde
 * @param t_1 : changement de rep�re monde ---> �cran. C'est � dire que quand on l'applique, 
 * on transforme des coordonn�es monde en coordonn�es �cran
 * @param couleur : couleur du trac�
 * @param �paisseurTrac� : �paisseur du trac�
 * 
 * */
public void traceCourbe(TransformationAffine t_1, Vector<Vecteur> ligne,
        Color couleur, int �paisseurTrac�)
{
Stroke ancienStroke = this.g.getStroke();
this.g.setStroke(new BasicStroke(�paisseurTrac�));
this.traceCourbe(t_1, ligne, couleur);
this.g.setStroke(ancienStroke);
}


/**
 * @return
 * @see java.awt.Graphics#getColor()
 */
public Color getColor()
{
return this.g.getColor();
}
/**
 * @param arg0
 * @see java.awt.Graphics#setColor(java.awt.Color)
 */
public void setColor(Color arg0)
{
this.g.setColor(arg0);
}
/**
 * @param p
 * @see java.awt.Graphics#drawPolygon(java.awt.Polygon)
 */
public void drawPolygon(Polygon p)
{
this.g.drawPolygon(p);
}
/**
 * @param p
 * @see java.awt.Graphics#fillPolygon(java.awt.Polygon)
 */
public void fillPolygon(Polygon p)
{
this.g.fillPolygon(p);
}





}

