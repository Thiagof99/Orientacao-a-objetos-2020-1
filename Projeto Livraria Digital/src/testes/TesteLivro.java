package testes;
import controle.*;
import livrariaDigital.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TesteLivro {
	
	Livraria liv = new Livraria();
	Validacoes v = new Validacoes();
	Livro l = new Livro("genero","titulo", "a", "b", "c", 1, 2, 3);
	ArrayList<Livro> livros = new ArrayList<Livro>();
	@Test
	void testVcu() {	
		assertTrue(v.vcu(liv, "thiago", "thiago@unb.com"));
		assertTrue(v.vcu(liv, "thiago", "thiago@unb.com", "123"));
	}
	void testVcl() {
		assertTrue(v.vcl(liv, "OBGA", "12345"));
	}

}
