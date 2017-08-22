package Test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import Controller.Controller;
import Model.Aresta;
import Util.Pilha;

public class ControllerTest {
	private Controller c;
	@Before
	public void setUp() throws Exception {
		c = new Controller();
	}

	@Test
	public void testFile() throws IOException {
		c.leituraDoArquivo();
		String ida = ("Tucuruvi");
		String vinda = ("Parada Inglesa");
		double peso = 2;
		Aresta caminho = new Aresta(ida, vinda, peso);
		double esperada = c.graph.getAresta(ida, vinda);
		assertTrue("Prova que as estações são iguais",((caminho.getPeso() == esperada)));
	}
	
	@Test
	public void testProcurarVertice() throws FileNotFoundException, IOException{
		c.leituraDoArquivo();
		String procurada = ("Tucuruvi");
		String encontrada = c.graph.get(procurada);
		boolean resultado = (encontrada.compareTo(procurada) == 0);
		
		assertTrue(resultado);
	}
	
	@Test
	public void testArestasTotaisDevemSerMaiorQueZero() throws FileNotFoundException, IOException{
		c.leituraDoArquivo();
		String procurada = ("Tucuruvi");
		int i = 0;
		int size = c.graph.numArestas(procurada);
		
		boolean resultado = i < size;
		assertTrue(resultado);
	}
	
	@Test
	public void testTotalDeEstacoes() throws FileNotFoundException, IOException{
		c.leituraDoArquivo();
		int resultado = 133;
		//foi contado a dedo.
		int size = c.graph.numVertices();
		
		assertTrue((resultado == size));
	}
	
	@Test
	public void testTotalDeCaminhos() throws FileNotFoundException, IOException{
		c.leituraDoArquivo();
		int esperado = 1;
		String v = ("Tucuruvi");
		int size = c.graph.numArestas(v);

		assertTrue(esperado == size);
	}
	
	@Test
	public void testExistenciaDeVertice() throws FileNotFoundException, IOException{
		c.leituraDoArquivo();
		String v = ("Tucuruvi");
		boolean resultado = c.graph.eVertice(v);
		
		assertTrue(resultado);
	}
	
	@Test
	public void testDjikistra() throws FileNotFoundException, IOException{
		c.leituraDoArquivo();
		String v = ("Tucuruvi");
		String u = ("Parada Inglesa");
		Pilha<Aresta> caminhos = c.carregarDijkistra().algoritmoDeCaminhoMinimo(u,v);
		Aresta tpa = new Aresta(v, u, 2);
		Aresta obtido = caminhos.pull();
		System.out.println(obtido.getPeso());
		
		boolean resultado = (tpa.getPeso() == obtido.getPeso());
		assertTrue(resultado);
	}
	
	@Test
	public void testPilhaDeDjikistra() throws FileNotFoundException, IOException{
		c.leituraDoArquivo();
		String p = ("Luz");
		String u = ("Tucuruvi");
		Pilha<Aresta> caminhos = c.carregarDijkistra().algoritmoDeCaminhoMinimo(u,p);
		
		boolean resultado = (!caminhos.estaVazia());
		assertFalse(!resultado);
	}
	
}
