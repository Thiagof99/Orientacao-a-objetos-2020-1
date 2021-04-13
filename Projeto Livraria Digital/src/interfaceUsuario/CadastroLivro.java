package interfaceUsuario;

import java.awt.BorderLayout;
import controle.*;
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
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import livrariaDigital.Livro;
import javax.swing.JComboBox;
import java.awt.Color;

/**
 * Classe responsável por apresentar uma interface de cadastro de livros simples e interativa para o usuário
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */
public class CadastroLivro extends JFrame {
	
	private Principal principal;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	JComboBox comboBox = new JComboBox();
	Validacoes check = new Validacoes();
	
	private boolean cadastrado = false;
	
	public boolean isCadastrado() {
		return cadastrado;
	}

	public void setCadastrado(boolean cadastrado) {
		this.cadastrado = cadastrado;
	}

	public CadastroLivro(Principal p){
		
		principal = p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGnero = new JLabel("G\u00EAnero:");
		lblGnero.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGnero.setFont(new Font("Arial", Font.PLAIN, 15));
		lblGnero.setBounds(73, 61, 77, 27);
		contentPane.add(lblGnero);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTtulo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTtulo.setBounds(73, 98, 77, 27);
		contentPane.add(lblTtulo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(160, 98, 217, 27);
		contentPane.add(textField_1);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAutor.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAutor.setBounds(73, 135, 77, 27);
		contentPane.add(lblAutor);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(160, 135, 217, 27);
		contentPane.add(textField_2);
		
		JLabel lblEditora = new JLabel("Editora:");
		lblEditora.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEditora.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEditora.setBounds(73, 172, 77, 27);
		contentPane.add(lblEditora);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(160, 172, 217, 27);
		contentPane.add(textField_3);
		
		JLabel lblQtpginas = new JLabel("ISBN:");
		lblQtpginas.setHorizontalAlignment(SwingConstants.TRAILING);
		lblQtpginas.setFont(new Font("Arial", Font.PLAIN, 15));
		lblQtpginas.setBounds(38, 209, 112, 27);
		contentPane.add(lblQtpginas);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(160, 209, 217, 27);
		contentPane.add(textField_4);
		
		JLabel lblQtestoque = new JLabel("Qt.P\u00E1ginas:");
		lblQtestoque.setHorizontalAlignment(SwingConstants.TRAILING);
		lblQtestoque.setFont(new Font("Arial", Font.PLAIN, 15));
		lblQtestoque.setBounds(48, 246, 102, 27);
		contentPane.add(lblQtestoque);
		
		textField_5 = new JFormattedTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(160, 246, 217, 27);
		contentPane.add(textField_5);
		
		JLabel lblTelefone_1 = new JLabel("Qt.Estoque:");
		lblTelefone_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTelefone_1.setBounds(58, 283, 92, 27);
		contentPane.add(lblTelefone_1);
		
		textField_6 = new JFormattedTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(160, 283, 217, 27);
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastrar novo livro");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(160, 10, 217, 34);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_7.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") ||  
						textField_3.getText().equals("") || textField_4.getText().equals("") || textField_5.getText().equals("") || 
						textField_6.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Preencha todos os campos para cadastrar o livro", null, JOptionPane.ERROR_MESSAGE);
						}else {
						if(check.vcl(p.livraria ,textField_1.getText(), textField_4.getText())) {
				principal.cadastrarLiv(cadastrar());
				setVisible(false);
				principal.visivel();
			}
						}
			}
		});
		btnNewButton.setBounds(160, 357, 98, 46);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				principal.visivel();
			}
		});
		btnVoltar.setBounds(279, 357, 98, 46);
		contentPane.add(btnVoltar);
		
		textField_7 = new JFormattedTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(160, 320, 217, 27);
		contentPane.add(textField_7);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPreo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPreo.setBounds(10, 320, 140, 27);
		contentPane.add(lblPreo);
		
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(160, 54, 217, 32);
		contentPane.add(comboBox);
		comboBox.addItem("Infantil");
		comboBox.addItem("Técnico");
		comboBox.addItem("Ficção");
		comboBox.addItem("Não ficção");
		
	}
	/**
	 * constroi um novo obejeto Livro a partir dos parametros passados nos campos de texto
	 * @param nenhum
	 * @return Um novo objeto Livro
	 */
	public Livro cadastrar() {
		Livro livro = new Livro(comboBox.getSelectedItem().toString(), textField_1.getText(), textField_2.getText(),
				textField_3.getText(), textField_4.getText(), Integer.parseInt(textField_5.getText()),
				Integer.parseInt(textField_6.getText()), Float.parseFloat(textField_7.getText()));	
		return livro;
	}
}
