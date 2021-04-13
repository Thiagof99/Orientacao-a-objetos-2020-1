package livrariaDigital;
/**
 * Classe responsável por gerar um obejto livro, além de alterar os dados desse obejto 
 * @author Thiago França
 * @version 1.0 (29/11/2020)
 */	
public class Livro {
	
	private String genero;
	private String titulo;
	private String autor;
	private String editora;
	private String isbn;
	private int qtPaginas;
	private int qtEstoque;
	private float preco;
	private int unidadesVendidas;
	
	public Livro(String genero, String titulo, String autor, String editora, String isbn, int qtPaginas, int qtEstoque, float preco) {
		super();
		this.genero = genero;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.isbn = isbn;
		this.qtPaginas = qtPaginas;
		this.qtEstoque = qtEstoque;
		this.preco = preco;
		this.unidadesVendidas = 0;
	}
	
	public String getGenero() {
		return this.genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTitulo() {
		return this.titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return this.autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return this.editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getIsbn() {
		return this.isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getQtPaginas() {
		return this.qtPaginas;
	}
	public void setQtPaginas(int qtPaginas) {
		this.qtPaginas = qtPaginas;
	}
	public int getQtEstoque() {
		return this.qtEstoque;
	}
	public void setQtEstoque(int qtEstoque) {
		this.qtEstoque = qtEstoque;
	}
	public float getPreco() {
		return this.preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public int getUnidadesVendidas() {
		return this.unidadesVendidas;
	}

	public void setUnidadesVendidas(int unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}

	public void addEstoque(int e){
		this.qtEstoque = getQtEstoque() + e;
	}
	/**
	 * Altera o estoque e a quantidade de vendas do livro quando acionado
	 * @param nenhum
	 * @return Um novo objeto Funcionario
	 */
	public void venderUnidade() {
		this.unidadesVendidas++;
		this.qtEstoque--;
	}
}
