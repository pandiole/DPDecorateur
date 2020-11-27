package exodecorateur_angryballs.state;

import exodecorateur_angryballs.modele.Bille;

public class StateLache implements StateBille{

	public StateLache(Bille bille) {
	}

	@Override
	public void action(Bille context) {
		System.out.println("bille lachée");
		context.setState(null);
		//SI LACHE LA SOURIS ALORS BILLE REBOUGE NORMALEMENT
	}

}
