package it.uniroma3.app.comandi;
import it.uniroma3.main.Partita;

public class ComandoNonValido implements Comando {
	
	@Override
	public void esegui(Partita partita) {
		
	}
	
	@Override
	public void setParametro(String parametro) {
		
	}
	
	@Override
	public String getNome(){
		return "non valido";
	}
	@Override
	public String getParametro() {
		return "";
	}
}
