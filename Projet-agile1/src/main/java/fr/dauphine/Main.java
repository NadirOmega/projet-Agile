package fr.dauphine;

import fr.dauphine.adapter.VirusToAvenger;
import fr.dauphine.avengers.Avenger;
import fr.dauphine.avengers.FusionAvenger;
import fr.dauphine.avengers.SuperMechant;
import fr.dauphine.virus.Virus;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Virus virus = new Virus(-1,"méchant");
		Virus virus2 = new Virus(2,"Manil");
		Avenger transfoVirus = new VirusToAvenger(virus2);
		Avenger captainAmerica= new Avenger("Captain america",89);
		Avenger fusion = new FusionAvenger("Fusion", transfoVirus,captainAmerica);
		SuperMechant thanos = SuperMechant.getInstance(virus);
		System.out.println("print "+fusion.getPower());
		System.out.println("print "+thanos.getPower());
	}

}
