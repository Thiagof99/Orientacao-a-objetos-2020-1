package interfaceUsuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.Principal;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
/**
 * Classe responsável por mostrar ao usuário informações da sua conta como a carteira e o histórico de compras, permitindo que altere o seu saldo e monitore seus 
 * pedidos
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */
public class Perfil extends JFrame {

	private JPanel contentPane;

	public Perfil(Principal p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Carteira");
		btnNewButton.setBounds(26, 35, 185, 57);
		contentPane.add(btnNewButton);
		
		JButton btnHistoricoDeCompras = new JButton("Historico de compras");
		btnHistoricoDeCompras.setBounds(26, 102, 185, 57);
		contentPane.add(btnHistoricoDeCompras);
		
		JButton btnVoltarAoMenu = new JButton("Voltar ao menu");
		btnVoltarAoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.visivel();
				setVisible(false);
			}
		});
		btnVoltarAoMenu.setBounds(26, 169, 185, 57);
		contentPane.add(btnVoltarAoMenu);
		
		JLabel lblNewLabel = new JLabel("Saldo atual: R$ " + Float.toString(p.livraria.getUsuario().getSaldo()));
		lblNewLabel.setBounds(232, 52, 332, 40);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		JLabel lblAdicionarSaldo = new JLabel("Digite o valor que ir\u00E1 adicionar");
		lblAdicionarSaldo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAdicionarSaldo.setBounds(178, 102, 262, 40);
		contentPane.add(lblAdicionarSaldo);
		lblAdicionarSaldo.setVisible(false);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(450, 102, 193, 40);
		contentPane.add(formattedTextField);
		formattedTextField.setVisible(false);
		
		JButton btnNewButton_1 = new JButton("Adicionar saldo");
		btnNewButton_1.setBounds(450, 152, 193, 40);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setVisible(false);
		
		String[] lista = new String[p.livraria.getUsuario().getHistoricoCompras().size()];
		for(int c=0; c<p.livraria.getUsuario().getHistoricoCompras().size(); c++) {
			lista[c] = Integer.toString(p.livraria.getUsuario().getHistoricoCompras().get(c).getCodigo());
		}
		JList list = new JList(lista);
		list.setBounds(328, 35, 232, 249);
		contentPane.add(list);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Forma de pagamento");
		comboBox.addItem("Cartão de crédito");
		comboBox.addItem("Boleto bancário");
		comboBox.addItem("Paypal");
		comboBox.addItem("Ame");
		comboBox.setBounds(450, 52, 193, 40);
		contentPane.add(comboBox);
		comboBox.setVisible(false);
		
		list.setVisible(false);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() != 0) {
				if(formattedTextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insira a quantidade que gostaria de adicionar");
				}else {
				p.livraria.getUsuario().setInfoPagamento(comboBox.getSelectedItem().toString());
				p.livraria.getUsuario().addSaldo(Float.parseFloat(formattedTextField.getText()));
				JOptionPane.showMessageDialog(null, "Saldo adicionado com sucesso");
				lblNewLabel.setText("Saldo atual: R$ " + Float.toString(p.livraria.getUsuario().getSaldo()));
				}
				}else {
					JOptionPane.showMessageDialog(null, "Selecione a forma de pagamento");
				}
			}
		});
		
		list.addListSelectionListener(e->{
			int index = list.getSelectedIndex();
			Jpedido ped = new Jpedido(p.livraria.getUsuario().getHistoricoCompras().get(index));
			ped.setVisible(true);
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.isVisible()) {
					list.setVisible(false);
				}
				lblAdicionarSaldo.setVisible(true);
				formattedTextField.setVisible(true);
				btnNewButton_1.setVisible(true);
				lblNewLabel.setVisible(true);
				comboBox.setVisible(true);
			}
		});
		btnHistoricoDeCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton_1.isVisible()) {
					lblAdicionarSaldo.setVisible(false);
					formattedTextField.setVisible(false);
					btnNewButton_1.setVisible(false);
					lblNewLabel.setVisible(false);
					comboBox.setVisible(false);
				}
				list.setVisible(true);
			}
		});
	}
}
