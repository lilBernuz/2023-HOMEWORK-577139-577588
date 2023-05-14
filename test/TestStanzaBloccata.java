import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.main.Partita;
import it.uniroma3.app.ambienti.Labirinto;
import it.uniroma3.app.ambienti.LabirintoBuilder;
import it.uniroma3.app.ambienti.Stanza;
import it.uniroma3.app.ambienti.StanzaBloccata;
import it.uniroma3.app.attrezzi.Attrezzo;
import it.uniroma3.app.comandi.Comando;
import it.uniroma3.app.comandi.ComandoVai;

public class TestStanzaBloccata {
	Labirinto labirinto;
	StanzaBloccata stanzaBloccata = new StanzaBloccata("atrio", "nord", "chiave");
	Stanza stanza = new Stanza("cassaforte");
	Attrezzo attrezzosblocca = new Attrezzo("chiave", 2);
	Partita partita = new Partita(labirinto);

	@Before
	public void setup() {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		this.stanzaBloccata.impostaStanzaAdiacente("nord", this.stanza); // imposto come stanza adiacente la stanza bloccata
	}
	
	@Test
	public void test_StanzaBloccata() {
		this.stanzaBloccata.addAttrezzo(this.attrezzosblocca); // aggiungo l'attrezzo sbloccante alla stanza bloccata
		Comando comando = new ComandoVai();
		comando.setParametro("nord");
		comando.esegui(this.partita);
		assertTrue(this.stanzaBloccata.getStanzaAdiacente("nord").getNome().equals("cassaforte"));
	}
	
	@Test
	public void test_StanzaBloccata2() {
		Comando comando = new ComandoVai();
		comando.setParametro("nord");
		comando.esegui(this.partita);
		assertTrue(this.stanzaBloccata.getStanzaAdiacente("nord").getNome().equals("atrio"));
	}

}
