package interfaceUsuario;

import java.awt.BorderLayout;
import livrariaDigital.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controle.*;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
/**
 * Classe responsável por mostrar a cesta de compras do usuário, mostrando informações dos produtos adicionados e permitindo que produtos não desejados sejam
 * removidos da cesta. Também permite que seja feito um novo pedido caso este atenda as condições necessárias
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */
 class Cesta extends JFrame {

	private JPanel contentPane;

	public Cesta(Principal p) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel dm = new DefaultListModel();
		String[] livros = new String[p.livraria.getUsuario().getCesta().getQtLivros()];
		for(int c=0; c<p.livraria.getUsuario().getCesta().getQtLivros(); c++) {
			livros[c] = p.livraria.getUsuario().getCesta().getLivros().get(c).getTitulo();
			dm.addElement(livros[c]);
		}
		JLabel lblNewLabel_4 = new JLabel("Saldo atual: " + Float.toString(p.livraria.getUsuario().getSaldo()) + " R$");
		
		JList list = new JList();
		list.setBounds(35, 46, 239, 380);
		list.setModel(dm);
		contentPane.add(list);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(321, 328, 239, 36);
		contentPane.add(formattedTextField);
		
		JButton btnNewButton_1 = new JButton("Realizar pedido");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Adicione pelo menos um livro a sua cesta para prosseguir com a compra", null, JOptionPane.ERROR_MESSAGE);
				}else {
				if(formattedTextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insira o CEP para qual o pedido será enviado");
				}else {
				int end = JOptionPane.showConfirmDialog(null, "O pedido será enviado para: " + p.livraria.getUsuario().getEndereco() + ". Gostaria de alterar?");
				if(end == 0) {
				p.livraria.getUsuario().setEndereco(JOptionPane.showInputDialog("Insira o endereço para onde o pedido será enviado"));
				}
				if(p.livraria.getUsuario().getCesta().getPrecoTotal() <= p.livraria.getUsuario().getSaldo()) {
				for(int c=0; c<p.livraria.getUsuario().getCesta().getQtLivros(); c++){
					for(int j = 0; j < p.livraria.getCatalogo().size(); j++) {
						if(p.livraria.getCatalogo().get(j).equals(p.livraria.getUsuario().getCesta().getLivros().get(c))) {
							p.livraria.getCatalogo().get(j).venderUnidade();
						}
					}
				}
				p.livraria.getUsuario().setSaldo(p.livraria.getUsuario().getSaldo() - p.livraria.getUsuario().getCesta().getPrecoTotal());
				Pedido pedido = new Pedido("Pendente", p.livraria.getUsuario().getCesta(),
						p.livraria.getUsuario().getCesta().getLivros(), p.livraria.getUsuario().getCesta().getPrecoTotal());
				pedido.getCesta().setCepEnvio(Integer.parseInt(formattedTextField.getText()));
				p.livraria.getUsuario().addHistorico(pedido);
				p.livraria.getEstatisticas().addPedido(pedido);
				JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso");
				lblNewLabel_4.setText("Saldo atual: " + Float.toString(p.livraria.getUsuario().getSaldo()) + " R$");
				Jpedido notinha = new Jpedido(pedido);
				notinha.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Saldo insuficiente", null, JOptionPane.ERROR_MESSAGE);
				}
				}
			}
			}
		});
		btnNewButton_1.setBounds(321, 374, 239, 52);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Voltar ao menu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.visivel();
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(468, 10, 118, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("CEP de envio");
		lblNewLabel.setBounds(321, 297, 130, 21);
		contentPane.add(lblNewLabel);	
		
		JLabel lblNewLabel_1 = new JLabel("Pre\u00E7o total");
		lblNewLabel_1.setBounds(321, 169, 102, 27);
		contentPane.add(lblNewLabel_1);
			
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_2.setText(Float.toString(p.livraria.getUsuario().getCesta().getPrecoTotal()));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(321, 206, 239, 81);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pre\u00E7o do livro");
		lblNewLabel_1_1.setBounds(321, 46, 102, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("XXX");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_2_1.setBounds(321, 83, 239, 81);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton_1_1 = new JButton("Limpar cesta");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.livraria.getUsuario().getCesta().getLivros().clear();
				dm.clear();
				list.setModel(dm);
				lblNewLabel_2.setText(Float.toString(p.livraria.getUsuario().getCesta().getPrecoTotal()));
			}
		});
		btnNewButton_1_1.setBounds(156, 436, 118, 52);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Remover livro");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "Selecione o livro que gostaria de remover", null, JOptionPane.ERROR_MESSAGE);
				}else {
					int index = list.getSelectedIndex();
					p.livraria.getUsuario().getCesta().getLivros().remove(index);
					dm.remove(index);
					list.setModel(dm);
					lblNewLabel_2.setText(Float.toString(p.livraria.getUsuario().getCesta().getPrecoTotal()));
				}
		}
		});
		btnNewButton_1_1_1.setBounds(35, 436, 118, 52);
		contentPane.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Livros");
		lblNewLabel_3.setBounds(35, 10, 118, 21);
		contentPane.add(lblNewLabel_3);
		
		
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4.setBounds(321, 436, 239, 52);
		contentPane.add(lblNewLabel_4);
		
		list.addListSelectionListener(e->{
			int index = list.getSelectedIndex();
			if(index == -1) {
				lblNewLabel_2_1.setText("xxx");
			}else {
			lblNewLabel_2_1.setText("R$" + Float.toString(p.livraria.getUsuario().getCesta().getLivros().get(index).getPreco()));
			}
		});
	}
}
