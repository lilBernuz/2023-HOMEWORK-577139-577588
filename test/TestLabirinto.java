
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.app.ambienti.Labirinto;
import it.uniroma3.app.ambienti.Stanza;

public class TestLabirinto {
	
	Labirinto labirinto = new Labirinto();
	Stanza stanzaIniziale = new Stanza("atrio");
	Stanza stanzaFinale = new Stanza("Biblioteca");
	
	@Before
	public void setUp() {
		this.labirinto.creaStanze();	
	}
	

	@Test
	public void test_getStanzaFinale() {
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());		
	}
	
	@Test
	public void test_getStanzaIniziale() {
		assertEquals("atrio", labirinto.getStanzaIniziale().getNome());	
	}
}		
