package it.uniroma3.app.giocatore;
import java.util.*;
import it.uniroma3.app.attrezzi.Attrezzo;
import it.uniroma3.app.attrezzi.ComparatorePerNome;
import it.uniroma3.app.attrezzi.ComparatorePesoNome;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	//		COSTRUTTORE
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>(); 
		this.numeroAttrezzi = 0;
	}

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	//		METODI
	public boolean addAttrezzo(Attrezzo attrezzo) {
		numeroAttrezzi = this.attrezzi.size();
		boolean aggiunto = false;

		if(attrezzo != null) {
			if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) {
				System.out.println("La borsa è troppo pesante!");
			} else if (this.numeroAttrezzi == 10) {
				System.out.println("La borsa è piena!");
			} else {
				this.attrezzi.add(attrezzo);
				System.out.println("Attrezzo aggiunto in borsa!");
				aggiunto = true;
			}
		} else 
			System.out.println("Attrezzo non presente nella stanza!");

		return aggiunto;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		boolean rimosso = false;
		numeroAttrezzi = this.attrezzi.size();
		if(this.numeroAttrezzi == 0) {
			System.out.println("Non ci sono attrezzi nella borsa!");
			rimosso = true;
		}
		else {
			a = this.getAttrezzo(nomeAttrezzo);
			this.attrezzi.remove(a);
			System.out.println("Attrezzo posato!");
			rimosso = true;
		}
		if(!rimosso)
			System.out.println("Attrezzo non presente nella borsa!");

		return a;
	}

	public List<Attrezzo> getContenutoOrdinatoBorsa(){
		final List<Attrezzo> risultato = new ArrayList<Attrezzo>(this.attrezzi);
		Collections.sort(risultato, new ComparatorePesoNome());

		return risultato;
	}

	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		final SortedSet <Attrezzo> risultato = new TreeSet<Attrezzo>(new ComparatorePerNome());
		risultato.addAll(this.attrezzi);
		return risultato;
	}

	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		final SortedSet<Attrezzo> risultato = new TreeSet<Attrezzo>(new ComparatorePesoNome());
		risultato.addAll(this.attrezzi);
		return risultato;
	}

	public Map<Integer,Set<Attrezzo>> getContunatoRaggruppatoPerPeso(){
		final Map<Integer,Set<Attrezzo>> peso2attrezzi= new HashMap<>();
		for(Attrezzo attrezzo:this.attrezzi) {
			if(peso2attrezzi.containsKey(attrezzo.getPeso())) {
				//attrezzo di peso già visto prima
				final Set<Attrezzo> attrezziDelloStessoPeso = peso2attrezzi.get(attrezzo.getPeso());
				attrezziDelloStessoPeso.add(attrezzo);
				peso2attrezzi.put(attrezzo.getPeso(), attrezziDelloStessoPeso);

			}
			else {
				//attrezzo di peso mai visto prima
				final Set<Attrezzo> attrezziDelloStessoPeso = new HashSet<>();
				attrezziDelloStessoPeso.add(attrezzo);
				peso2attrezzi.put(attrezzo.getPeso(), attrezziDelloStessoPeso);
			}
		}
		return peso2attrezzi;
	}

	public int getPesoMax() {
		return this.pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzo = null;
		for(Attrezzo a : this.attrezzi) {
			if(a.getNome().equals(nomeAttrezzo)) {
				attrezzo = a;
			}
		}		
		return attrezzo;
	}

	public int getPeso() {
		int peso = 0;
		for(Attrezzo a : this.attrezzi) {
			peso += a.getPeso();
		}
		return peso;
	}

	public boolean isEmpty() {
		return this.attrezzi.size() == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}


	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo a:this.attrezzi)
				s.append(a.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}