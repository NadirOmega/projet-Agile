package fr.dauphine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.dauphine.virus.Disease;
import fr.dauphine.virus.Virus;

public class Feature2 {

    @Given("La creation du Virus {string} qui a {string} gentillesse et {string} et {string} sont des maladies")
    public Virus creation(String string, String string2, String string3,String string4) {
        Virus virus = new Virus(Integer.parseInt(string2),string);
        Disease disease=new Disease(string3);
        Disease disease1 = new Disease(string4);
        virus.addMaladie(disease);
        virus.addMaladie(disease1);
        return virus;
    }

    @When("Le virus {string} avec gentil {string} et maladies {string} et {string} est transforme en avenger")
    public void virusAvenger(String string, String string1, String string2,
                                       String string3) {
       assertEquals(true,true);

    }
    @Then("Le Avenger {string} a {string} de puissance et {string} et {string} sont des superpouvoirs")
    public void classeDuVirus(String string,String string1,String string2,String string3) {
    	assertEquals(true,true);
    }




}