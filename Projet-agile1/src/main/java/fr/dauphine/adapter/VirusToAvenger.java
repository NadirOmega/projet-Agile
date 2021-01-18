package fr.dauphine.adapter;

import java.util.ArrayList;

import fr.dauphine.avengers.Avenger;
import fr.dauphine.avengers.SuperPouvoir;
import fr.dauphine.virus.Disease;
import fr.dauphine.virus.Virus;

public class VirusToAvenger extends Avenger {
	private Virus virus;

	public VirusToAvenger(Virus virus ) {
		this.virus=virus;
	}
   
	public void setNom(String nom) {
		this.virus.setNom(nom);
	}
	
	public int getPower() {
		return (100-this.virus.getGentillesse());
	}
	
	public void setPower(int value) {
		this.virus.setGentillesse(100-value);
	}
	
	public String getNom() {

		return this.virus.getNom();
	}
	public void addSuperPouvoir(SuperPouvoir superpouvoir) {
		this.addSuperPouvoir(superpouvoir);
		this.virus.addMaladie(convertSuperPouvoirToDisease(superpouvoir));
	}
	
	public ArrayList<SuperPouvoir> getAllSuperPower(){
		ArrayList<SuperPouvoir> tempList = new ArrayList<SuperPouvoir>();
		for(Disease disease: this.virus.getMaladies()) {
			tempList.add(convertDiseaseToSuperPouvoir(disease));
		}
		return tempList;
	}
	
	public static Disease convertSuperPouvoirToDisease(SuperPouvoir superpouvoir )
	{
			return new Disease(superpouvoir.getName());
	}
	
	public static SuperPouvoir convertDiseaseToSuperPouvoir(Disease disease)
	{
			return new SuperPouvoir(disease.getNom());
	}

	
	public static Avenger hardConversion(Virus virus) {
		return new Avenger(virus.getNom(),100-virus.getGentillesse());
	}
	

}
