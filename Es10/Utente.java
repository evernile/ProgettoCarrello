package Es10;

public class Utente {
	
	private Carrello carrello = new Carrello();
	    
	    private static int contatoreId = 1;
	    private int id;
	    private String nome;
	    private String cognome;
	    private String indirizzo;
	    private String email;
	    private String password;

	    public Utente(String nome, String cognome, String indirizzo, String email, String password) {
	    	this.setId(contatoreId++);
	    	this.nome = nome;
	        this.cognome = cognome;
	        this.indirizzo = indirizzo;
	        this.email = email;
	        this.setPassword(password);
	    }

	    public String getNome() {
	        return nome;
	    }

	    public String getCognome() {
	        return cognome;
	    }

	    public String getIndirizzo() {
	        return indirizzo;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void stampa() {
	        System.out.println("Nome: " + nome);
	        System.out.println("Cognome: " + cognome);
	        System.out.println("Indirizzo: " + indirizzo);
	        System.out.println("Email: " + email);
	    }
	    
	    public void inserisciUtente() {
	    	}
	    
	    public void modificaUtente() {
	    	
	    }

		public void setNome(String nuovoNome) {
			// TODO Auto-generated method stub
			
		}
		
		public void setCognome(String nuovoCognome) {
			
		}

		public void setIndirizzo(String nuovoIndirizzo) {
			// TODO Auto-generated method stub
			
		}

		public void setEmail(String nuovaEmail) {
			// TODO Auto-generated method stub
			
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Carrello getCarrello() {
			return carrello;
		}

		public void setCarrello(Carrello carrello) {
			this.carrello = carrello;
		}
		
		public void aggiungiAlCarrello(Prodotto p) {
		    carrello.aggiungiProdotto(p);
		}

		public void mostraCarrello() {
		    carrello.mostraProdotti();
		}
		
		public void aggiungiAlCarrello(Prodotto... prodotti) {
		    for (Prodotto p : prodotti) {
		        carrello.aggiungiProdotto(p);
		    }
		}
		
		public String toString() {
		    return "ID: " + id + ", " + nome + " " + cognome + ", Email: " + email;
		}
	}


