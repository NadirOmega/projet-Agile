package fr.dauphine;


import fr.dauphine.adapter.VirusToAvengerAdapter;
import fr.dauphine.avengers.Avenger;
import fr.dauphine.avengers.FusionAvenger;
import fr.dauphine.avengers.SuperEvil;
import fr.dauphine.avengers.SuperPower;
import fr.dauphine.virus.Disease;
import fr.dauphine.virus.Virus;
import org.junit.Test;

import java.util.ArrayList;

import static fr.dauphine.adapter.VirusToAvengerAdapter.convertDiseaseToSuperPouvoir;
import static org.junit.Assert.assertEquals;

public class TestMain {
    @Test
    public void testVirusToAvengerGetPower(){
        Virus virus = new Virus(10,"test1");
        VirusToAvengerAdapter virusToAvenger = new VirusToAvengerAdapter(virus);
        assertEquals(90,virusToAvenger.getPower());
    }

    @Test
    public void testVirusToAvengerGetName(){
        Virus virus = new Virus(10,"test2");
        VirusToAvengerAdapter virusToAvenger = new VirusToAvengerAdapter(virus);
        assertEquals(virusToAvenger.getName(),virus.getName());
    }

    @Test
    public void testVirusToAvengerSetPower(){
        Virus virus = new Virus(10,"test3");
        VirusToAvengerAdapter virusToAvenger = new VirusToAvengerAdapter(virus);
        virusToAvenger.setPower(5);
        assertEquals(100-virusToAvenger.getPower(),virus.getKidness());
    }
    @Test
    public void testVirusToAvengerSetName(){
        Virus virus = new Virus(10,"test4");
        VirusToAvengerAdapter virusToAvenger = new VirusToAvengerAdapter(virus);
        virusToAvenger.setName("mister test 4");
        assertEquals(virusToAvenger.getName(),virus.getName());
    }

    @Test
    public void testMaladieToSuperPouvoirGetNom(){
        Disease disease = new Disease("test5");
        SuperPower superPouvoir = convertDiseaseToSuperPouvoir(disease);
        assertEquals(disease.getName(),superPouvoir.getName());
    }

    @Test
    public void testMaladieToSuperPouvoirGetAvenger(){
        Disease disease = new Disease("disease test7");
        SuperPower superPouvoir = convertDiseaseToSuperPouvoir(disease);
        assertEquals(disease.getName(),superPouvoir.getName());
    }

    /*
     * 
     * Tester uniquement avec le virus devenu avenger 
     * on teste la fusion pas l'ancien code !
     */
    @Test
    public void testGetAllSuperPower(){

        SuperPower superPouvoir = new SuperPower("1");
        SuperPower superPouvoir2 = new SuperPower("2");
        Avenger avenger = new Avenger("nadir",1);
        avenger.addSuperPower(superPouvoir);
        avenger.addSuperPower(superPouvoir2);
        ArrayList<SuperPower> superPouvoirs = new ArrayList<SuperPower>();
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
        SuperEvil superMechant = SuperEvil.getInstance(virus);
        assertEquals("Thanos",superMechant.getName());
    }

    @Test
    public void testSuperMechantSetName(){
        Virus virus = new Virus(-1,"string");
        SuperEvil superMechant = SuperEvil.getInstance(virus);
        superMechant.setName("nadir el 3amiq");
        assertEquals("Thanos",superMechant.getName());
    }

    @Test
    public void testPuissanceSuperMechant(){
        SuperEvil superMechant = SuperEvil.getInstance(new Virus(-1," "));
        assertEquals(400,superMechant.getPower());
    }

    @Test
    public void testUniciteSuperMechant(){
        SuperEvil superMechant = SuperEvil.getInstance(new Virus(-1," 1"));
        SuperEvil superMechant1 = SuperEvil.getInstance(new Virus(-1," 2"));
        assertEquals(superMechant1.getName(),superMechant.getName());
    }

    @Test
    public void testFusionGetPouvoir(){
        Avenger avenger1 = new Avenger("gerald",50);
        Avenger avenger2 = new Avenger("sawsaw",50);
        SuperPower superPouvoir1 = new SuperPower("Magic");
        SuperPower superPouvoir2 = new SuperPower("Sword");
        SuperPower superPouvoir3 = new SuperPower("Lying");
        avenger1.addSuperPower(superPouvoir1);
        avenger1.addSuperPower(superPouvoir2);
        avenger2.addSuperPower(superPouvoir3);

        ArrayList<SuperPower> superPouvoirs = new ArrayList<SuperPower>();
        superPouvoirs.add(superPouvoir1);
        superPouvoirs.add(superPouvoir2);
        superPouvoirs.add(superPouvoir3);
        FusionAvenger fusionAvenger = new FusionAvenger("la fusion",avenger1,avenger2);
        for(int i = 0;i< superPouvoirs.size();i++) {
            assertEquals(fusionAvenger.getAllSuperPowerFusion().get(i), superPouvoirs.get(i));
        }
    }

    @Test
    public void testFusionGetPower(){
        Avenger avenger1 = new Avenger("gerald",50);
        Avenger avenger2 = new Avenger("sawsaw",35);
        FusionAvenger fusionAvenger = new FusionAvenger("la fusion",avenger1,avenger2);
        assertEquals(avenger1.getPower()+avenger2.getPower(), fusionAvenger.getPower());

    }
    @Test
    public void testFusionOfFusionGetPower(){
        Avenger avenger1 = new Avenger("gerald",50);
        Avenger avenger2 = new Avenger("sawsaw",35);
        FusionAvenger fusionAvenger = new FusionAvenger("la fusion",avenger1,avenger2);
        assertEquals(avenger1.getPower()+avenger2.getPower(), fusionAvenger.getPower());

    }
}
