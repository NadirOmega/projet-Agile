package fr.dauphine.avengers;

import java.util.ArrayList;

public class Avenger {
protected String name;
//max=100 min=0
protected int power;
ArrayList<SuperPouvoir> superpouvoirs;

public Avenger(String nom,int power) {
	super();
	this.name = nom;
	this.power=power;
	this.superpouvoirs = new ArrayList<SuperPouvoir>();
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

public void addSuperPower(SuperPouvoir superPower)  {
	this.superpouvoirs.add(superPower);
}
public ArrayList<SuperPouvoir> getAllSuperPower(){
	return superpouvoirs;
}
}
