package it.uniroma3.app.ambienti;
import it.uniroma3.app.attrezzi.Attrezzo;

public class Labirinto {
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	
	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	public void creaStanze() {

		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo spada = new Attrezzo("spada", 5);
		Attrezzo bambola = new Attrezzo("bambola", 2);
		Attrezzo scudo = new Attrezzo("scudo", 4);

		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		StanzaMagica labIA = new StanzaMagica("LabIA");

		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN11.impostaStanzaAdiacente("sud", labIA);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		labIA.impostaStanzaAdiacente("nord", aulaN11);

		/* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(spada);
		atrio.addAttrezzo(osso);
		atrio.addAttrezzo(lanterna);
		atrio.addAttrezzo(bambola);
		atrio.addAttrezzo(scudo);
		laboratorio.addAttrezzo(spada);
		aulaN11.addAttrezzo(spada);
		labIA.addAttrezzo(lanterna);

		
		this.stanzaVincente = biblioteca;
		this.stanzaIniziale = atrio;
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	
}
