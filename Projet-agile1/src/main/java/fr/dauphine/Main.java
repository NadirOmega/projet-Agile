package fr.dauphine;

import fr.dauphine.adapter.VirusToAvengerAdapter;
import fr.dauphine.avengers.Avenger;
import fr.dauphine.avengers.FusionAvenger;
import fr.dauphine.avengers.SuperEvil;
import fr.dauphine.virus.Virus;


public class Main {

	public static void main(String[] args) {
		
		Virus virus = new Virus(-1,"méchant");
		Virus virus2 = new Virus(2,"Manil");
		Avenger transfoVirus = new VirusToAvengerAdapter(virus2);
		Avenger captainAmerica= new Avenger("Captain america",89);
		Avenger fusion = new FusionAvenger("Fusion", transfoVirus,captainAmerica);
		SuperEvil thanos = SuperEvil.getInstance(virus);
		System.out.println("print "+fusion.getPower());
		System.out.println("print "+thanos.getPower());
		Avenger fusion2 = new FusionAvenger("Fusion", fusion,fusion);
		System.out.println(fusion2.getPower());
	}

}
