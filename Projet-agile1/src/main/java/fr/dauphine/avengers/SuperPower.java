package fr.dauphine.avengers;

public class SuperPower {
String name;
Avenger avenger;
public SuperPower(String name) {
	super();
	this.name = name;
}
public SuperPower() {

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
