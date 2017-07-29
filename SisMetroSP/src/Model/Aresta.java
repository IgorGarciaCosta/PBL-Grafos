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
package Model;

/*
 * Esta classe implementa o comportamento de um caminho 
 * entre estacoes, como um modelo de aresta em um grafo.
 * 
 * Exemplo de uso:
 * 
 * Aresta a = new Aresta("Cruzes", "Salon", 2);
 * 
 * @author Igor & Rafael
 */
public class Aresta {
	private Vertice ida;
	private Vertice vinda;
	private double peso;
	
	public Vertice getIda() {
		return ida;
	}
	
	public Aresta(Vertice i, Vertice v, double p){
		this.ida = i;
		this.vinda = v;
		this.peso = p;
	}
	
	public void setIda(Vertice ida) {
		this.ida = ida;
	}
	public Vertice getVinda() {
		return vinda;
	}
	public void setVinda(Vertice vinda) {
		this.vinda = vinda;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
}
