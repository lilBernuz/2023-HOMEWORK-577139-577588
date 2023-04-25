package it.uniroma3.app.comandi;
import it.uniroma3.main.Partita;

public class ComandoFine implements Comando {
	@Override
	public void esegui(Partita partita) {
		System.out.println("Grazie di aver giocato!");
	}
	
	@Override
	public void setParametro(String parametro) {
	}
	
	@Override
	public String getNome(){
		return "fine";
	}
	
	@Override
	public String getParametro() {
		return "";
	}
	
}
