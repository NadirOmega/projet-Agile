package fr.dauphine;

import static org.junit.Assert.assertEquals;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.dauphine.adapter.VirusToAvengerAdapter;
import fr.dauphine.virus.Disease;
import fr.dauphine.virus.Virus;

public class Feature2 {

    @Given("La creation du Virus {string} qui a {string} gentillesse et {string} et {string} sont des maladies")
    public Virus creation(String string, String string2, String string3,String string4) {
        Virus virus = new Virus(Integer.parseInt(string2),string);
        Disease disease=new Disease(string3);
        Disease disease1 = new Disease(string4);
        virus.addDisease(disease);
        virus.addDisease(disease1);
        return virus;
    }

    @When("Le virus {string} avec gentil {string} et maladies {string} et {string} est transforme en avenger")
    public VirusToAvengerAdapter virusAvenger(String string, String string1, String string2,
                                       String string3) {
        return new VirusToAvengerAdapter(creation(string,string1,string2,string3));

    }
    @Then("Le Avenger {string} a {string} de puissance et {string} et {string} sont des superpouvoirs")
    public void classeDuVirus(String string,String string1,String string2,String string3) {
        // Write code here that turns the phrase above into concrete actions
        VirusToAvengerAdapter av= virusAvenger(string,string1,string2,string3);
        Virus virus = creation(string,string1,string2,string3);
        assertEquals(100-av.getPower(),virus.getKidness());
        assertEquals(av.getName(),virus.getName());
        for(int i =0; i<virus.getDiseases().size();i++)
            assertEquals(virus.getDiseases().get(i).getName(),av.getAllSuperPower().get(i).getName());
    }




}