package it.uniroma3.main;
import it.uniroma3.app.ambienti.Labirinto;
import it.uniroma3.app.ambienti.Stanza;
import it.uniroma3.app.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private Stanza stanzaCorrente;


	public Partita(){
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore(20);
		labirinto.creaStanze();
		this.finita = false;
		this.stanzaCorrente = labirinto.getStanzaIniziale();
	}

	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	public boolean vinta() {
		return this.getStanzaCorrente() == this.labirinto.getStanzaVincente();
	}
	
	public boolean giocatoreIsVivo() {
		return giocatore.getCfu() != 0;
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */

	public boolean isFinita() {
		return finita || vinta() || !giocatoreIsVivo();
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
}
