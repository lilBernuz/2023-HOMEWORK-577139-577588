package it.uniroma3.app.ambienti;

public class Labirinto {
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	private Stanza stanzaCorrente;
	
	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
    	this.stanzaCorrente = stanzaCorrente;
    }
    
    public void setStanzaVincente(Stanza stanzaVincente) {
    	this.stanzaVincente = stanzaVincente;
    }
    
    public Stanza getStanzaCorrente() {
    	return this.stanzaCorrente;
    }

}
