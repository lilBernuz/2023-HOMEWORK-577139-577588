import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.app.ambienti.Labirinto;
import it.uniroma3.app.ambienti.LabirintoBuilder;
import it.uniroma3.app.ambienti.Stanza;
import it.uniroma3.main.*;

public class TestPartita {

	Labirinto labirinto;
	Partita p;
	Stanza s;

	@Before
	public void setUp() {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		p = new Partita(labirinto);
		s = new Stanza("Stanza");
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", p.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		p.getLabirinto().setStanzaCorrente(s);
		assertEquals(s, p.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testIsFinita() {

		assertFalse(p.isFinita());
	}

}