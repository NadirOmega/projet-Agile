package fr.dauphine.fusion;


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

public class TestAdapter {
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

}
