package fr.dauphine.avengers;

public class SuperPouvoir {
String name;
Avenger avenger;
public SuperPouvoir(String name) {
	super();
	this.name = name;
}
public SuperPouvoir() {

}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Avenger getAvenger() {
	return avenger;
}
public void setAvenger(Avenger avenger) {
	this.avenger = avenger;
}

}
