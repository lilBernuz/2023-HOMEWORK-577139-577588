package it.uniroma3.app.ambienti;

public class StanzaBuia extends Stanza {
	private String ogettoX;

	public StanzaBuia (String nome, String nomeOgettoX) {
		super(nome);
		this.ogettoX = nomeOgettoX;
	}

	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(ogettoX))
			return super.toString();
		else
			return this.toString();
			
	}

	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append("Qui c'è un buio pesto!");
		return risultato.toString();
	}
}
