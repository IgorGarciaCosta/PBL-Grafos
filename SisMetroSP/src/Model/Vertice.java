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
import Util.Lista;

/*
 * Esta classe implementa o comportamento de uma estacao 
 * de metro, como um modelo de vertice em um grafo.
 * 
 * Exemplo de uso:
 * 
 * Vertice v = new Vertice("Cruzes");
 * 
 * @author Igor & Rafael
 */
public class Vertice {
	private String estacao;
	private Lista<Vertice> adjacentes;

	public Vertice(String e){
		this.estacao = e;
		adjacentes = new Lista<Vertice>();
	}
	
	public String getEstacao() {
		return estacao;
	}
	public void setEstacao(String estacao) {
		this.estacao = estacao;
	}
	
	public void addAdjacentes(Vertice ad){
		adjacentes.add(ad);
	}
	
	public Lista<Vertice> getAdjacentes(){
		return adjacentes;
	}
}
