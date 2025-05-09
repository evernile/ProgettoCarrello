package Es10;

import java.util.*;
public class Prodotti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap <String, Double> Prodotti = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("numero di prodotti da inserire");
		int n = scanner.nextInt();
		scanner.nextLine();
		
		for (int i = 0; i < n; i++) {
			System.out.print("inserire il nome del prodotto: ");
			String nomeProdotto = scanner.nextLine();
			
			System.out.print("inserire il prezzo del prodotto: ");
			double prezzoProdotto = scanner.nextDouble();
			scanner.nextLine();
			
			Prodotti.put(nomeProdotto, prezzoProdotto);
		
		}
		
		System.out.print("Soglia di prezzo: ");
		double soglia = scanner.nextDouble();
		
		System.out.println("Prodotti con prezzo superiore alla soglia " + soglia + " ");
		
		for (Map.Entry<String, Double> entry : Prodotti.entrySet()) {
            if (entry.getValue() > soglia) {
                System.out.println("- " + entry.getKey() + ": €" + entry.getValue());
            }
        }
		
		double somma = 0;
        for (double prezzo : Prodotti.values()) {
            somma += prezzo;
        }

        double media = (Prodotti.size() > 0) ? somma / Prodotti.size() : 0;
        System.out.printf("\nPrezzo medio: €%.2f\n", media);

        scanner.close();
		}

}
