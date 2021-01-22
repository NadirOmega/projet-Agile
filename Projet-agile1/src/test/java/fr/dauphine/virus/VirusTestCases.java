package fr.dauphine.virus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import fr.dauphine.exception.VirusIsAlreadySet;

public class VirusTestCases {
	/**
	 * Ici nous allons effectuer les tests de la classe virus
	 */
	@Test 
	public void testNameGetters() {
		Virus virus = new Virus();
		assertEquals("Unknown_virus",virus.getName());
	}
	@Test
	public void testGentillesseGetter() {
		Virus virus = new Virus();
		assertEquals(100,virus.getKidness());
	}
	@Test
	public void testConstructorVirus() {
		Virus virus = new Virus(0,"Sars-Agil-19");
		assert((virus.getKidness()==0) 
				&& (virus.getName().equals("Sars-Agil-19")));
	}

	@Test
	public void testConstructorMaladie() {
		Disease disease = new Disease("Agil-19");
		assert(disease.getName().equals("Agil-19"));
	}
	@Test
	public void testSetterNameVirus() {
		Virus virus = new Virus(0,"Sars-Agil-19");
		virus.setName("Sars-Agil-20");
		assertEquals("Sars-Agil-20",virus.getName());
	}
	@Test
	public void testSetterGentillesseVirus() {
		Virus virus = new Virus(0,"Sars-Agil-19");
		virus.setKindness(1);
		assertEquals(1,virus.getKidness());
	}
	@Test
	public void testSetterNameMaladie() {
		Disease disease = new Disease("Agil-19");
		disease.setName("Agil-20");
		assertEquals("Agil-20",disease.getName());
	}
	@Test
	public void testSetterVirusMaladie() {
		Disease disease = new Disease("Agil-19");
		Virus virus = new Virus(0,"Sars-Agil-19");
		disease.setVirus(virus);
		assert( (disease.getVirus().getName().equals("Sars-Agil-19"))&&
				( (disease.getVirus().getKidness()==0))
				);
	}

	@Test
	public void testAddDiseaseToVirus() {
		Disease disease = new Disease("Agil-19");
		Virus virus = new Virus(0,"Sars-Agil-19");
		virus.addDisease(disease);
		boolean test = false;
		for(Disease m : virus.getDiseases()) {
			if (m.getName().equals("Agil-19")) {
				test=true;
			}
		}
		assert(test);
	}
	@Test
	public void testAddDiseaseToVirusV2() {
		Disease disease = new Disease("Agil-19");
		Virus virus = new Virus(0,"Sars-Agil-19");
		virus.addDisease(disease);
		boolean test = false;
		for(Disease m : virus.getDiseases()) {
			if (m.getName().equals("Agil-19")) {
				test=true;
			}
		}
		test = (test && (disease.getVirus()==virus));
		assert(test);
	}
	@Test
	public void testAddDiseaseTo2Virus() {
		Disease disease = new Disease("Agil-19");
		Virus virus = new Virus(0,"Sars-Agil-19");
		virus.addDisease(disease);
		Virus virus2 = new Virus(0,"Sars-Agil-20");
		virus2.addDisease(disease);
		boolean test = false;
		
		for(Disease m : virus.getDiseases()) {
			if (m.getName().equals("Agil-19")) {
				System.out.println(" found ");
				test=true;
			}
		}
		assertFalse(test);
	}
	
	@Test(expected = VirusIsAlreadySet.class)
	public void testAddDiseaseTo2VirusV2() throws VirusIsAlreadySet {
		Disease disease = new Disease("Agil-19");
		Virus virus = new Virus(4,"Sars-Agil-19");
		virus.addDisease(disease);
		Virus virus2 = new Virus(5,"Sars-Agil-20");
		virus2.addDiseaseV2(disease);

	
	}
}
