package fr.dauphine.exception;

public class VirusIsAlreadySet extends Exception  {

	private static final long serialVersionUID = 1L;
	
	public VirusIsAlreadySet(){
		super("impossible d'ajouter cette maladie,tu es encore trop gentil ");
	}
	
	VirusIsAlreadySet(String msg){
		super(msg);
	}
}
