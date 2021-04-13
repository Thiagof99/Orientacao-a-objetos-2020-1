package interfaceUsuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import livrariaDigital.*;
import controle.*;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
/**
 * Classe responsável por apresentar os livros cadastrados na livraria ao usuário,
 * permitindo uma busca simples pelo livro desejado e permitindo também que este seja adicionado na cesta do usuário.
 * Caso o usuário que esteja navegando pela classe seja um funcionário, ele pode alterar informações do livro selecionado
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */
public class Catalogo extends JFrame {

	private JPanel contentPane;
	private Principal principal;
	JButton btnNewButton_1 = new JButton("Adicionar ao carrinho");
	JSpinner spinner = new JSpinner();
	ArrayList<Livro> livrosExibidos = new ArrayList<Livro>();
	JComboBox comboBox = new JComboBox();
	private JTextField textField;
	
	public Catalogo(Principal p) {
		
		int busca = 0;
		principal = p;
		DefaultListModel model = new DefaultListModel();
		DefaultListModel model1 = new DefaultListModel();
		ArrayList<Livro> livrosExibidos1 = new ArrayList<Livro>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Livros");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(29, 36, 118, 23);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Selecione um livro para mais informa\u00E7\u00F5es");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(373, 223, 259, 86);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Voltar ao menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.visivel();
				setVisible(false);
			}
		});
		btnNewButton.setBounds(567, 12, 118, 21);
		contentPane.add(btnNewButton);

		String[] titulos = new String[principal.livraria.getCatalogo().size()];
		for (int c = 0; c < titulos.length; c++) {
			titulos[c] = principal.livraria.getCatalogo().get(c).getTitulo();
			model.addElement(titulos[c]);
			model1.addElement(titulos[c]);
			livrosExibidos.add(principal.livraria.getCatalogo().get(c));
			livrosExibidos1.add(principal.livraria.getCatalogo().get(c));
		}
		JList list = new JList();
		list.setModel(model);
		list.setFont(new Font("Arial", Font.PLAIN, 15));
		list.setBounds(29, 143, 217, 346);
		contentPane.add(list);

		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(315, 95, 317, 40);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setBounds(315, 145, 317, 40);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel();
		lblNewLabel_2_1_1.setBounds(315, 245, 317, 40);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setBounds(315, 195, 317, 40);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_1_2 = new JLabel();
		lblNewLabel_2_1_2.setBounds(315, 345, 317, 40);
		contentPane.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_2_3 = new JLabel();
		lblNewLabel_2_3.setBounds(315, 295, 317, 40);
		contentPane.add(lblNewLabel_2_3);

		
		btnNewButton_1.setBounds(540, 460, 145, 31);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setVisible(false);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setBounds(364, 460, 126, 31);
		contentPane.add(lblNewLabel_3);

		spinner.setBounds(500, 463, 37, 23);
		contentPane.add(spinner);

		JLabel lblNewLabel_4 = new JLabel("Fa\u00E7a login para poder comprar o Livro");
		lblNewLabel_4.setBounds(500, 460, 185, 31);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("Alterar preço");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String np = JOptionPane.showInputDialog("Novo preço");
				principal.livraria.getCatalogo().get(list.getSelectedIndex()).setPreco(Float.parseFloat(np));
				lblNewLabel_3.setText(Float.toString(principal.livraria.getCatalogo().get(list.getSelectedIndex()).getPreco()) + "R$");
			}
		});
		btnNewButton_2.setBounds(540, 460, 145, 31);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Alterar estoque");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ne = JOptionPane.showInputDialog("Novo estoque");
				principal.livraria.getCatalogo().get(list.getSelectedIndex()).setQtEstoque(Integer.parseInt(ne));
			}
		});
		btnNewButton_3.setBounds(540, 419, 145, 31);
		contentPane.add(btnNewButton_3);
		
		comboBox.setBounds(29, 110, 217, 31);
		contentPane.add(comboBox);
		comboBox.addItem("Todos os livros");
		comboBox.addItem("Infantil");
		comboBox.addItem("Técnico");
		comboBox.addItem("Ficção");
		comboBox.addItem("Não ficção");
		
		textField = new JTextField();
		textField.setBounds(29, 69, 139, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Busca");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Insira algo no campo de busca");
				}else {
					model.clear();
					livrosExibidos.clear();
					for(int c=0; c<p.livraria.getCatalogo().size(); c++) {
						if(p.livraria.getCatalogo().get(c).getTitulo().contains(textField.getText()) ||
								p.livraria.getCatalogo().get(c).getAutor().contains(textField.getText())||
								p.livraria.getCatalogo().get(c).getEditora().contains(textField.getText())||
								p.livraria.getCatalogo().get(c).getIsbn().contains(textField.getText())) {
							model.addElement(p.livraria.getCatalogo().get(c).getTitulo());
							livrosExibidos.add(p.livraria.getCatalogo().get(c));
						}
					}
					list.setModel(model);
				}
			}
		});
		btnNewButton_4.setBounds(168, 69, 76, 31);
		contentPane.add(btnNewButton_4);

		comboBox.addActionListener(e->{
			if(comboBox.getSelectedIndex() == 0) {
				list.setModel(model1);
				livrosExibidos.clear();
				for(int c=0; c<livrosExibidos1.size(); c++) {
					livrosExibidos.add(livrosExibidos1.get(c));
				}
			}else{
				model.clear();
				livrosExibidos.clear();
				for(int c=0; c<p.livraria.getCatalogo().size(); c++) {
					if(p.livraria.getCatalogo().get(c).getGenero().equals(comboBox.getSelectedItem())) {
						model.addElement(p.livraria.getCatalogo().get(c).getTitulo());
						livrosExibidos.add(p.livraria.getCatalogo().get(c));
					}
				}
				
				list.setModel(model);
			}
		});
		btnNewButton_3.setVisible(false);
		btnNewButton_2.setVisible(false);
		
		lblNewLabel_4.setVisible(false);
		spinner.setVisible(false);
		
		btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					addCarrinho(list.getSelectedIndex());
					}});
		
		list.addListSelectionListener(e -> {
			
			int index = list.getSelectedIndex();
			if(index == -1) {
				lblNewLabel_1.setVisible(true);
				btnNewButton_2.setVisible(false);
				btnNewButton_3.setVisible(false);
				btnNewButton_1.setVisible(false);
				spinner.setVisible(false);
				lblNewLabel_2.setText("");
				lblNewLabel_2_1.setText("");
				lblNewLabel_2_1_1.setText("");
				lblNewLabel_2_2.setText("");
				lblNewLabel_2_1_2.setText("");
				lblNewLabel_2_3.setText("");
				lblNewLabel_3.setText("");
			}else {
			lblNewLabel_2.setText("Título: " + livrosExibidos.get(index).getTitulo());
			lblNewLabel_2_1.setText("Autor: " + livrosExibidos.get(index).getAutor());
			lblNewLabel_2_1_1.setText("Gênero: " + livrosExibidos.get(index).getGenero());
			lblNewLabel_2_2.setText(
					"Páginas: " + Integer.toString(livrosExibidos.get(index).getQtPaginas()));
			lblNewLabel_2_1_2.setText("Editora: " + principal.livraria.getCatalogo().get(index).getEditora());
			lblNewLabel_2_3.setText("ISBN: " + livrosExibidos.get(index).getIsbn());
			lblNewLabel_3.setText(Float.toString(livrosExibidos.get(index).getPreco()) + "R$");
			lblNewLabel_1.setVisible(false);
			if (principal.livraria.getStatus()) {
				if(!principal.livraria.isTipoUsuario()) {
				btnNewButton_1.setVisible(true);
				spinner.setVisible(true);
				}else {
					btnNewButton_2.setVisible(true);
					btnNewButton_3.setVisible(true);
				}
			} else {
				lblNewLabel_4.setVisible(true);
			}
			}	
		});
		
	}
	/**
	 * Adiciona o livro e a quantidade deste selecionados pelo usuário na sua cesta
	 * @param um inteiro que representa o index do livro selecionado no catalogo
	 * @return nenhum
	 */
	public void addCarrinho(int i) {
				if (Integer.parseInt(spinner.getValue().toString()) == 0) {
					JOptionPane.showMessageDialog(null, "Insira quantos deste livro quer adicionar a cesta");
				} else {
					if(livrosExibidos.get(i).getQtEstoque() < Integer.parseInt(spinner.getValue().toString())) {
						JOptionPane.showMessageDialog(null, "A quantidade selecionada não está disponível em nosso estoque");
					}else {
					for (int c = 0; c < Integer.parseInt(spinner.getValue().toString()); c++) {
						principal.livraria.getUsuario().getCesta()
								.addLivro(livrosExibidos.get(i));
					}
					JOptionPane.showMessageDialog(null, "Livro(s) adicionado(s) a cesta com sucesso");
					}
				}
			}
	}

