/*
 class Test : hasAttrezo, getAttrezzo, addAttrezzo, getDirezioni

*/
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.app.ambienti.Stanza;
import it.uniroma3.app.attrezzi.Attrezzo;


class testStanza {

	private Stanza atrio;
	private Attrezzo lanterna;
	private Attrezzo osso;
	
	@BeforeEach
	public void setUp() {
		this.atrio = new Stanza("atrio");
		this.lanterna = new Attrezzo("lanterna", 3);
		this.osso = new Attrezzo("osso", 1);
		atrio.addAttrezzo(osso);
		
	}
	
	@Test
	public void testAddAttezzo() {	
		assertTrue(atrio.addAttrezzo(lanterna));
	}

	@Test
	public void testRemoveAttezzo() {
		assertTrue(atrio.removeAttrezzo("osso"));
	}
	
	@Test
	public void testRemoveAttezzo2() {
		assertFalse(atrio.removeAttrezzo("lanterna"));
	}
	
	@Test
	void testHasAttrezzo() {
		assertTrue(atrio.hasAttrezzo("osso"));
	}
	
	@Test
	void testHasAttrezzo2() {
		assertFalse(atrio.hasAttrezzo("lanterna"));
	}
	
	@Test
	void testGetAttrezzo() {
		Attrezzo a;
		a = osso;
		assertEquals(a, atrio.getAttrezzo("osso"));
	}
	
	@Test
	void testGetAttrezzo2() {
		Attrezzo a = new Attrezzo("prova", 1);
		a = lanterna;
		assertNotEquals(a, atrio.getAttrezzo("osso"));
	}
}
