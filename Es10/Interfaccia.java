package Es10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Interfaccia extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Utente> utenti = new ArrayList<>();
    private JTextField emailField;
    private JPasswordField passwordField;

    public Interfaccia() {
        setTitle("Login Utente");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Registrati");

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);

        add(panel);

        
        Utente testUtente = new Utente("Elisabetta", "Vernile", "via verdi n10", "elisabetta@gmail.com", "1234");
        testUtente.aggiungiAlCarrello(
                new Prodotto("iPhone", 1000.00),
                new Prodotto("Case", 10.00)
        );
        utenti.add(testUtente);

        
        loginButton.addActionListener(e -> {
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword());

            Utente loggato = null;
            for (Utente u : utenti) {
                if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                    loggato = u;
                    break;
                }
            }

            if (loggato != null) {
                JOptionPane.showMessageDialog(Interfaccia.this,
                        "Login riuscito! Bentornato " + loggato.getNome());

                
                loggato.mostraCarrello();
            } else {
                JOptionPane.showMessageDialog(Interfaccia.this,
                        "Email o password errati.", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        });

        
        registerButton.addActionListener(_ -> {
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword());

            for (Utente u : utenti) {
                if (u.getEmail().equals(email)) {
                    JOptionPane.showMessageDialog(Interfaccia.this,
                            "Email già registrata.", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            String nome = JOptionPane.showInputDialog("Nome:");
            String cognome = JOptionPane.showInputDialog("Cognome:");
            String indirizzo = JOptionPane.showInputDialog("Indirizzo:");

            Utente nuovo = new Utente(nome, cognome, indirizzo, email, password);
            utenti.add(nuovo);

            JOptionPane.showMessageDialog(Interfaccia.this,
                    "Registrazione completata! Ora puoi fare login.");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interfaccia().setVisible(true));
    }
}
