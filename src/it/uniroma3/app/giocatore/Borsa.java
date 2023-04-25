package it.uniroma3.app.giocatore;
import it.uniroma3.app.attrezzi.Attrezzo;

public class Borsa {


	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	//		COSTRUTTORE
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; 
		this.numeroAttrezzi = 0;
	}

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	//		METODI
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo != null) {
			if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) {
				System.out.println("La borsa è troppo pesante!");
				return false;
			}
			if (this.numeroAttrezzi==10) {
				System.out.println("La borsa è piena!");
				return false;
			}

			this.attrezzi[this.numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			System.out.println("Attrezzo aggiunto in borsa!");
			return true;
		}
		return false;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		boolean rimosso = false;
		if(this.numeroAttrezzi == 0) {
			System.out.println("Non ci sono attrezzi nella borsa!");
			rimosso = true;
		}
		else {
			for(int i = 0; i < this.numeroAttrezzi; i++) {
				if (attrezzi[i] != null) {
					if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
						a = attrezzi[i];
						attrezzi[i] = attrezzi[i+1];
						System.out.println("Attrezzo rimosso dalla borsa!");
						this.numeroAttrezzi--;
						rimosso = true;
					}
				}
			}
		}
		if(!rimosso)
			System.out.println("Attrezzo non presente nella borsa!");

		return a;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i = 0; i < this.numeroAttrezzi; i++)
			if (attrezzi[i] != null) {
				if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
					a = attrezzi[i];
			}

		return a;
	}

	public int getPeso() {
		int peso = 0;
		for (int i = 0; i < this.numeroAttrezzi; i++) {
			if (attrezzi[i] != null) {
				peso += this.attrezzi[i].getPeso();
			}
		}

		return peso;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}


	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i = 0; i < this.numeroAttrezzi; i++) {
				if(attrezzi[i] != null) {
					s.append(attrezzi[i].toString()+" ");
				}
			}
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}