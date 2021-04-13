package interfaceUsuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import controle.*;
import java.awt.Font;
import javax.swing.SwingConstants;
/**
 * Classe responsável por mostrar aos funcionários quais pedidos devem ser enviados e permitindo que estes enviem os pedidos aos clientes, notificando os mesmos
 * que o pedido foi enviado
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */
public class PedidosPendentes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public PedidosPendentes(Principal p) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel<Integer> model = new DefaultListModel<Integer>();
		
		textField = new JTextField();
		textField.setBounds(310, 359, 139, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Enviar pedido");
		btnNewButton.setBounds(310, 407, 139, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblCompanhiaDeEntrega = new JLabel("Companhia de entrega");
		lblCompanhiaDeEntrega.setBounds(310, 327, 139, 22);
		contentPane.add(lblCompanhiaDeEntrega);
		
		JList<Integer> list = new JList<Integer>();
		list.setBounds(35, 58, 242, 387);
		contentPane.add(list);
		
		ArrayList<Integer> indpen = new ArrayList<Integer>();
		for(int c=0; c<p.livraria.getEstatisticas().getPedidos().size(); c++) {
			if(p.livraria.getEstatisticas().getPedidos().get(c).getStatus().equals("Pago")) {
			indpen.add(c);
			model.addElement(p.livraria.getEstatisticas().getPedidos().get(c).getCodigo());
			}
		}
		list.setModel(model);
		
		JLabel lblPedidosPendentes = new JLabel("Pedidos pendentes");
		lblPedidosPendentes.setBounds(35, 26, 139, 22);
		contentPane.add(lblPedidosPendentes);
		
		JButton btnNewButton_1 = new JButton("Voltar ao menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.visivel();
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(350, 10, 112, 27);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("CEP do destino");
		lblNewLabel.setBounds(310, 180, 112, 22);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(310, 212, 139, 59);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o pedido que irá enviar");
				}else {
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe a companhia responsável pela entrega");
				}else {
					p.livraria.getEstatisticas().getPedidos().get(indpen.get(list.getSelectedIndex())).setCompanhiaEntrega(textField.getText());
					p.livraria.getEstatisticas().getPedidos().get(indpen.get(list.getSelectedIndex())).setStatus(1);
					model.remove(list.getSelectedIndex());
					JOptionPane.showMessageDialog(null, "Pedido enviado com sucesso");
				}
			}
				
			}
		});
		list.addListSelectionListener(e->{
			if(list.getSelectedIndex() == -1) {
				lblNewLabel_1.setText("");
				lblNewLabel.setVisible(false);
			}else {
				lblNewLabel.setVisible(true);
				lblNewLabel_1.setText(Integer.toString(p.livraria.getEstatisticas().getPedidos().get(list.getSelectedIndex()).getCesta().getCepEnvio()));
			}
		});
	}
}
