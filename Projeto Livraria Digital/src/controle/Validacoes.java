package controle;
import livrariaDigital.*;
import javax.swing.JOptionPane;
import interfaceUsuario.*;

/**
 * Classe responsável por validar novos cadastros de diferentes objetos, impedindo que objetos identicos sejam cadastrados
 * @author Thiago Fança
 * @version 1.0 (29/11/2020)
 */
public class Validacoes {
	/**
	 * Valida o cadastro de um novo cliente se os parametros passados ainda não estiverem cadastrados na livraria
	 * @param Um obejto do tipo livraria que contererá os dados analizados, uma String que recebe o login inserido pelo usuário, e uma String que recebe o email inserido 
	 * @return um boolean que é verdadeiro quando os dados cadastrados ainda não foram cadastrados na livraria
	 */
	public boolean vcu(Livraria l, String log, String email) {
			boolean valida = true;
			for(int c=0; c<l.getClientes().size(); c++) {
				if(log.equalsIgnoreCase(l.getClientes().get(c).getLogin())) {
					JOptionPane.showMessageDialog(null, "O login escohido já foi cadastrado");
					valida = false;
					break;
				}
				if(email.equalsIgnoreCase(l.getClientes().get(c).getEmail())) {
					JOptionPane.showMessageDialog(null, "O Email escohido já foi cadastrado");
					valida = false;
					break;
				}
			}
			for(int c=0; c<l.getFuncionarios().size(); c++) {
				if(log.equalsIgnoreCase(l.getFuncionarios().get(c).getLogin())) {
					JOptionPane.showMessageDialog(null, "O login escohido já foi cadastrado");
					valida = false;
					break;
				}
				if(email.equalsIgnoreCase(l.getFuncionarios().get(c).getEmail())) {
					JOptionPane.showMessageDialog(null, "O Email escohido já foi cadastrado");
					valida = false;
					break;
				}
			}
			return valida;
		}
	/**
	 * Valida o cadastro de um novo Funcionario se os parametros passados ainda não estiverem cadastrados na livraria
	 * @param Um obejto do tipo livraria que contererá os dados analizados, uma String que recebe o login inserido pelo usuário,
	 *  ,uma String que recebe o email inserido e uma String que recebe o código de identificação inserido pelo usuário 
	 * @return um boolean que é verdadeiro quando os dados cadastrados ainda não foram cadastrados na livraria
	 */
	public boolean vcu(Livraria l, String log, String email, String id) {
		boolean valida = true;
		for(int c=0; c<l.getClientes().size(); c++) {
			if(log.equalsIgnoreCase(l.getClientes().get(c).getLogin())) {
				JOptionPane.showMessageDialog(null, "O login escohido já foi cadastrado");
				valida = false;
				break;
			}
			if(email.equalsIgnoreCase(l.getClientes().get(c).getEmail())) {
				JOptionPane.showMessageDialog(null, "O Email escohido já foi cadastrado");
				valida = false;
				break;
			}
		}
		for(int c=0; c<l.getFuncionarios().size(); c++) {
			if(log.equalsIgnoreCase(l.getFuncionarios().get(c).getLogin())) {
				JOptionPane.showMessageDialog(null, "O login escohido já foi cadastrado");
				valida = false;
				break;
			}
			if(email.equalsIgnoreCase(l.getFuncionarios().get(c).getEmail())) {
				JOptionPane.showMessageDialog(null, "O Email escohido já foi cadastrado");
				valida = false;
				break;
			}
			if(id.equalsIgnoreCase(l.getFuncionarios().get(c).getIdentificacao())) {
				JOptionPane.showMessageDialog(null, "A identificação escohida já foi cadastrada");
				valida = false;
				break;
			}
		}
		return valida;
	}
	/**
	 * Valida o cadastro de um novo livro se os parametros passados ainda não estiverem cadastrados na livraria
	 * @param Um obejto do tipo livraria que contererá os dados analizados, uma String que recebe o título inserido pelo usuário e uma String que recebe a ISBN inserida 
	 * @return um boolean que é verdadeiro quando os dados cadastrados ainda não foram cadastrados na livraria
	 */
	public boolean vcl(Livraria l, String tit, String isbn) {
		boolean valida = true;
		for(int c=0; c<l.getCatalogo().size(); c++) {
			if(tit.equalsIgnoreCase(l.getCatalogo().get(c).getTitulo())) {
				JOptionPane.showMessageDialog(null, "O título inserido já foi cadastrado");
				valida = false;
				break;
			}
			if(isbn.equalsIgnoreCase(l.getCatalogo().get(c).getIsbn())) {
				JOptionPane.showMessageDialog(null, "A ISNB inserida já foi cadastrada");
				valida = false;
				break;
			}
		}
		return valida;
	}
	}

