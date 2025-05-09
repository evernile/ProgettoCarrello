package Es10;

import java.io.Serializable;

public class Prodotto implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
    private double prezzo;

    public Prodotto(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

}
