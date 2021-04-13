package livrariaDigital;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import controle.*;
/**
 * Classe responsável por armazenar estatísticas da livraria, permitindo que estes dados sejam alterados e capturados
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */
public class Estatisticas {
	
	private ArrayList<Livro> livrosMaisVendidos = new ArrayList<Livro>();
	private ArrayList<Cliente> clientesFrequentes = new ArrayList<Cliente>();
	private ArrayList<Float> pagamentosEfetuados = new ArrayList<Float>();
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private ArrayList<Pedido> pendentes = new ArrayList<Pedido>();
	private float lucroMensal;
	
	public ArrayList<Livro> getLivrosMaisVendidos() {
		return this.livrosMaisVendidos;
	}
	public void setLivroMaisVendido(ArrayList<Livro> l) {
		this.livrosMaisVendidos = l;
	}
	public ArrayList<Cliente> getClientesFrequentes() {
		return this.clientesFrequentes;
	}
	public void setClientesFrequentes(ArrayList<Cliente> c) {
		this.clientesFrequentes = c;
	}
	public ArrayList<Float> getPagamentosEfetuafos() {
		return this.pagamentosEfetuados;
	}
	public void setPagamentosEfetuafos(ArrayList<Float> p) {
		this.pagamentosEfetuados = p;
	}
	public float getLucroMensal() {
		return this.lucroMensal;
	}
	public void setLucroMensal(float lucroMensal) {
		this.lucroMensal = lucroMensal;
	}
	public ArrayList<Pedido> getPedidos() {
		return this.pedidos;
	}
	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public void addPedido(Pedido p) {
		this.pedidos.add(p);
	}
	public void addBestSeller(Livro l) {
		this.livrosMaisVendidos.add(l);
	}
	public void addClienteFrenquente(Cliente c) {
		this.clientesFrequentes.add(c);
	}
	public void addPagamentosEfetuados(float p) {
		this.pagamentosEfetuados.add(p);
	}	
}
