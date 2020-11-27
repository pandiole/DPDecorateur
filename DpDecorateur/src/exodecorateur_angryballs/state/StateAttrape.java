package exodecorateur_angryballs.state;

import exodecorateur_angryballs.modele.Bille;

public class StateAttrape implements StateBille{

	public StateAttrape(Bille bille) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(Bille context) {
		System.out.println("bille attrapée");
		context.setState(this);
		//SI CLIC DE LA SOURIS ALORS BILLE ARRETE DE BOUGER
		//ELLE VA BOUGER AVEC LA SOURIS
		
	}
	

	
	
	//GERER LE MOUVEMENT DE LA SOURIS
//	private Long temps;	
//    @Override
//    public void onMove(Vecteur offset) {
//        if(temps != null) {
//            double diff = System.currentTimeMillis() - temps;
//            if(diff <= 0) {
//                return;
//            }
//            Vecteur vitesse = parent.getVitesse().somme(offset.produit(10000.0/(diff*parent.masse())));
//            parent.setVitesse(vitesse);
//        }
//
//        temps = System.currentTimeMillis();
//    }
}
