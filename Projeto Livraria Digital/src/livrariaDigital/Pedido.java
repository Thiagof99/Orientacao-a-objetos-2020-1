package livrariaDigital;
import java.util.ArrayList;
import java.util.Random;
/**
 * Classe responsável por armazenar dados de um pedido, permitindo que este possa ser monitorado pelo usuário quando ele quiser
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */	
public class Pedido {
	
	Random random = new Random();
	private String[] statusA = new String[]{"Pago", "Enviado", "Recebido"};
	private String status;
	private boolean pendente;
	private String companhiaEntrega;
	private String dataEnvio;
	private Cesta cesta = new Cesta();
	private int codigo;
	private float valor;
	private ArrayList<Livro> livros = new ArrayList<Livro>();
	
	public Pedido(String companhiaEntrega, Cesta c, ArrayList<Livro> l, float v) {
		this.cesta = c;
		this.status = statusA[0];
		this.pendente = true;
		this.companhiaEntrega = companhiaEntrega;
		this.codigo = random.nextInt(899999)+100000;
		this.valor = v;
		for(int i=0; i<l.size(); i++) {
			this.livros.add(l.get(i));
		}
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(int x) {
		this.status = statusA[x];
	}
	public Cesta getCesta() {
		return this.cesta;
	}
	public void setCesta(Cesta cesta) {
		this.cesta = cesta;
	}
	public boolean getPendente() {
		return pendente;
	}
	public void setPendente(boolean pendente) {
		this.pendente = pendente;
	}
	public String getCompanhiaEntrega() {
		return companhiaEntrega;
	}
	public void setCompanhiaEntrega(String companhiaEntrega) {
		this.companhiaEntrega = companhiaEntrega;
	}
	public String getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(String dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public ArrayList<Livro> getLivros() {
		return livros;
	}
	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}
	
	
}
