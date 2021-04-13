package interfaceUsuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import livrariaDigital.*;
import controle.*;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
/**
 * Classe responsável por mostrar as estatísticas da loja para os funcionários, permitindo que vejam as estatísticas de cada objeto adicionado ao programa 
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */
public class Estatisticas extends JFrame {

	private JPanel contentPane;

	public Estatisticas(Principal p) {
		
		System.out.println(p.livraria.getClientes().size());
		String[] lv = new String[p.livraria.getCatalogo().size()];
		String[] cf = new String[p.livraria.getClientes().size()];
		String[] pr = new String[p.livraria.getEstatisticas().getPedidos().size()];
		
		for(int c=0; c<p.livraria.getCatalogo().size(); c++) {
			lv[c] = p.livraria.getCatalogo().get(c).getTitulo();
		}
		for(int c=0; c<p.livraria.getClientes().size(); c++) {
			cf[c] = p.livraria.getClientes().get(c).getNome();
		}
		for(int c=0; c<p.livraria.getEstatisticas().getPedidos().size(); c++) {
			pr[c] = Integer.toString(p.livraria.getEstatisticas().getPedidos().get(c).getCodigo()); 
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Lista de livros");
		
		btnNewButton.setBounds(10, 47, 185, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lista de clientes");
		
		btnNewButton_1.setBounds(10, 114, 185, 57);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Pedidos realizados");

		btnNewButton_2.setBounds(10, 181, 185, 57);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Pagamentos efetuados");
		btnNewButton_3.setBounds(10, 248, 185, 57);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Voltar ao menu");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				p.visivel();
				
			}
		});
		btnNewButton_3_1.setBounds(10, 315, 185, 57);
		contentPane.add(btnNewButton_3_1);
		
		JList list = new JList(lv);
		list.setBounds(251, 47, 210, 324);
		contentPane.add(list);
		list.setVisible(false);
		
		JList list2 = new JList(cf);
		list2.setBounds(251, 47, 210, 324);
		contentPane.add(list2);
		list2.setVisible(false);
		
		JList list3 = new JList(pr);
		list3.setBounds(251, 47, 210, 324);
		contentPane.add(list3);
		list3.setVisible(false);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(495, 114, 191, 57);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(495, 181, 191, 57);
		contentPane.add(lblNewLabel_1);
		
		String[] pag = new String[p.livraria.getEstatisticas().getPedidos().size()];
		float pti = 0;
		for(int c=0; c<p.livraria.getEstatisticas().getPedidos().size(); c++) {
			pag[c] = Float.toString(p.livraria.getEstatisticas().getPedidos().get(c).getValor());
			pti = pti + p.livraria.getEstatisticas().getPedidos().get(c).getValor();
		}
		float pt = pti;
		JList list_1 = new JList(pag);
		list_1.setBounds(251, 47, 210, 324);
		contentPane.add(list_1);
		list_1.setVisible(false);
		lblNewLabel_1.setVisible(false);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			list_1.setVisible(false);
			list3.setVisible(false);
			list2.setVisible(false);
			list.setVisible(true);
			lblNewLabel.setVisible(false);
			lblNewLabel_1.setVisible(false);	
			
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			list_1.setVisible(false);
			list.setVisible(false);
			list3.setVisible(false);
			list2.setVisible(true);
			lblNewLabel.setVisible(false);
			lblNewLabel_1.setVisible(false);
			}
		});
		list.addListSelectionListener(e->{
			lblNewLabel.setText("Total de unidades vendidas");
			lblNewLabel.setVisible(true);
			lblNewLabel_1.setText(Integer.toString(p.livraria.getCatalogo().get(list.getSelectedIndex()).getUnidadesVendidas()));
			lblNewLabel_1.setVisible(true);
		});
		list2.addListSelectionListener(e->{
			lblNewLabel.setText("Total de pedidos realizados");
			lblNewLabel.setVisible(true);
			lblNewLabel_1.setText(Integer.toString(p.livraria.getClientes().get(list2.getSelectedIndex()).getHistoricoCompras().size()));
			lblNewLabel_1.setVisible(true);
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			list_1.setVisible(false);
			list.setVisible(false);
			list3.setVisible(true);
			list2.setVisible(false);
			lblNewLabel.setVisible(false);
			lblNewLabel_1.setVisible(false);
			}
		});
		list3.addListSelectionListener(e->{
			lblNewLabel.setText("Valor total do pedido");
			lblNewLabel.setVisible(true);
			lblNewLabel_1.setText(Float.toString(p.livraria.getEstatisticas().getPedidos().get(list3.getSelectedIndex()).getCesta().getPrecoTotal()));
			lblNewLabel_1.setVisible(true);
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list_1.setVisible(true);
				list.setVisible(false);
				list3.setVisible(false);
				list2.setVisible(false);
				lblNewLabel.setText("Lucro total da loja");
				lblNewLabel.setVisible(true);
				lblNewLabel_1.setText(Float.toString(pt) + " R$");
				lblNewLabel_1.setVisible(true);
			}
		});
	}
}
