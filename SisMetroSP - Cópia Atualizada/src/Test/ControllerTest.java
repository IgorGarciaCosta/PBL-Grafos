package Test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import Controller.Controller;
import Model.Aresta;
import Model.Vertice;
import Util.Dijkistra;
import Util.Pilha;

public class ControllerTest {
	private Controller c;
	@Before
	public void setUp() throws Exception, FileNotFoundException, IOException {
		c = new Controller();
		c.leituraDoArquivo();
	}

	@Test
	public void testArquivoSeHouverEstacoesIguais(){
		String ida = ("Tucuruvi");
		String vinda = ("Parada Inglesa");
		double peso = 2;
		//duas estacoes que devem conter no arquivo
		Aresta caminho = new Aresta(ida, vinda, peso);
		double esperada = c.graph.getAresta(ida, vinda);
		assertTrue("Prova que as estações são iguais",((caminho.getPeso() == esperada)));
	}
	
	@Test
	public void testTotalDeEstacoes(){
		int resultado = 133;
		//foi contado a dedo.
		int size = c.graph.numVertices();
		
		assertTrue((resultado == size));
	}
	
	@Test
	public void testTotalDeCaminhos(){
		int esperado = 1;
		String v = ("Tucuruvi");
		int size = c.graph.numArestas(v);

		assertTrue(esperado == size);
	}
	@Test
	public void testProcurarVertice(){
		String procurada = ("Tucuruvi");
		String encontrada = c.graph.get(procurada);
		boolean resultado = (encontrada.compareTo(procurada) == 0);
		
		assertTrue(resultado);
	}
	
	@Test
	public void testArestasTotaisDevemSerMaiorQueZero(){
		String procurada = ("Tucuruvi");
		int i = 0;
		int size = c.graph.numArestas(procurada);
		
		boolean resultado = i < size;
		assertTrue(resultado);
		//verifica se houve inserção de vertice
	}
	
	@Test
	public void testExistenciaDeVertice(){
		String v = ("Tucuruvi");
		boolean resultado = c.graph.eVertice(v);
		
		assertTrue(resultado);
	}
	
	@Test
	public void testDjikistra(){
		String v = ("Tucuruvi");
		String u = ("Parada Inglesa");
		Pilha<Aresta> caminhos = c.carregarDijkistra().algoritmoDeCaminhoMinimo(v,u);
		Aresta tpa = new Aresta(v, u, 2);
		Aresta obtido = null;
		Aresta c;
		while(!caminhos.estaVazia()){
			c = caminhos.pull();
			if(tpa.getPeso() == c.getPeso()){
				obtido = c;
			}
		}
		
		boolean resultado = (tpa.getPeso() == obtido.getPeso());
		assertTrue(resultado);
	}
	
	@Test
	public void testPilhaDeDjikistra(){
		String p = ("Luz");
		String u = ("Tucuruvi");
		Pilha<Aresta> caminhos = c.carregarDijkistra().algoritmoDeCaminhoMinimo(u,p);
		
		boolean resultado = (!caminhos.estaVazia());
		assertFalse(!resultado);
	}
	
	@Test
	public void testPilhaGuardaAresta(){
		String p = ("Luz");
		String u = ("Tucuruvi");
		Pilha<Aresta> caminhos = c.carregarDijkistra().algoritmoDeCaminhoMinimo(u,p);
		
		assertTrue((caminhos.size() == 9));
		//pelo mapa, há 9 caminhos de Tucuruvi a Luz.
	}
	
	@Test
	public void testRetirarArestasDaPilha(){
		String p = ("Luz");
		String u = ("Tucuruvi");
		Dijkistra caa;
		caa = c.carregarDijkistra();
		Pilha<Aresta> caminhos = caa.algoritmoDeCaminhoMinimo(u,p);
		//há 8 itens nessa pilha
		
		Aresta[] a = new Aresta[8];
		for(int i = 0; i < a.length; i++){
			a[i] = caminhos.pull();
		}
		
		assertTrue("Caminhos diferentes", (a[0].getIda().compareTo(a[4].getIda()) != 0));
	}
	
	@Test
	public void testRemoverAresta(){
		String v = ("Tucuruvi");
		String u = ("Parada Inglesa");
		c.graph.removeAresta(u, v);
		Double a = c.graph.getAresta(u, v);
		
		assertEquals(null, a);
	}
	
	@Test
	public void testBuscarArestaInexistente(){
		String v = ("Pitanga");
		String encontrada = c.graph.get(v);
		
		assertEquals("Caso ocorra alguma divergencia em alguma String.",null, encontrada);
	}
	
}
