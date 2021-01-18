package fr.dauphine.virus;


import java.util.ArrayList;

import fr.dauphine.exception.VirusIsAlreadySet;

public class Virus {
	//valeur max = 100
	private int kindnesse;
	private String name ;
	//Ajout de maladies 
	private ArrayList<Disease> diseases ;

	public Virus(int gentillesse, String nom) {
		super();
		this.kindnesse = gentillesse;
		this.name = nom;
		this.diseases= new ArrayList<Disease>();
	}
	public Virus() {
		this.kindnesse = 100;
		this.name = "Unknown_virus";
		this.diseases= new ArrayList<Disease>();
	}
	
	
	public boolean addMaladieV2(Disease maladie) throws VirusIsAlreadySet  {

		if (!maladie.isFree()) {
			Virus victime = maladie.getVirus();
			if (!this.compareTo(victime))
			{
					this.setGentillesse(this.kindnesse-1);
					throw new VirusIsAlreadySet();
			}
			else {
				maladie.beIndependant();
				diseases.add(maladie);
				maladie.setVirus(this);
				this.setGentillesse(this.kindnesse+1);
				return true;
			}
		}
		else
			this.addMaladie(maladie);
		
		return true;
	}

	public ArrayList<Disease> getMaladies() {
		return diseases;
	}
	public void setMaladies(ArrayList<Disease> maladies) {
		this.diseases = maladies;
	}

	//constructeur sans paramétres 




	public int getGentillesse() {
		return kindnesse;
	}
	public void setGentillesse(int gentillesse) {
		this.kindnesse = gentillesse;
	}
	public String getNom() {
		return name;
	}
	public void setNom(String nom) {
		this.name = nom;
	}


	public String mutation(int x ) {
		this.kindnesse+=x;
		return "this.nom"+" "+ this.kindnesse;
	}


	public void addMaladie(Disease maladie)  {

		if (maladie.getVirus()!=null) {
			//O Voleur , o voleur !
			Virus victime= maladie.getVirus();
			victime.getMaladies().remove(maladie);
		}
		diseases.add(maladie);
		maladie.setVirus(this);
	}
	/**
	 * 
	 * @param virus
	 * @return 
	 * 1 si virus actuelle est plus méchant que le virus en paramétre
	 * 0 si egaux
	 * -1 si virus en paramétre est plus méchant !			
	 */
	public boolean compareTo(Virus virus) {
		return this.getGentillesse()<virus.getGentillesse();
	}


}
