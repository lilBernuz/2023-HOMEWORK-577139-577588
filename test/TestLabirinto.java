
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.app.ambienti.Labirinto;
import it.uniroma3.app.ambienti.LabirintoBuilder;
import it.uniroma3.app.ambienti.Stanza;

public class TestLabirinto {
	
	Labirinto labirinto;
	
	@Before
	public void setUp() {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
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
