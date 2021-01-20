package fr.dauphine.avengers;

import fr.dauphine.adapter.VirusToAvenger;
import fr.dauphine.virus.Virus;

public class SuperMechant extends VirusToAvenger{

	private static SuperMechant instance;

	private SuperMechant(Virus virus) {
		super(virus);
		this.power=400;
		this.name="Thanos";
		//this.addSuperPower(new SuperPouvoir("Destruction"));
	}
	public String getName(){
		return this.name;
	}
	public void setName(String s){

	}
	public static SuperMechant getInstance(Virus virus) {
		if (virus.getGentillesse()!=-1) {
			System.out.println("Ce virus n'est pas assez puissante pour "
					+ "devenir Thanos !");
			return null;
		}
		else if (instance==null) {
			instance = new SuperMechant(virus);
			return instance;
		}
		else return instance;
	}








	public int getPower() {
		return this.power;
	}
	
	
}
