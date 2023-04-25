package it.uniroma3.app.comandi;
import java.util.Scanner;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
	
	String nomeComando;
	String parametro;
	Comando comando;
	
	public FabbricaDiComandiFisarmonica() {
		nomeComando = null;
		parametro = null;
		comando = null;
	}
	
	@Override
	public Comando costruisciComando(String istruzione) {
		
		Scanner scannerDiParole = new Scanner(istruzione);
		
		//	LETTURA COMANDO
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();// prima parola: nome del comando
		
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // seconda parola: eventuale param.
		
		//	SCELTA COMANDO
		if (nomeComando == null) 
			comando = new ComandoNonValido();
		else if (nomeComando.equals("vai"))
			comando = new ComandoVai();
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi();
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa();
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto();
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda();
		else comando = new ComandoNonValido();
		comando.setParametro(parametro);
		return comando;
	}
	
	public String getNome() {
		return this.nomeComando;
	}
	
	public String getParametro() {
		return this.parametro;
	}
}
