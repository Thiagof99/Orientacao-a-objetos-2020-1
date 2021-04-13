package interfaceUsuario;
/**
 * Classe responsável por apresentar uma interface que dará acesso a todas as outras interfaces do programa, ligando todas elas, as informações apresentadas na tela
 * são alterada de acordo com o tipo de usuário que está logado no programa, fazendo com que funcionários tenham acesso a suas devidas interfaces assim como clientes
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import livrariaDigital.*;
import controle.*;
import javax.swing.ImageIcon;

public class MenuWB extends JFrame{

	private JButton btnNewButton_4 = new JButton("Login");
	private JButton btnNewButton_4_1 = new JButton("Criar conta");
	private JButton btnNewButton_3_1 = new JButton("Minha conta");
	private JButton btnNewButton_4_2 = new JButton("Logout");
	
	public MenuWB(Principal p,TelaLogin log, CadastroUsuario cadu, CadastroLivro cadl, CadastroFuncionario cadf) {
		
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setForeground(Color.LIGHT_GRAY);
		getContentPane().setForeground(Color.GREEN);
		setBounds(100, 100, 781, 533);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Livraria Virtual");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Barlow Condensed Light", Font.PLAIN, 42));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(267, 10, 245, 42);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cat\u00E1logo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Catalogo cat = new Catalogo(p);
				cat.setVisible(true);
				setVisible(false);
			}
		});
		
		btnNewButton.setBounds(61, 98, 299, 59);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar novo livro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(p.livraria.getStatus() && p.livraria.isTipoUsuario()) {
				cadl.setVisible(true);
				setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Apenas funcionários podem cadastrar novos livros");
				}
			}}
		);
		btnNewButton_1.setBounds(61, 236, 299, 59);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cadastrar Funcion\u00E1rio");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(p.livraria.getFuncionarios().size() == 0 || p.livraria.isTipoUsuario()) {
				cadf.setVisible(true);
				setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Apenas funcionários podem adicionar novos funcionários", null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(61, 305, 299, 59);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Minha cesta");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(p.livraria.getStatus() == false) {
					JOptionPane.showMessageDialog(null, "Realize o login para poder acessar sua cesta", null, JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(!p.livraria.isTipoUsuario()) {
					Cesta cesta = new Cesta(p);
					cesta.setVisible(true);
					setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "Apenas clientes tem acesso ao carrinho");
					}
				}
			}
		});
		btnNewButton_3.setBounds(61, 167, 299, 59);
		getContentPane().add(btnNewButton_3);
		
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4.setBounds(550, 98, 151, 42);
		getContentPane().add(btnNewButton_4);
		
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadu.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4_1.setBounds(550, 150, 151, 42);
		getContentPane().add(btnNewButton_4_1);
		
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(p.livraria.getStatus()) {
					if(!p.livraria.isTipoUsuario()) {
					Perfil perfil = new Perfil(p);
					perfil.setVisible(true);
					setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "Apenas clientes podem acessar seu perfil");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Realize login para acessar a sua conta", null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_3_1.setBounds(550, 150, 151, 42);
		getContentPane().add(btnNewButton_3_1);
		
		JButton btnNewButton_2_1 = new JButton("Estat\u00EDsticas da loja");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(p.livraria.isTipoUsuario()) {
				Estatisticas est = new Estatisticas(p);
				est.setVisible(true);
				setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Apenas funconários podem acessar as estatísticas da loja");
				}
			}
		});
		btnNewButton_2_1.setBounds(61, 374, 299, 59);
		getContentPane().add(btnNewButton_2_1);
		
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quit = JOptionPane.showConfirmDialog(null, "Tem certeza que quer sair da sua conta?");
				if(quit == 0) {
					p.livraria.setStatus(false);
					p.livraria.setUsuario(null);
					p.livraria.setFun(null);
					btnNewButton_4_1.setVisible(true);
					btnNewButton_4.setVisible(true);
					btnNewButton_3_1.setVisible(false);
					btnNewButton_4_2.setVisible(false);
				}
			}
		});
		btnNewButton_4_2.setBounds(550, 98, 151, 42);
		getContentPane().add(btnNewButton_4_2);
		
		JButton btnNewButton_4_1_1 = new JButton("Enviar pedidos");
		btnNewButton_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(p.livraria.isTipoUsuario()) {
					PedidosPendentes pen = new PedidosPendentes(p);
					pen.setVisible(true);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Apenas funcionários podem enviar pedidos");
				}
			}
		});
		btnNewButton_4_1_1.setBounds(550, 382, 151, 42);
		getContentPane().add(btnNewButton_4_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuWB.class.getResource("/imagens/sunb.png")));
		
		lblNewLabel_1.setBounds(59, 10, 133, 78);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MenuWB.class.getResource("/imagens/book.png")));
		lblNewLabel_2.setBounds(360, 98, 59, 59);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(MenuWB.class.getResource("/imagens/cart.png")));
		lblNewLabel_2_1.setBounds(360, 167, 59, 59);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(MenuWB.class.getResource("/imagens/profile.png")));
		lblNewLabel_2_2.setBounds(698, 121, 59, 59);
		getContentPane().add(lblNewLabel_2_2);
		
	}
	/**
	 * Altera os botões visíveis pelo usuário quando este realiza login
	 * @param nenhum
	 * @return nenhum
	 */
	public void log() {
		btnNewButton_4.setVisible(false);
		btnNewButton_4_1.setVisible(false);
		btnNewButton_3_1.setVisible(true);
		btnNewButton_4_2.setVisible(true);
	}
}
