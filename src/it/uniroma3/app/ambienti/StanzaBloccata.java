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
			return this;		}
		else 
			return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		String bloccata = "Stanza bloccata nella direzione: " + this.direzioneBloccata;
		if(this.isBloccato())
			return super.getDescrizione();
		else
			return bloccata;
	}
}

