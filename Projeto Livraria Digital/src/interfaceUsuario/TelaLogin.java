package interfaceUsuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controle.*;
/**
 * Classe responsável por permitir os usuários acessarem suas contas, caso as informações inseridas estejam cadastradas na livraria,
 *  o usuário poderá navegar pelas paginas destinadas ao seu tipo de conta, cliente ou funcionário 
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */
public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Principal principal;

	public TelaLogin(Principal p) {
		
		principal = p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(98, 64, 77, 27);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(185, 64, 217, 27);
		contentPane.add(textField);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSenha.setBounds(98, 101, 77, 27);
		contentPane.add(lblSenha);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				principal.visivel();
			}
		});
		btnVoltar.setBounds(304, 138, 98, 46);
		contentPane.add(btnVoltar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(185, 101, 217, 27);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = passwordField.getText();
				p.realizarLogin(textField.getText(), s);
				if(p.livraria.getStatus()) {
					p.visivel();
					setVisible(false);
				}
			}
		});
		btnLogin.setBounds(185, 138, 98, 46);
		contentPane.add(btnLogin);
	}
}
