package fr.dauphine.avengers;

import fr.dauphine.adapter.VirusToAvengerAdapter;
import fr.dauphine.virus.Virus;

public class SuperEvil extends VirusToAvengerAdapter{

	private static SuperEvil instance;

	private SuperEvil(Virus virus) {
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
	/**
	 * Thread Safe singelton
	 * @param virus
	 * @return SuperEvil instance
	 */
	public static synchronized SuperEvil getInstance(Virus virus) {
		if (virus.getKidness()!=-1) {
			System.out.println("Ce virus n'est pas assez puissante pour "
					+ "devenir Thanos !");
			return null;
		}
		else if (instance==null) {
			instance = new SuperEvil(virus);
			return instance;
		}
		else return instance;
	}







	@Override
	public int getPower() {
		return this.power;
	}
	
	
}
