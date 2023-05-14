package it.uniroma3.app.comandi;
import it.uniroma3.app.attrezzi.Attrezzo;
import it.uniroma3.main.Partita;

public class ComandoPosa implements Comando {
	
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		partita.getGiocatore().posaAttrezzo(nomeAttrezzo);
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
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
		return "posa";
	}

}
