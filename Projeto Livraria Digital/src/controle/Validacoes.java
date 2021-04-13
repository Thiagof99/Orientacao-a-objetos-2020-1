package controle;
import livrariaDigital.*;
import javax.swing.JOptionPane;
import interfaceUsuario.*;

/**
 * Classe respons�vel por validar novos cadastros de diferentes objetos, impedindo que objetos identicos sejam cadastrados
 * @author Thiago Fan�a
 * @version 1.0 (29/11/2020)
 */
public class Validacoes {
	/**
	 * Valida o cadastro de um novo cliente se os parametros passados ainda n�o estiverem cadastrados na livraria
	 * @param Um obejto do tipo livraria que conterer� os dados analizados, uma String que recebe o login inserido pelo usu�rio, e uma String que recebe o email inserido 
	 * @return um boolean que � verdadeiro quando os dados cadastrados ainda n�o foram cadastrados na livraria
	 */
	public boolean vcu(Livraria l, String log, String email) {
			boolean valida = true;
			for(int c=0; c<l.getClientes().size(); c++) {
				if(log.equalsIgnoreCase(l.getClientes().get(c).getLogin())) {
					JOptionPane.showMessageDialog(null, "O login escohido j� foi cadastrado");
					valida = false;
					break;
				}
				if(email.equalsIgnoreCase(l.getClientes().get(c).getEmail())) {
					JOptionPane.showMessageDialog(null, "O Email escohido j� foi cadastrado");
					valida = false;
					break;
				}
			}
			for(int c=0; c<l.getFuncionarios().size(); c++) {
				if(log.equalsIgnoreCase(l.getFuncionarios().get(c).getLogin())) {
					JOptionPane.showMessageDialog(null, "O login escohido j� foi cadastrado");
					valida = false;
					break;
				}
				if(email.equalsIgnoreCase(l.getFuncionarios().get(c).getEmail())) {
					JOptionPane.showMessageDialog(null, "O Email escohido j� foi cadastrado");
					valida = false;
					break;
				}
			}
			return valida;
		}
	/**
	 * Valida o cadastro de um novo Funcionario se os parametros passados ainda n�o estiverem cadastrados na livraria
	 * @param Um obejto do tipo livraria que conterer� os dados analizados, uma String que recebe o login inserido pelo usu�rio,
	 *  ,uma String que recebe o email inserido e uma String que recebe o c�digo de identifica��o inserido pelo usu�rio 
	 * @return um boolean que � verdadeiro quando os dados cadastrados ainda n�o foram cadastrados na livraria
	 */
	public boolean vcu(Livraria l, String log, String email, String id) {
		boolean valida = true;
		for(int c=0; c<l.getClientes().size(); c++) {
			if(log.equalsIgnoreCase(l.getClientes().get(c).getLogin())) {
				JOptionPane.showMessageDialog(null, "O login escohido j� foi cadastrado");
				valida = false;
				break;
			}
			if(email.equalsIgnoreCase(l.getClientes().get(c).getEmail())) {
				JOptionPane.showMessageDialog(null, "O Email escohido j� foi cadastrado");
				valida = false;
				break;
			}
		}
		for(int c=0; c<l.getFuncionarios().size(); c++) {
			if(log.equalsIgnoreCase(l.getFuncionarios().get(c).getLogin())) {
				JOptionPane.showMessageDialog(null, "O login escohido j� foi cadastrado");
				valida = false;
				break;
			}
			if(email.equalsIgnoreCase(l.getFuncionarios().get(c).getEmail())) {
				JOptionPane.showMessageDialog(null, "O Email escohido j� foi cadastrado");
				valida = false;
				break;
			}
			if(id.equalsIgnoreCase(l.getFuncionarios().get(c).getIdentificacao())) {
				JOptionPane.showMessageDialog(null, "A identifica��o escohida j� foi cadastrada");
				valida = false;
				break;
			}
		}
		return valida;
	}
	/**
	 * Valida o cadastro de um novo livro se os parametros passados ainda n�o estiverem cadastrados na livraria
	 * @param Um obejto do tipo livraria que conterer� os dados analizados, uma String que recebe o t�tulo inserido pelo usu�rio e uma String que recebe a ISBN inserida 
	 * @return um boolean que � verdadeiro quando os dados cadastrados ainda n�o foram cadastrados na livraria
	 */
	public boolean vcl(Livraria l, String tit, String isbn) {
		boolean valida = true;
		for(int c=0; c<l.getCatalogo().size(); c++) {
			if(tit.equalsIgnoreCase(l.getCatalogo().get(c).getTitulo())) {
				JOptionPane.showMessageDialog(null, "O t�tulo inserido j� foi cadastrado");
				valida = false;
				break;
			}
			if(isbn.equalsIgnoreCase(l.getCatalogo().get(c).getIsbn())) {
				JOptionPane.showMessageDialog(null, "A ISNB inserida j� foi cadastrada");
				valida = false;
				break;
			}
		}
		return valida;
	}
	}

