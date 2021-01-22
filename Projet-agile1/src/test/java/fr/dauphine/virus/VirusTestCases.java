package fr.dauphine.virus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import fr.dauphine.exception.VirusIsAlreadySet;

class VirusTestCases {
	/**
	 * Ici nous allons effectuer les tests de la classe virus
	 */
	@Test 
	void testNameGetters() {
		Virus virus = new Virus();
		assertEquals("Unknown_virus",virus.getName());
	}
	@Test
	void testGentillesseGetter() {
		Virus virus = new Virus();
		assertEquals(100,virus.getKidness());
	}
	@Test
	void testConstructorVirus() {
		Virus virus = new Virus(0,"Sars-Agil-19");
		assert((virus.getKidness()==0) 
				&& (virus.getName().equals("Sars-Agil-19")));
	}

	@Test
	void testConstructorMaladie() {
		Disease disease = new Disease("Agil-19");
		assert(disease.getName().equals("Agil-19"));
	}
	@Test
	void testSetterNameVirus() {
		Virus virus = new Virus(0,"Sars-Agil-19");
		virus.setName("Sars-Agil-20");
		assertEquals("Sars-Agil-20",virus.getName());
	}
	@Test
	void testSetterGentillesseVirus() {
		Virus virus = new Virus(0,"Sars-Agil-19");
		virus.setKindness(1);
		assertEquals(1,virus.getKidness());
	}
	@Test
	void testSetterNameMaladie() {
		Disease disease = new Disease("Agil-19");
		disease.setName("Agil-20");
		assertEquals("Agil-20",disease.getName());
	}
	@Test
	void testSetterVirusMaladie() {
		Disease disease = new Disease("Agil-19");
		Virus virus = new Virus(0,"Sars-Agil-19");
		disease.setVirus(virus);
		assert( (disease.getVirus().getName().equals("Sars-Agil-19"))&&
				( (disease.getVirus().getKidness()==0))
				);
	}

	@Test
	void testAddDiseaseToVirus() {
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
	void testAddDiseaseToVirusV2() {
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
	void testAddDiseaseTo2Virus() {
		Disease disease = new Disease("Agil-19");
		Virus virus = new Virus(0,"Sars-Agil-19");
		virus.addDisease(disease);
		Virus virus2 = new Virus(0,"Sars-Agil-20");
		virus2.addDisease(disease);
		boolean test = false;
		
		for(Disease m : virus.getDiseases()) {
			if (m.getName().equals("Agil-19")) {
				test=true;
			}
		}
		assertFalse(test);
	}
	
	@Test(expected = VirusIsAlreadySet.class)
	void testAddDiseaseTo2VirusV2() throws VirusIsAlreadySet {
		Disease disease = new Disease("Agil-19");
		Virus virus = new Virus(4,"Sars-Agil-19");
		virus.addDisease(disease);
		Virus virus2 = new Virus(5,"Sars-Agil-20");
		virus2.addDiseaseV2(disease);

	
	}
}
