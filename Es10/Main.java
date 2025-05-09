package Es10;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Utente utenteLoggato = null;
		String nomeFile = "file.txt";
		List<Utente> utenti = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		int seleziona;
		
		Utente utente = new Utente("Geronimo", "Stilton", "via verdi n10", "geronimostilton@gmail.com", "password123");
		utente.aggiungiAlCarrello(
		    new Prodotto("iPhone", 1000.00),
		    new Prodotto("Case", 10.00)
		);

		utenti.add(utente);
		
		do {
			System.out.print("menu:");
			System.out.print("\n1. inserisci utente");
			System.out.print("\n2. modifica utente");
			System.out.print("\n3. elimina utente");
			System.out.print("\n4. login");
			System.out.print("\n5. logout");
			System.out.print("\n6. aggiungi prodotto al carrello");
			System.out.print("\n7. mostra carrello");
			System.out.print("\nscegliere un'opzione");
			seleziona = scanner.nextInt();
			scanner.nextLine();
			
			switch(seleziona) {
			// crea utente
			case 1:
				System.out.println("nome: ");
		    	String nome = scanner.nextLine();
		    	System.out.println("cognome: ");
		    	String cognome = scanner.nextLine();
		    	System.out.println("Indirizzo: ");
		        String indirizzo = scanner.nextLine();
		        System.out.println("Email: ");
		        String email = scanner.nextLine();
		        System.out.print("Password: ");
		        String password = scanner.nextLine();
		        utenti.add(new Utente(nome, cognome, indirizzo, email, password));
				break;
				
			
		    // modifica utente
			case 2:
				System.out.print("inserire ID utente da modificare");
				int modifica = scanner.nextInt();
				scanner.nextLine();
				
				if (modifica >= 0 && modifica < utenti.size()) {
					Utente u = utenti.get(modifica);
					System.out.print("Nuovo nome (" + u.getNome() + "): ");
					String nuovoNome = scanner.nextLine();
					System.out.print("Nuovo cognome (" + u.getCognome() + "): ");
					String nuovoCognome = scanner.nextLine();
					System.out.print("Nuovo indirizzo (" + u.getIndirizzo() + "): ");
					String nuovoIndirizzo = scanner.nextLine();
					System.out.print("Nuova email (" + u.getEmail() + "): ");
					String nuovaEmail = scanner.nextLine();
					
					u.setNome(nuovoNome);
					u.setNome(nuovoCognome);
					u.setIndirizzo(nuovoIndirizzo);
					u.setEmail(nuovaEmail);
				} else {
					System.out.println("ID non valido.");
				}
				break;
				
			// elimina utente
			case 3:
			System.out.print("Inserisci l'ID dell'utente da eliminare: ");
			int indexElimina = scanner.nextInt();
			scanner.nextLine();
			if (indexElimina >= 0 && indexElimina < utenti.size()) {
			utenti.remove(indexElimina);
			System.out.println("Utente eliminato.");
			} else {
			System.out.println("Indice non valido.");
			}
			break;

			default:
			System.out.println("Opzione non valida.");
			break;
			
			case 4: // login
				if (utenteLoggato != null) {
					System.out.println("Sei già loggato come: " + utenteLoggato.getEmail());
					break;
				}

				System.out.print("Email: ");
				String loginEmail = scanner.nextLine();
				System.out.print("Password: ");
				String loginPassword = scanner.nextLine();

				boolean trovato = false;
				for (Utente u : utenti) {
					if (u.getEmail().equals(loginEmail) && u.getPassword().equals(loginPassword)) {
						utenteLoggato = u;
						trovato = true;
						System.out.println("Login riuscito! Bentornato " + u.getNome());

						// 🔽 AGGIUNGI QUESTA RIGA
						utenteLoggato.mostraCarrello();

						break;
					}
				}
				if (!trovato) {
					System.out.println("Email o password non corretti.");
				}
				break;

			case 5: // logout
				if (utenteLoggato == null) {
					System.out.println("Nessun utente è attualmente loggato.");
				} else {
					System.out.println("Logout eseguito per: " + utenteLoggato.getEmail());
					utenteLoggato = null;
				}
				break;
				
			case 6:
			    if (utenteLoggato == null) {
			        System.out.println("Devi fare il login prima.");
			        break;
			    }
			    System.out.print("Nome prodotto: ");
			    String nomeProdotto = scanner.nextLine();
			    System.out.print("Prezzo prodotto: ");
			    double prezzoProdotto = scanner.nextDouble();
			    scanner.nextLine();

			    Prodotto nuovoProdotto = new Prodotto(nomeProdotto, prezzoProdotto);
			    utenteLoggato.aggiungiAlCarrello(nuovoProdotto);
			    System.out.println("Prodotto aggiunto al carrello.");
			    break;

			case 7:
			    if (utenteLoggato == null) {
			        System.out.println("Devi fare il login prima.");
			        break;
			    }
			    utenteLoggato.mostraCarrello();
			    break;
			}

			System.out.println("\nLista utenti:");
			for (int i = 0; i < utenti.size(); i++) {
			System.out.println(i + ": " + utenti.get(i));
			}
							
			System.out.println("\nContinuare? (1 per sì, 0 per no)");
			} while (scanner.nextInt() == 1);

			scanner.close();
			}
	
}	
	
	    
	    
	    	
	        
	        
	    
	    	
	    

	
		

			
		

	
