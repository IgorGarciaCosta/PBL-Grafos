package Model;
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
import java.util.HashMap;
import java.util.Iterator;

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
	private HashMap<String,HashMap <String, Double>> grafo;;
	private Lista<Vertice> vertices;
	//cole��o de Strings adjacentes

	public Grafo(){
		vertices = new Lista<>();
		grafo = new HashMap<>();
	}	
	
	public boolean contemVertice(Vertice v){
		Iterador ds = vertices.iterador();
		while(ds.temProximo()){
			Vertice x = (Vertice) ds.obterProximo();
			if(x.compareTo(v) == 0){
				return true;
			}
		}
		return false;
	}
	
	public void adicionarSetDeVertices(Vertice v){
		if(!contemVertice(v)){
			vertices.add(v);
		}
	}
	
	public void addVertice(String chave) {
		if(!eVertice(chave))
			grafo.put(chave, new HashMap<>());	
	}
	
	public boolean eVertice(String chave){
		return grafo.containsKey(chave);
	}
	
	@Override
	public Iterador vertices(){
		return new Passador();
	}
	
	public boolean temCaminho(String u, String v){
		return grafo.containsKey(u) && grafo.get(u).containsKey(v);
	}
	
	public Double getAresta(String ida, String vinda){
		return temCaminho(ida, vinda) ? grafo.get(ida).get(vinda): null;
	}
	
	public String get(String x){
		Iterador passadorDeStrings = vertices();
		while(passadorDeStrings.temProximo()){
			String vertex = (String) passadorDeStrings.obterProximo();
			if(vertex.compareTo(x) == 0){
				return vertex;
			}
		}
		return null;
	}
	
	@Override
	public int numVertices() {
		return grafo.size();
	}
	
	
	@Override
	public void removeVertice(String chave) {
		grafo.remove(chave);
	}
	
	@Override
	public void addAresta(String ida, String vinda, Double a) {
		if(!temCaminho(ida, vinda) && a >= 0) {			
			grafo.get(ida).put(vinda, a);
			grafo.get(vinda).put(ida, a);
		}
	}
	
	@Override
	public Iterable<String> getAdjacente(String v) {
		return eVertice(v) ? grafo.get(v).keySet() : null;
	}
	
	@Override
	public int numArestas(String v) {
		return eVertice(v) ? grafo.get(v).size() : -1;
		//O tamanho seria a soma total de todas arestas.
	}
	
	@Override
	public void removeAresta(String ida, String vinda) {
		if(temCaminho(ida, vinda)) {			
			grafo.get(ida).remove(vinda);
			grafo.get(vinda).remove(ida);
		}
	}

/*	Para dar sorte, vou deixar esse coment�rio.
 * 
 * public Pilha<Aresta> dijkstra(String v, String u) {
		//Verifica se os String existem
		if(eVertice(v) && eVertice(u)) {
			HashMap<String, Aresta> visited = new HashMap<>();
			PriorityQueue<Aresta> next = new PriorityQueue<>();
			next.add(new Aresta(v, null, 0));
			
			//Verificar se tem proximo e se o destino nao foi atingido
			while(!next.isEmpty() && !visited.containsKey(u)) {
				//Pega as informacoes e o nome do proximo
				Aresta info = next.remove();
				String rem = info.getIda();
				
				//Verifica se ele nao foi visitado
				if(!visited.containsKey(rem)) {
					visited.put(rem, info);
					
					//Verifica os adjacentes a ele					
					for(String cur : getAdjacente(rem)) {												
						//Atualiza a distancia dos adjacentes nao visitados
						if(!visited.containsKey(cur)) {
							double tempo = getAresta(rem, cur);
							tempo += info.getPeso();
							next.add(new Aresta(cur, rem, tempo));
						}
					}
				}
			}
						
			//Se o destino foi atingido retorna a pila de path, se nao null
			return visited.containsKey(u) ? caminhoMinimo(v, u,visited) : null;
		}			
		
		return null;
	}
	
	private Pilha<Aresta> caminhoMinimo(String ini, String fim,
									   HashMap<String, Aresta> menorCaminho) {
		Pilha<Aresta> stack = new Pilha<>();
		String saida = ini;
		String entrada = fim;
		while(!saida.equals(entrada)){
			stack.push(menorCaminho.get(entrada));
			entrada = stack.peek().getVinda();
		}
		stack.push(menorCaminho.get(entrada));
		return stack;
	}
*/	
	public class Passador implements Iterador{
		HashMap<String, HashMap<String, Double>> temp;
		Iterator<String> x;
		
		public Passador(){
			temp = grafo;
			this.x = temp.keySet().iterator();
		}
		
		@Override
		public boolean temProximo(){
			return x.hasNext();
		}
	
		@Override
		public String obterProximo() {
			String v = x.next();
			return v;
		}
	}

}



