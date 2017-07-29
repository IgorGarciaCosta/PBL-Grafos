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
