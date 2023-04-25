package it.uniroma3.app.ambienti;
import it.uniroma3.app.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza {
	private String ogettoX;

	public StanzaBuia (String nome, String nomeOgettoX) {
		super(nome);
		this.ogettoX = nomeOgettoX;
	}

	@Override
	public String getDescrizione() {
		boolean buia = false;
		Attrezzo[] attrezzi = super.getAttrezzi();
		for(int i = 0; i < attrezzi.length; i++) {
			if(!attrezzi[i].getNome().equals(this.ogettoX)) {
				buia = true;
			}
		}
	}
}
