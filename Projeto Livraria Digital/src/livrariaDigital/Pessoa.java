package livrariaDigital;

public abstract class Pessoa extends Usuario{
	
	private String nome;
	private String email;
	private String endereco;
	private String cpf;
	private int telefone;
	/**
	 * Classe abstrarta contendo atributos comuns de suas filhas, essa classe servirá para dar origem a um novo cliente ou funcionário
	 * @author Thiago França
	 * @version 1.0 (29/11/2020)
	 */	
	public Pessoa(String login, String senha, String nome, String email, String endereco, String cpf, int telefone) {
		super(login, senha);
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
}
