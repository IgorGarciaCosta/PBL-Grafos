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
@SuppressWarnings("rawtypes")
public class Vertice implements Comparable{
	private String estacao;
	public int[] coordenadas;
	
	public Vertice(String e){
		this.estacao = e;
	}
	
	public String getEstacao() {
		return estacao;
	}
	public void setEstacao(String estacao) {
		this.estacao = estacao;
	}
	
	public void setCoordenadas(int x, int y){
		coordenadas[0] = x;
		coordenadas[1] = y;
	}
	
	public int compareTo(Object chave){
		Vertice c = (Vertice) chave;
		if (this.estacao.compareTo(c.getEstacao()) < 0)
			return -1;
		else if (this.estacao.compareTo(c.getEstacao()) > 0)
			return 1;
		else
			return 0;
	}

		
}
