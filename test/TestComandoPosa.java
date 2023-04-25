import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.main.Partita;
import it.uniroma3.app.attrezzi.Attrezzo;
import it.uniroma3.app.comandi.Comando;
import it.uniroma3.app.comandi.ComandoPosa;

public class TestComandoPosa {
	Partita partita = new Partita();
	Comando comando = new ComandoPosa();
	Attrezzo attrezzo = new Attrezzo("osso", 1);
	String nomeAttrezzo;


	@Before
	public void setup() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);  // aggiungo l'attrezzo alla borsa del giocatore
		this.nomeAttrezzo = this.attrezzo.getNome();
		// effettuo l'operazione di posare l'attrezzo nella stanza corrente
		this.comando.setParametro(this.nomeAttrezzo);
		this.comando.esegui(partita);
	}
	
	@Test
	public void test_ComandoPosa1() {
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(this.nomeAttrezzo));
	}
	
	@Test
	public void test_ComandoPosa2() {
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(this.nomeAttrezzo));
	}

}
