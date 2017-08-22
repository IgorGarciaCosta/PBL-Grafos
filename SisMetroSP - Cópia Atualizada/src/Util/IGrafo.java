package Util;

public interface IGrafo {
	public void addVertice(String chave);
	public Iterable<String> getAdjacente(String v);
	public int numVertices();
	public void removeVertice(String chave);
	public void addAresta(String v, String c, Double a);
	public Double getAresta(String u, String chave);
	
	public int numArestas(String v);
	public void removeAresta(String u, String v);
	
	public Iterador vertices();
}
