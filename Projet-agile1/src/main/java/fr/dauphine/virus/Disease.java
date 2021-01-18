package fr.dauphine.virus;
public class Disease {
	private String name ;
	private Virus virus;
	
	
	public Disease(String nom) {
		super();
		this.name = nom;
	}
	
	public Disease() {
		this.name="Unknown_diseas";
		this.virus=new Virus();
	}
	public Virus getVirus() {
		return virus;
	}

	public void setVirus(Virus virus)  {
		this.virus = virus;
	}


	public String getNom() {
		return name;
	}
	public void setNom(String nom) {
		this.name = nom;
	}
	
	public void beIndependant() {
		this.getVirus().getMaladies().remove(this);
	}
	public boolean isFree() {
		return this.getVirus()==null;
	}

}
