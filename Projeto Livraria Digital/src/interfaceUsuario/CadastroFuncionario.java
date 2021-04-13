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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controle.*;
import livrariaDigital.*;
/**
 * Classe responsável por apresentar uma interface de cadastro de funcionários simples e interativa para o usuário
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */
public class CadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private Principal principal;
	private Validacoes check = new Validacoes();
	
	public CadastroFuncionario(Principal p) {
		
		principal = p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(73, 61, 77, 27);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(160, 61, 217, 27);
		contentPane.add(textField);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSenha.setBounds(73, 98, 77, 27);
		contentPane.add(lblSenha);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(160, 98, 217, 27);
		contentPane.add(textField_1);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNome.setBounds(73, 135, 77, 27);
		contentPane.add(lblNome);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(160, 135, 217, 27);
		contentPane.add(textField_2);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEmail.setBounds(73, 172, 77, 27);
		contentPane.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(160, 172, 217, 27);
		contentPane.add(textField_3);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEndereo.setBounds(73, 209, 77, 27);
		contentPane.add(lblEndereo);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(160, 209, 217, 27);
		contentPane.add(textField_4);
		
		JLabel lblTelefone = new JLabel("CPF:");
		lblTelefone.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTelefone.setBounds(73, 246, 77, 27);
		contentPane.add(lblTelefone);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(160, 246, 217, 27);
		contentPane.add(textField_5);
		
		JLabel lblTelefone_1 = new JLabel("Telefone:");
		lblTelefone_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTelefone_1.setBounds(73, 283, 77, 27);
		contentPane.add(lblTelefone_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(160, 283, 217, 27);
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastrar novo funcion\u00E1rio");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(160, 10, 217, 34);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_9.getText().equals("") ||  
					textField_3.getText().equals("") || textField_4.getText().equals("") || textField_5.getText().equals("") || 
					textField_6.getText().equals("") || textField_7.getText().equals("") || textField_8.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de criar sua conta", null, JOptionPane.ERROR_MESSAGE);
				}else {
				if(check.vcu(p.livraria ,textField.getText(), textField_3.getText(), textField_7.getText())) {
				principal.cadastrarFun(cadastrar());
				principal.visivel();
				setVisible(false);
				}
				}
			}
		});
		btnNewButton.setBounds(160, 431, 98, 46);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				principal.visivel();
			}
		});
		btnVoltar.setBounds(279, 431, 98, 46);
		contentPane.add(btnVoltar);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(160, 320, 217, 27);
		contentPane.add(textField_7);
		
		JLabel lblCdidentificao = new JLabel("C\u00F3d.Identifica\u00E7\u00E3o:");
		lblCdidentificao.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCdidentificao.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCdidentificao.setBounds(10, 320, 140, 27);
		contentPane.add(lblCdidentificao);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(160, 357, 217, 27);
		contentPane.add(textField_8);
		
		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o:");
		lblFuno.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFuno.setFont(new Font("Arial", Font.PLAIN, 15));
		lblFuno.setBounds(73, 357, 77, 27);
		contentPane.add(lblFuno);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(160, 394, 217, 27);
		contentPane.add(textField_9);
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio:");
		lblSalrio.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSalrio.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSalrio.setBounds(73, 394, 77, 27);
		contentPane.add(lblSalrio);
	}
	/**
	 * constroi um novo obejeto Funcionario a partir dos parametros passados nos campos de texto
	 * @param nenhum
	 * @return Um novo objeto Funcionario
	 */
	public Funcionario cadastrar() {		
		Funcionario f = new Funcionario(textField.getText(), textField_1.getText(), textField_2.getText(),
				textField_3.getText(), textField_4.getText(), textField_5.getText(),
				Integer.parseInt(textField_6.getText()), textField_7.getText(), textField_8.getText(), Float.parseFloat(textField_9.getText()));
		return f;
	}
}
