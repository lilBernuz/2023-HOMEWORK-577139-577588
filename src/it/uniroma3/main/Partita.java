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

	public Partita(Labirinto labirinto){
		this.labirinto = labirinto;
		this.giocatore = new Giocatore(20);
		this.finita = false;
	}

	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	public boolean vinta() {
		return this.labirinto.getStanzaCorrente() == this.labirinto.getStanzaVincente();
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
