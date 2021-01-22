package fr.dauphine.avengers;

import java.util.ArrayList;
/**
 * Class of Avenger model
 * @author Nad 
 *
 */
public class Avenger {
	protected String name;

	//max=100 min=0
	protected int power;
	protected ArrayList<SuperPower> superpowers;

	public Avenger(String nom,int power) {
		super();
		this.name = nom;
		this.power=power;
		this.superpowers = new ArrayList<SuperPower>();
	}
	public Avenger() {
		super();
	}

	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}

	public String getname() {
		return name;
	}
	public void setName(String nom) {
		this.name = nom;
	}

	public void addSuperPower(SuperPower superPower)  {
		this.superpowers.add(superPower);
	}

	/**
	 * avoid returning all the list
	 * @return a clone of allSuperpower List
	 */
	public ArrayList<SuperPower> getAllSuperPower(){
		ArrayList<SuperPower> duplicata = (ArrayList<SuperPower>) superpowers.clone();
		return duplicata;
	}
}
