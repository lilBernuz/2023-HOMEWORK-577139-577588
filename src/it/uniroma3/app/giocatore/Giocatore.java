package it.uniroma3.app.giocatore;
import it.uniroma3.app.attrezzi.Attrezzo;

public class Giocatore {
	
	private int cfu;
	private Borsa borsa;
	
	public Giocatore(int cfu) {
		this.cfu = cfu;
		this.borsa = new Borsa(30);
	}
	public Giocatore() {
		this(20);
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	
	public void prendiAttrezzo(Attrezzo attrezzo) {	
		this.borsa.addAttrezzo(attrezzo);
	}
		
	public void posaAttrezzo(String nomeAttrezzo) {
		this.borsa.removeAttrezzo(nomeAttrezzo);
	} 
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
}
