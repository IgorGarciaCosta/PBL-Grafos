package Util;

import java.util.HashMap;
import java.util.PriorityQueue;
import Model.Aresta;
import Model.Grafo;

/*
 * Esta classe implementa o comportamento de uma algoritmo de Dijkistra,
 * menor caminho, como um modelo de HashMap, fila de prioridade e pilha.
 * 
 * Exemplo de uso:
 * 
 * HashMap<String, Aresta> xxx = c.carregarDijkistra().algoritmoDeMenorCaminho(String estacao);
 * Pilha<Aresta> xx= c.carregarDijkistra().caminho(Vertice c, Vertice v, HashMap<String, Aresta> xxx);
 * 
 * @author Igor & Rafael
 */
public class Dijkistra {
	Grafo deDijkistra;
	
	public Dijkistra(Grafo controlador){
		this.deDijkistra = controlador;
	}
	
	public Pilha<Aresta> algoritmoDeCaminhoMinimo(String v, String u) {
		//Verificação dos vertices v e u
		if(deDijkistra.eVertice(v) && deDijkistra.eVertice(u)) {
			HashMap<String, Aresta> visited = new HashMap<>();
			PriorityQueue<Aresta> next = new PriorityQueue<>();
			next.add(new Aresta(v, null, 0));
			
			//Verificar se tem proximo e se o destino nao foi atingido
			while(!next.isEmpty() && !visited.containsKey(u)) {
				//Pega os pesos e o nome do proximo
				Aresta info = next.remove();
				String removida = info.getIda();
				
				//Verificacao da colecao de visitados
				if(!visited.containsKey(removida)) {
					visited.put(removida, info);
					
					//Verifica os adjacentes a ele					
					for(String cur : deDijkistra.getAdjacente(removida)) {												
						//Atualiza o tempo dos adjacentes nao visitados
						if(!visited.containsKey(cur)) {
							double tempo = deDijkistra.getAresta(removida, cur);
							tempo += info.getPeso();
							next.add(new Aresta(cur, removida, tempo));
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
		while(saida.compareTo(entrada) != 0){
			stack.push(menorCaminho.get(entrada));
			entrada = menorCaminho.get(entrada).getVinda();
		}
		stack.push(menorCaminho.get(entrada));
		return stack;
	}
}
