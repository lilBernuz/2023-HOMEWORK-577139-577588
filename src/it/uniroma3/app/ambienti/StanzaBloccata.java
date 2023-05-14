package it.uniroma3.app.ambienti;

public class StanzaBloccata extends Stanza {

	private String oggettoSbloccante;
	private String direzioneBloccata;

	public StanzaBloccata(String nome, String oggettoSbloccante, String direzioneBloccata) {
		super(nome);
		this.oggettoSbloccante = oggettoSbloccante;
		this.direzioneBloccata = direzioneBloccata;
	}

	public boolean isBloccato() {
		return !this.hasAttrezzo(oggettoSbloccante);
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.isBloccato() && direzione.equals(direzioneBloccata)) {
			return this;		
			}
		else 
			return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if(!this.isBloccato())
			return super.toString();
		else
			return this.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(super.toString());
		risultato.append("\nStanza bloccata nella direzione: " + this.direzioneBloccata);
		return risultato.toString();
	}
}

