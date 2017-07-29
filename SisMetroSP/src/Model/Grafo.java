/*
 * Componente Curricular: M�dulo Integrado de Computa��o
 * Autores: Rafael Ara�jo e Igor Garcia
 * Data: 28/07/2017
 * Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m 
 * nenhum trecho de c�digo de outro colega ou de outro autor, tais como provindos 
 * de livros e apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer
 * trecho de c�digo de outra autoria que n�o a minha est� destacado com uma cita��o
 * para o autor e a fonte do c�digo, e estou ciente que estes trechos n�o ser�o 
 * considerados para fins de avalia��o.
 */
package Model;
import Util.IGrafo;
import Util.Iterador;
import Util.Lista;

/*
 * Esta classe implementa o comportamento de um caminho 
 * entre estacoes, como um modelo de grafo.
 * 
 * Exemplo de uso:
 * 
 * Grafo graph = new Grafo();
 * 
 * @author Igor & Rafael
 */

public class Grafo implements IGrafo{
	Lista<Vertice> deVertices;
	Lista<Aresta> deArestas;
	
	public Grafo(){
		deVertices = new Lista<Vertice>();
		deArestas = new Lista<Aresta>();
	}
	@Override
	public void addVertex(Vertice chave) {
		deVertices.add(chave);
	}

	@Override
	public Iterador vertices() {
		return deVertices.iterador();
	}

	@Override
	public int numVertices() {
		return deVertices.obterTamanho();
	}

	@Override
	public void removeVertex(Vertice key) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addAresta(Vertice u, Vertice v, double peso) {
		Aresta aresta = new Aresta(u, v, peso);
		deArestas.add(aresta);
	}

	@Override
	public Aresta getAresta(Vertice u, Vertice chave) {
		return null;
	}

	@Override
	public Iterador Arestas() {
		return deArestas.iterador();
	}

	@Override
	public int numArestas() {
		return deArestas.obterTamanho();
	}

	@Override
	public void removeAresta(Aresta e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterador outgoingArestas(Vertice v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int outDegree(Vertice v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterador incomingArestas(Vertice v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int inDegree(Vertice v) {
		return 0;
	}

}
