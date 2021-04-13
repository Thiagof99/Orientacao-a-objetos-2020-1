package livrariaDigital;
import java.util.ArrayList;
/**
 * Classe responsável por gerar um obejto livraria, esta armazena dados de todas as classes do pacote livrariaDigital e permite que sejam levados a outros pacotes.
 * Esta classe é o pilar principal do programa
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */	
public class Livraria {
	
	private ArrayList<Livro> catalogo = new ArrayList<Livro>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private Estatisticas estatisticas = new Estatisticas();
	private Cliente usuario;
	private Funcionario fun;
	private boolean status;
	private boolean tipoUsuario;
	
	public Livraria() {
		status = false;
	}	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Cliente getUsuario() {
		return usuario;
	}
	public void setUsuario(Cliente usuario) {
		this.usuario = usuario;
	}
	public ArrayList<Livro> getCatalogo() {
		return this.catalogo;
	}
	public void setCatalogo(ArrayList<Livro> catalogo) {
		this.catalogo = catalogo;
	}
	public ArrayList<Cliente> getClientes() {
		return this.clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	public ArrayList<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}
	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public Estatisticas getEstatisticas() {
		return this.estatisticas;
	}
	public void setEstatisticas(Estatisticas estatisticas) {
		this.estatisticas = estatisticas;
	}
	public void addLivro(Livro l) {
		this.catalogo.add(l);
	}
	public void addCliente(Cliente c) {
		this.clientes.add(c);
	}
	public void addFuncionario(Funcionario f) {
		this.funcionarios.add(f);
	}
	public Funcionario getFun() {
		return this.fun;
	}
	public void setFun(Funcionario fun) {
		this.fun = fun;
	}
	public boolean isTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(boolean tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}