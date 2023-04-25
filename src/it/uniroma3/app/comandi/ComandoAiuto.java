package it.uniroma3.app.comandi;
import it.uniroma3.main.Partita;

public class ComandoAiuto implements Comando {
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "borsa"};

	@Override
	public void esegui(Partita partita) {
		
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.println(elencoComandi[i]+" ");
		System.out.println();
	}
	
	@Override
	public void setParametro(String parametro) {
	}
	
	@Override
	public String getNome() {
		return "aiuto";
	}
	
	@Override 
	public String getParametro() {
		return "";
	}
}
