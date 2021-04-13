package livrariaDigital;
import java.util.ArrayList;
/**
 * Classe responsável por gerar um obejto cliente, além de alterar os dados desse obejto
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */
public class Cliente extends Pessoa{
	
	private ArrayList<Pedido> historicoCompras = new ArrayList<Pedido>();
	private String infoPagamento;
	private float saldo;
	private Cesta cesta;
	
	public Cliente(String login, String senha, String nome, String email, String endereco, String cpf, int telefone) {
		super(login, senha, nome, email, endereco, cpf, telefone);
		this.infoPagamento = null;
		this.saldo = 0;
		Cesta c = new Cesta();
		cesta = c;
	}
	public Cesta getCesta() {
		return cesta;
	}
	public void setCesta(Cesta cesta) {
		this.cesta = cesta;
	}
	public ArrayList<Pedido> getHistoricoCompras() {
		return this.historicoCompras;
	}
	public void setHistoricoCompras(ArrayList<Pedido> historicoCompras) {
		this.historicoCompras = historicoCompras;
	}
	public String getInfoPagamento() {
		return this.infoPagamento;
	}
	public void setInfoPagamento(String infoPagamento) {
		this.infoPagamento = infoPagamento;
	}
	public float getSaldo() {
		return this.saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public void addSaldo(float s) {
		this.saldo = this.saldo + s;
	}
	public void addHistorico(Pedido p) {
		this.historicoCompras.add(p);
	}
}
