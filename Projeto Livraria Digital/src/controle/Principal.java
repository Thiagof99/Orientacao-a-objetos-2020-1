package controle;

import interfaceUsuario.*;
import livrariaDigital.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 * Classe responsável por unir todos os pacotes do programa, garantindo que funcionem da maneira adequada e não causem possíveis erros
 * @author Thiago Fança
 * @version 1.0 (29/11/2020)
 */
public class Principal {
	
	public Livraria livraria = new Livraria();
	CadastroLivro cadl = new CadastroLivro(this);
	CadastroUsuario cadu = new CadastroUsuario(this);
	CadastroFuncionario cadf = new CadastroFuncionario(this);
	TelaLogin log = new TelaLogin(this);
	
	MenuWB menu = new MenuWB(this, log, cadu, cadl, cadf);
	
	public Principal() {
		visivel();
	}
	
	/**
	 * Permite que novos Livros sejam cadastrados na livraria
	 * @param Um objeto do tipo livro que poderá ser adicionado ao catálogo
	 * @return nenhum
	 */	
	public void cadastrarLiv(Livro l) {
		livraria.addLivro(l);
		JOptionPane.showMessageDialog(null, "O livro " + l.getTitulo() + " foi cadastrado com sucesso!");
	}
	/**
	 * Permite que novos clientes sejam cadastrados na livraria
	 * @param Um objeto do tipo Cliente que poderá ser adicionado a lista de clientes
	 * @return nenhum
	 */	
	public void cadastrarUsu(Cliente c) {
		livraria.addCliente(c);
		JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!");
	}
	/**
	 * Permite que novos funcionários sejam cadastrados na livraria
	 * @param Um objeto do tipo Funcionario que poderá ser adicionado a lista de funcionários
	 * @return nenhum
	 */	
	public void cadastrarFun(Funcionario f) {
		livraria.addFuncionario(f);
		JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso!");
	}
	/**
	 * Permite que o menu da livraria fique visível
	 * @param nenhum
	 * @return nenhum
	 */	
	public void visivel() {
		menu.setVisible(true);
	}
	/**
	 * permite que o usuário realize login em sua conta, verificando se os dados inseridos pelo usuário estão cadastrados na loja e se são compatíveis
	 * @param Uma String que recebe o login inserido e outra String que recebe a senha inserida
	 * @return
	 */
	public void realizarLogin(String l, String s) {
		int c;
		for(c=0; c<livraria.getClientes().size(); c++){
			if(l.equalsIgnoreCase(livraria.getClientes().get(c).getLogin())) {
				if(s.equals(livraria.getClientes().get(c).getSenha())){
					livraria.setUsuario(livraria.getClientes().get(c));
					livraria.setStatus(true);
					JOptionPane.showMessageDialog(null, "Bem vindo " + livraria.getClientes().get(c).getNome());
					livraria.setTipoUsuario(false);
					menu.log();
					break;
				}
				else {
					JOptionPane.showMessageDialog(null, "A senha inserida está incorreta", null, JOptionPane.ERROR_MESSAGE);
					break;
				}
			}
		}
		for(int j=0; j<livraria.getFuncionarios().size(); j++) {
			if(l.equalsIgnoreCase(livraria.getFuncionarios().get(j).getLogin())) {
				if(s.equals(livraria.getFuncionarios().get(j).getSenha())) {
					livraria.setFun(livraria.getFuncionarios().get(j));
					livraria.setStatus(true);
					livraria.setTipoUsuario(true);
					JOptionPane.showMessageDialog(null, "Bem vindo " + livraria.getFuncionarios().get(j).getNome());
					menu.log();
					break;
				}else {
					JOptionPane.showMessageDialog(null, "A senha inserida está incorreta", null, JOptionPane.ERROR_MESSAGE);
					break;
				}
				}else if(j == livraria.getFuncionarios().size()-1 && c == livraria.getClientes().size()-1){
				JOptionPane.showMessageDialog(null, "A nome de usuário inserido não existe", null, JOptionPane.ERROR_MESSAGE);
			   }
		}			
}
}