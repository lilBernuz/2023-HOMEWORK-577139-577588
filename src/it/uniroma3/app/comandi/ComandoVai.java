package it.uniroma3.app.comandi;
import it.uniroma3.app.ambienti.Stanza;
import it.uniroma3.main.Partita;

public class ComandoVai implements Comando {

	private String direzione;

	@Override
	public void esegui(Partita partita) {
		
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(this.direzione==null) {
			System.out.println("Dove vuoi andare ?");
			return;
		}

		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);

		if (prossimaStanza == null) {
			System.out.println("Direzione inesistente");
			return;
		}

		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		int cfu = partita.getGiocatore().getCfu();
		System.out.println(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		System.out.println(partita.getGiocatore().getCfu() -1);
		partita.getGiocatore().setCfu(cfu-1);
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	@Override
	public String getNome() {
		return "vai";
	}
	
	@Override
	public String getParametro() {
		return this.direzione;
	}
}
