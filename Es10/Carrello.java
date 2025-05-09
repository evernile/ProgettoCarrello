package Es10;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Carrello implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Prodotto> prodotti;

    public Carrello() {
        this.prodotti = new ArrayList<>();
    }

    public void aggiungiProdotto(Prodotto p) {
        prodotti.add(p);
    }

    public void mostraProdotti() {
        if (prodotti.isEmpty()) {
            System.out.println("Carrello vuoto.");
        } else {
            System.out.println("Contenuto del carrello:");
            for (Prodotto p : prodotti) {
                System.out.println("- " + p);
            }
            System.out.printf("Totale: €%.2f\n", getTotale());
        }
    }

    public double getTotale() {
        double totale = 0;
        for (Prodotto p : prodotti) {
            totale += p.getPrezzo();
        }
        return totale;
    }
}
