package livrariaDigital;
/**
 * Classe abstrata responsável por dar origem a uma pessoa, esta classe contem informações fundamentais para que esta possa acessar uma conta na livraria
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */	
public abstract class Usuario {
	private String login;
	private String senha;
	private boolean status;
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
		this.status = false;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}	
	}

