package fr.dauphine.adapter;

import java.util.ArrayList;

import fr.dauphine.avengers.Avenger;
import fr.dauphine.avengers.SuperPower;
import fr.dauphine.virus.Disease;
import fr.dauphine.virus.Virus;

public class VirusToAvengerAdapter extends Avenger {
	private Virus virus;

	public VirusToAvengerAdapter(Virus virus ) {
		this.virus=virus;
	}
   
	public void setName(String nom) {
		this.virus.setName(nom);
	}
	@Override
	public int getPower() {
		return (100-this.virus.getKidness());
	}
	@Override
	public void setPower(int value) {
		this.virus.setKindness(100-value);
	}
	public String getName() {

		return this.virus.getName();
	}
	public void addSuperPouvoir(SuperPower superpouvoir) {
		this.addSuperPouvoir(superpouvoir);
		this.virus.addDisease(convertSuperPouvoirToDisease(superpouvoir));
	}
	
	public ArrayList<SuperPower> getAllSuperPower(){
		ArrayList<SuperPower> tempList = new ArrayList<SuperPower>();
		for(Disease disease: this.virus.getDiseases()) {
			tempList.add(convertDiseaseToSuperPouvoir(disease));
		}
		return tempList;
	}
	
	public static Disease convertSuperPouvoirToDisease(SuperPower superpouvoir )
	{
			return new Disease(superpouvoir.getName());
	}
	
	public static SuperPower convertDiseaseToSuperPouvoir(Disease disease)
	{
			return new SuperPower(disease.getName());
	}


}
