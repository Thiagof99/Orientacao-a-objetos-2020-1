package interfaceUsuario;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controle.*;
import livrariaDigital.*;
/**
 * Classe responsável por apresentar uma interface de cadastro de usuário simples e interativa para o usuário
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */
public class CadastroUsuario extends JFrame{

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private Principal principal;
	private Validacoes check = new Validacoes();
	
	public CadastroUsuario(Principal p) {
		
		principal = p;
		setBounds(100, 100, 516, 510);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(64, 61, 77, 27);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(151, 61, 217, 27);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSenha.setBounds(64, 98, 77, 27);
		getContentPane().add(lblSenha);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(151, 98, 217, 27);
		getContentPane().add(textField_1);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNome.setBounds(64, 135, 77, 27);
		getContentPane().add(lblNome);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(151, 135, 217, 27);
		getContentPane().add(textField_2);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEmail.setBounds(64, 172, 77, 27);
		getContentPane().add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(151, 172, 217, 27);
		getContentPane().add(textField_3);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEndereo.setBounds(64, 209, 77, 27);
		getContentPane().add(lblEndereo);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(151, 209, 217, 27);
		getContentPane().add(textField_4);
		
		JLabel lblTelefone = new JLabel("CPF:");
		lblTelefone.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTelefone.setBounds(64, 246, 77, 27);
		getContentPane().add(lblTelefone);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(151, 246, 217, 27);
		getContentPane().add(textField_5);
		
		JLabel lblTelefone_1 = new JLabel("Telefone:");
		lblTelefone_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTelefone_1.setBounds(64, 283, 77, 27);
		getContentPane().add(lblTelefone_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(151, 283, 217, 27);
		getContentPane().add(textField_6);
		
		JLabel lblNewLabel_1 = new JLabel("Criar nova conta");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(151, 10, 217, 34);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") ||  
					textField_3.getText().equals("") || textField_4.getText().equals("") || textField_5.getText().equals("") || 
					textField_6.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de criar sua conta", null, JOptionPane.ERROR_MESSAGE);
					}else {
					if(check.vcu(p.livraria ,textField.getText(), textField_3.getText())) {
				principal.cadastrarUsu(cadastrar());
				principal.visivel();
				setVisible(false);
			}
					}
			}
		});
		btnNewButton.setBounds(150, 320, 98, 46);
		getContentPane().add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			principal.visivel();
			}
		});
		btnVoltar.setBounds(270, 320, 98, 46);
		getContentPane().add(btnVoltar);
	}
	/**
	 * constroi um novo obejeto Cliente a partir dos parametros passados nos campos de texto
	 * @param nenhum
	 * @return Um novo objeto Cliente
	 */
	public Cliente cadastrar() {		
		Cliente c = new Cliente(textField.getText(), textField_1.getText(), textField_2.getText(),
				textField_3.getText(), textField_4.getText(), textField_5.getText(),
				Integer.parseInt(textField_6.getText()));
		return c;
	}
}
