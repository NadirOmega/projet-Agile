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

public class TestFusionAvenger {
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
	        boolean test=true;
	        for(int i = 0;i< superPouvoirs.size();i++) {
	            if (fusionAvenger.getAllSuperPowerFusion().get(i)!=superPouvoirs.get(i))
	            	test=false;
	        }
	        assert(test);
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
	        FusionAvenger fusionAvenger2 = new FusionAvenger("La fusion d'une fusion" ,fusionAvenger,fusionAvenger);
	        assertEquals(fusionAvenger.getPower()+fusionAvenger.getPower(), fusionAvenger2.getPower());

	    }
}
