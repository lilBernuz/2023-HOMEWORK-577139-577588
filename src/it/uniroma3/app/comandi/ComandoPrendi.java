package it.uniroma3.app.comandi;
import it.uniroma3.app.attrezzi.Attrezzo;
import it.uniroma3.main.Partita;

public class ComandoPrendi implements Comando{
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		
		Attrezzo attrezzo = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		partita.getGiocatore().prendiAttrezzo(attrezzo);
		partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
	
	@Override 
	public String getNome() {
		return "prendi";
	}
}
