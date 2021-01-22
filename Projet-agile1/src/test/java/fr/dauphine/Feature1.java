package fr.dauphine;

import static org.junit.Assert.assertEquals;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.dauphine.virus.Virus;  

public class Feature1 {
	private Virus virus;
	@Given("La creation du virus")
	public void la_creation_du_virus() {
	    virus = new Virus();
	}

	@When("on affecte le nom {string} et la valeur {string} en gentillesse")
	public void on_affecte_le_nom_et_la_valeur_a_la_gentillesse(String string, String string2) {
	    virus.setName(string);
	    System.out.println(string2);
	    virus.setKindness(Integer.parseInt(string2));
	}
	@Then("Le nom du virus est {string} et possede {string} de gentillesse")
	public void le_nom_du_virus_est_et_possede_de_gentillesse(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		boolean temp= false;
		temp = virus.getName().equals(string) 
				&& virus.getKidness()==Integer.parseInt(string2);
		assertEquals(true,temp);
	}




}