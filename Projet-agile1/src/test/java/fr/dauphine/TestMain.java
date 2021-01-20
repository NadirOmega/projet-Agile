package fr.dauphine;


import fr.dauphine.adapter.VirusToAvenger;
import fr.dauphine.avengers.Avenger;
import fr.dauphine.avengers.SuperMechant;
import fr.dauphine.avengers.SuperPouvoir;
import fr.dauphine.virus.Disease;
import fr.dauphine.virus.Virus;
import org.junit.Test;

import java.util.ArrayList;

import static fr.dauphine.adapter.VirusToAvenger.convertDiseaseToSuperPouvoir;
import static org.junit.Assert.assertEquals;

public class TestMain {
    @Test
    public void testVirusToAvengerGetPower(){
        Virus virus = new Virus(10,"test1");
        VirusToAvenger virusToAvenger = new VirusToAvenger(virus);
        assertEquals(90,virusToAvenger.getPower());
    }

    @Test
    public void testVirusToAvengerGetName(){
        Virus virus = new Virus(10,"test2");
        VirusToAvenger virusToAvenger = new VirusToAvenger(virus);
        assertEquals(virusToAvenger.getNom(),virus.getNom());
    }

    @Test
    public void testVirusToAvengerSetPower(){
        Virus virus = new Virus(10,"test3");
        VirusToAvenger virusToAvenger = new VirusToAvenger(virus);
        virusToAvenger.setPower(5);
        assertEquals(100-virusToAvenger.getPower(),virus.getGentillesse());
    }
    @Test
    public void testVirusToAvengerSetName(){
        Virus virus = new Virus(10,"test4");
        VirusToAvenger virusToAvenger = new VirusToAvenger(virus);
        virusToAvenger.setName("mister test 4");
        assertEquals(virusToAvenger.getNom(),virus.getNom());
    }

    @Test
    public void testMaladieToSuperPouvoirGetNom(){
        Disease disease = new Disease("test5");
        SuperPouvoir superPouvoir = convertDiseaseToSuperPouvoir(disease);
        assertEquals(disease.getNom(),superPouvoir.getName());
    }

    /*@Test
    public void testMaladieToSuperPouvoirSetNom(){
        Disease disease = new Disease("test6");
        SuperPouvoir superPouvoir = convertDiseaseToSuperPouvoir(disease);
        superPouvoir.setName("madame test 6");
        assertEquals(disease.getNom(),superPouvoir.getName());
    }*/

    @Test
    public void testMaladieToSuperPouvoirGetAvenger(){
        Disease disease = new Disease("disease test7");
        SuperPouvoir superPouvoir = convertDiseaseToSuperPouvoir(disease);
        assertEquals(disease.getNom(),superPouvoir.getName());
    }

    /*
     * 
     * Tester uniquement avec le virus devenu avenger 
     * on teste la fusion pas l'ancien code !
     */
    @Test
    public void testGetAllSuperPower(){

        SuperPouvoir superPouvoir = new SuperPouvoir("1");
        SuperPouvoir superPouvoir2 = new SuperPouvoir("2");
        Avenger avenger = new Avenger("nadir",1);
        avenger.addSuperPower(superPouvoir);
        avenger.addSuperPower(superPouvoir2);
        ArrayList<SuperPouvoir> superPouvoirs = new ArrayList<SuperPouvoir>();
        superPouvoirs.add(superPouvoir);
        superPouvoirs.add(superPouvoir2);
        assertEquals(superPouvoirs,avenger.getAllSuperPower());
    }

    /**
     * Test avec un setter: il faut mettre
     * superMechant.setName("test")
     * Avant le test !
     */
    @Test
    public void testSuperMechantName(){
        Virus virus = new Virus(-1,"tha");
        SuperMechant superMechant = SuperMechant.getInstance(virus);
        assertEquals("Thanos",superMechant.getName());
    }

    @Test
    public void testSuperMechantSetName(){
        Virus virus = new Virus(-1,"string");
        SuperMechant superMechant = SuperMechant.getInstance(virus);
        superMechant.setName("nadir el 3amiq");
        assertEquals("Thanos",superMechant.getName());
    }

    @Test
    public void testPuissanceSuperMechant(){
        SuperMechant superMechant = SuperMechant.getInstance(new Virus(-1," "));
        assertEquals(400,superMechant.getPower());
    }

    @Test
    public void testUniciteSuperMechant(){
        SuperMechant superMechant = SuperMechant.getInstance(new Virus(-1," 1"));
        SuperMechant superMechant1 = SuperMechant.getInstance(new Virus(-1," 2"));
        assertEquals(superMechant1.getName(),superMechant.getName());
    }

    @Test

}
