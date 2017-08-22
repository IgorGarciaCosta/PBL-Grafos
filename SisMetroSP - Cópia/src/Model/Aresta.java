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
 * Esta classe implementa o comportamento de um caminho 
 * entre estacoes, como um modelo de aresta em um grafo.
 * 
 * Exemplo de uso:
 * 
 * Aresta a = new Aresta("Cruzes", "Salon", 2);
 * 
 * @author Igor & Rafael
 */
@SuppressWarnings("rawtypes")
public class Aresta implements Comparable{
	private String ida;
	private String vinda;
	private double peso;
	
	public Aresta(String i, String v, double p){
		this.ida = i;
		this.vinda = v;
		this.peso = p;
	}
	
	public String getIda() {
		return ida;
	}
	
	public void setIda(String ida) {
		this.ida = ida;
	}
	public String getVinda() {
		return vinda;
	}
	public void setVinda(String vinda) {
		this.vinda = vinda;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public int compareTo(Object a) {
		Aresta e = (Aresta) a;
		if (this.peso < e.peso)
			return -1;
		else if (this.peso > e.peso)
			return 1;
		else
			return 0;
	}
}
