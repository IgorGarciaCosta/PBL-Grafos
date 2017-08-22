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
