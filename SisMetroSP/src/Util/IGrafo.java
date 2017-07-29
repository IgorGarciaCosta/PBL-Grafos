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
