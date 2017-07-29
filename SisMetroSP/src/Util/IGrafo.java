/*
 * Componente Curricular: Módulo Integrado de Computação
 * Autores: Rafael Araújo e Igor Garcia
 * Data: 28/07/2017
 * Declaro que este código foi elaborado por mim de forma individual e não contém 
 * nenhum trecho de código de outro colega ou de outro autor, tais como provindos 
 * de livros e apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer
 * trecho de código de outra autoria que não a minha está destacado com uma citação
 * para o autor e a fonte do código, e estou ciente que estes trechos não serão 
 * considerados para fins de avaliação.
 */

package Util;
import Model.Aresta;
import Model.Vertice;

public interface IGrafo {
	public void addVertex(Vertice key);
	public Iterador vertices();
	public int numVertices();
	public void removeVertex(Vertice key);
	public void addAresta(Vertice u, Vertice v, double peso);
	public Aresta getAresta(Vertice u, Vertice chave);
	
	public Iterador Arestas();
	public int numArestas();
	public void removeAresta(Aresta e);
	
	public Iterador outgoingArestas(Vertice v);
	public int outDegree(Vertice v);
	
	public Iterador incomingArestas(Vertice v);
	public int inDegree(Vertice v);
}
