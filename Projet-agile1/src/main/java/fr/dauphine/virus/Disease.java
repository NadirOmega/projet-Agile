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


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void beIndependant() {
		this.getVirus().getDiseases().remove(this);
	}
	public boolean isFree() {
		return this.getVirus()==null;
	}

}
