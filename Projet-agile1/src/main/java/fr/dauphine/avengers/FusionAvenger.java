package fr.dauphine.avengers;

import java.util.ArrayList;
import java.util.List;

public class FusionAvenger extends Avenger{



private List<Avenger> listeAvenger;
/**
 * Class model for fusionAvenger
 * @param name
 * @param avengers
 */
public FusionAvenger(String name,Avenger...avengers ) {
	this.name=name;
	listeAvenger = new ArrayList<Avenger>();
	for(Avenger avenger: avengers ) {
		this.listeAvenger.add(avenger);
	}
}

@Override
public int getPower() {
	int sum=0;
	for(Avenger avenger : listeAvenger) {
		if (avenger instanceof FusionAvenger) {
			//to delete 
			sum=sum+avenger.getPower();
		}
		else {
			sum=sum+avenger.getPower();
		}
	}
	return sum;
}

	public List<SuperPower> getAllSuperPowerFusion() {
		ArrayList<SuperPower> allTheSuperPower = new ArrayList<SuperPower>();
		for(int i = 0 ; i < listeAvenger.size(); i++) {
			for(int j= 0; j<listeAvenger.get(i).getAllSuperPower().size();j++){
				allTheSuperPower.add(listeAvenger.get(i).getAllSuperPower().get(j));
			}
		}
		return allTheSuperPower;
	}
}
