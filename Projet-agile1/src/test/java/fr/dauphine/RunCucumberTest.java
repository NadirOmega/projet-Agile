package fr.dauphine;
import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import fr.dauphine.virus.Virus;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
@RunWith(Cucumber.class)  

@CucumberOptions(strict = true)

public class RunCucumberTest {

}