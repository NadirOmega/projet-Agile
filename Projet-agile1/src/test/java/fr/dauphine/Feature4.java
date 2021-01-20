package fr.dauphine;

import static org.junit.Assert.assertEquals;

import cucumber.api.PendingException;
import cucumber.api.java.bs.A;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.dauphine.adapter.VirusToAvenger;
import fr.dauphine.avengers.Avenger;
import fr.dauphine.avengers.FusionAvenger;
import fr.dauphine.avengers.SuperMechant;
import fr.dauphine.virus.Virus;
import org.junit.Assert;

import java.awt.*;
import java.io.IOException;

public class Feature4 {
    @Given("La creation de fusion {string} qui se compose du avenger {string} et" +
            " {string} qui ont du pouvoir {string} et {string}")
    public FusionAvenger creationFusion(String string, String string1, String string2,
                                        String string3, String string4) {
        FusionAvenger fusionAvenger = new FusionAvenger(string,new Avenger(string1,Integer.parseInt(string3)),
                new Avenger(string3,Integer.parseInt(string4)));
        return fusionAvenger;
    }

    @When("La fusion happens")
    public FusionAvenger fusion() {
        return null;
    }

    @Then("La fusion {string} se fait on a la somme du pouvoir {string} et " +
            "{string} qui ont {string} et {string} a puissance {string}")
    public void virusMechantOuPas(String string,String string1, String string2,
                                  String string3,String string4, String string5) {
        FusionAvenger fusionAvenger = new FusionAvenger(string,new Avenger(string1,Integer.parseInt(string3)),
                new Avenger(string3,Integer.parseInt(string4)));

        assertEquals(fusionAvenger.getPower(),Integer.parseInt(string3)+Integer.parseInt(string4));
    }




}