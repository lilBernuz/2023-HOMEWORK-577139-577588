package it.uniroma3.app.comandi;

import it.uniroma3.main.Partita;

public interface Comando {
	
	//	esecuzione del comando
	public void esegui(Partita partita);
	
	//	set parametro del comando
	public void setParametro(String parametro);
	
	public String getNome();
	public String getParametro();
}