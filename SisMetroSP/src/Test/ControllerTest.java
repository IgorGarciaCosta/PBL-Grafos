package Test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import Controller.Controller;
import Model.Aresta;
import Model.Vertice;

public class ControllerTest {
	private Controller c;
	@Before
	public void setUp() throws Exception {
		c = new Controller();
	}

	@Test
	public void testFile() throws IOException {
		c.leituraDoArquivo();
		Vertice ida = new Vertice("Tucuruvi");
		Vertice vinda = new Vertice("Parada Inglesa");
		double peso = 2;
		Aresta caminho= new Aresta(ida, vinda, peso);
		
		Aresta esperada = c.obterAresta(ida, vinda);
		System.out.println(ida.getEstacao());
		assertEquals("Prova que as estações são iguais",caminho.getIda().getEstacao(), esperada.getIda().getEstacao());
	}

}
