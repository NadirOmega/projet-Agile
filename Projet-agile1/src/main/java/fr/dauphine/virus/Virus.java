package fr.dauphine.virus;


import java.util.ArrayList;

import fr.dauphine.exception.VirusIsAlreadySet;

/**
 * Class describing virus model
 * @author Nad & Manil
 *
 */
public class Virus {
	// min = 0; max = 100
	//the smaller the value, the more powerful the virus
	private int kindnesse;
	
	private String name ;
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
	public String mutation(int x ) {
		this.kindnesse+=x;
		return "this.nom"+" "+ this.kindnesse;
	}


	public void addDisease(Disease disease)  {

		if (disease.getVirus()!=null) {
			//O Voleur , o voleur !
			Virus victime= disease.getVirus();
			victime.getDiseases().remove(disease);
		}
		diseases.add(disease);
		disease.setVirus(this);
	}
	/**
	 * improved version for the Add, check whether a virus is already set or not 
	 * @param disease
	 * @return boolean , succesfull or not
	 * @throws VirusIsAlreadySet
	 */
	public boolean addDiseaseV2(Disease disease) throws VirusIsAlreadySet  {

		if (!disease.isFree()) {
			Virus victime = disease.getVirus();
			if (!this.compareTo(victime))
			{
				this.setKindness(this.kindnesse-1);
				throw new VirusIsAlreadySet();
			}
			else {
				disease.beIndependant();
				diseases.add(disease);
				disease.setVirus(this);
				this.setKindness(this.kindnesse+1);
				return true;
			}
		}
		else
			this.addDisease(disease);

		return true;
	}

	/**
	 * 
	 * @param virus
	 * @return boolean 
	 * true :  if a the actual virus is meaner than the virus in param 
	 * false : other cases
	 */
	public boolean compareTo(Virus virus) {
		return this.getKidness()<virus.getKidness();
	}

	/* Getter and Setters */ 

	public int getKidness() {
		return kindnesse;
	}
	public void setKindness(int kidness) {
		this.kindnesse = kidness;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Disease> getDiseases() {
		return this.diseases;
	}
	public ArrayList<Disease> getDiseasesClone() {
		ArrayList<Disease> clone = (ArrayList<Disease>) diseases.clone();
		return clone;
	}
	public void setMaladies(ArrayList<Disease> maladies) {
		this.diseases = maladies;
	}





}
