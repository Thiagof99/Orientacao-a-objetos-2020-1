package livrariaDigital;
import java.util.ArrayList;
/**
 * Classe responsável por organizar e armazenar os dados da cesta de compras de um cliente
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */
public class Cesta {
	
	private ArrayList<Livro> livros = new ArrayList<Livro>();
	private float frete;
	private float desconto;
	private float precoTotal;
	private int qtLivros;
	private int cepEnvio;   
	
	public Cesta() {
		precoTotal = 0;
	}
	public ArrayList<Livro> getLivros() {
		return this.livros;
	}
	public void setLivros(ArrayList<Livro> l) {
		this.livros = l;
	}
	public void addLivro(Livro l) {
		this.livros.add(l);
	}
	public float getFrete() {
		return this.frete;
	}
	public void setFrete(float frete) {
		this.frete = frete;
	}
	public float getDesconto() {
		return this.desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	public float getPrecoTotal() {
		setPrecoTotal();
		return this.precoTotal;
	}
	private void setPrecoTotal(){
		float pl = 0;
		for(int c=0; c<livros.size(); c++) {
			pl = pl + livros.get(c).getPreco();
		}
		this.precoTotal = pl + this.frete - this.desconto;
	}
	public int getQtLivros() {
		setQtLivros();
		return this.qtLivros;
	}
	private void setQtLivros() {
		this.qtLivros = livros.size();
	}
	public int getCepEnvio() {
		return this.cepEnvio;
	}
	public void setCepEnvio(int cepEnvio) {
		this.cepEnvio = cepEnvio;
	}
}
