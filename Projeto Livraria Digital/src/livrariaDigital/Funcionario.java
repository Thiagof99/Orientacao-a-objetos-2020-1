package livrariaDigital;

public class Funcionario extends Pessoa{
	/**
	 * Classe responsável por gerar um obejto funcionário, além de alterar os dados desse obejto 
	 * @author Thiago França
	 * @version 1.0 (29/11/2020)
	 */	
	private String identificacao;
	private String funcao;
	private float salario;
	private int vendas;
	
	public Funcionario(String login, String senha, String nome, String email, String endereco,
			String cpf, int telefone, String identificacao, String funcao, float salario) {
		super(login, senha, nome, email, endereco, cpf, telefone);
		this.identificacao = identificacao;
		this.funcao = funcao;
		this.salario = salario;
		this.vendas = 0;
	}
	public String getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public int getVendas() {
		return vendas;
	}
	public void setVendas(int vendas) {
		this.vendas = vendas;
	}
}
