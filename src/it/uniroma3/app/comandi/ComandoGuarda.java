package it.uniroma3.app.comandi;
import it.uniroma3.main.Partita;

public class ComandoGuarda implements Comando {
	@Override
	public void esegui(Partita partita) {
		System.out.println(partita.getGiocatore().getBorsa().toString());
	}

	@Override
	public void setParametro(String parametro) {

	}
	
	@Override
	public String getNome() {
		return "guarda";
	}
	
	@Override
	public String getParametro() {
		return "";
	}
}
