import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.main.Partita;
import it.uniroma3.app.ambienti.Labirinto;
import it.uniroma3.app.ambienti.LabirintoBuilder;
import it.uniroma3.app.attrezzi.Attrezzo;
import it.uniroma3.app.comandi.Comando;
import it.uniroma3.app.comandi.ComandoPrendi;

public class TestComandoPrendi {
	Labirinto labirinto;
	Partita partita = new Partita(labirinto);
	Comando comando = new ComandoPrendi();
	Attrezzo attrezzo = new Attrezzo("orologio", 3);
	String nomeAttrezzo;
	
	@Before
	public void setup() {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);  // aggiungo l'attrezzo alla stanza corrente del giocatore
		this.nomeAttrezzo = this.attrezzo.getNome();
		// effettuo l'operazione di prendere l'attrezzo dalla stanza e posarlo nella borsa
		this.comando.setParametro(this.nomeAttrezzo);
		this.comando.esegui(this.partita);
	}

	@Test
	public void test_ComandoPrendi() {
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(this.nomeAttrezzo));
	}
	
	@Test
	public void test_ComandoPrendi2() {
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(this.nomeAttrezzo));
	}


}
