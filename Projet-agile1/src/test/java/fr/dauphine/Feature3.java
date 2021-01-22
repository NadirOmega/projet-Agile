package fr.dauphine;

import static org.junit.Assert.assertEquals;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.dauphine.adapter.VirusToAvengerAdapter;
import fr.dauphine.avengers.SuperEvil;
import fr.dauphine.virus.Virus;
import org.junit.Assert;

import java.awt.*;
import java.io.IOException;

public class Feature3 {
    @Given("La creation virus {string}")
    public Virus creationDunVirus(String string) {
        return new Virus(5,string);
    }

    @When("Le virus {string} se transforme en supermechant")
    public SuperEvil virusMechant(String string) {
        SuperEvil superMechant = SuperEvil.getInstance(creationDunVirus(string));

        return superMechant;

    }
    @Then("Le supermechant {string} est unique")
    public void virusMechantOuPas(String string) {
        SuperEvil superMechant = virusMechant(string);
        SuperEvil superMechant2 = SuperEvil.getInstance(new Virus());
        assertEquals(superMechant2,superMechant);
    }




}