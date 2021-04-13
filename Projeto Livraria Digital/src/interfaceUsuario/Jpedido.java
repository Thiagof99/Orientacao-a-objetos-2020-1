package interfaceUsuario;

import java.awt.BorderLayout;
import livrariaDigital.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Esta classe faz o papel de um nota fiscal, permitindo que o usuário veja e acompanhe as informações do seu pedido, além disso permite ao usuário monitorar
 * o status do seu pedido assim como confirmar a loja se o pedido foi entregue
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */
public class Jpedido extends JFrame {

	private JPanel contentPane;

	public Jpedido(Pedido p) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] livros = new String[p .getLivros().size()];
		for(int c=0; c<p .getLivros().size(); c++) {
			livros[c] = p .getLivros().get(c).getTitulo();
		}
		JList list = new JList(livros);
		list.setBounds(35, 133, 247, 316);
		contentPane.add(list);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(35, 53, 368, 31);
		contentPane.add(progressBar);
		if(p.getStatus().equals("Pago")) {
			progressBar.setValue(5);
		}else if(p.getStatus().equals("Enviado")) {
			progressBar.setValue(30);
		}else if(p.getStatus().equals("Recebido")) {
			progressBar.setValue(100);
		}
		
		JLabel lblNewLabel = new JLabel("Pago");
		lblNewLabel.setBounds(35, 23, 79, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enviado");
		lblNewLabel_1.setBounds(124, 23, 207, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Recebido");
		lblNewLabel_2.setBounds(341, 23, 62, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("livros");
		lblNewLabel_3.setBounds(35, 103, 79, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Valor total");
		lblNewLabel_4.setBounds(292, 283, 111, 26);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("R$ " + Float.toString(p.getValor()));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(292, 319, 134, 80);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Confirmar recebimento");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setPendente(false);
				p.setStatus(2);
				JOptionPane.showMessageDialog(null, "Agradecemos por confirmar a entrega");
				progressBar.setValue(100);
			}
		});
		btnNewButton.setBounds(35, 459, 172, 69);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(231, 459, 172, 69);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_5_1 = new JLabel(Integer.toString(p.getCodigo()));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1.setBounds(292, 193, 134, 80);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("C\u00F3digo do pedido");
		lblNewLabel_4_1.setBounds(292, 157, 111, 26);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_6 = new JLabel("Entrega: " + p.getCompanhiaEntrega());
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6.setBounds(189, 85, 214, 20);
		contentPane.add(lblNewLabel_6);
	}
}
