package fr.dauphine.fusion;


import fr.dauphine.avengers.SuperEvil;
import fr.dauphine.virus.Virus;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class TestSingleton {
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
        assertEquals(superMechant1,superMechant);
    }

}
