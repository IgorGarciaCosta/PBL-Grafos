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
package Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import Model.Aresta;
import Model.Grafo;
import Model.Vertice;
import Util.Iterador;

/*
 * Esta classe implementa o comportamento de
 * um controlador universal.
 * 
 * Exemplo de uso:
 * 
 * Controller c = new Controller();
 * 
 * @author Igor & Rafael
 */
public class Controller {
	Grafo graph;
	
	public Controller() {
		graph = new Grafo();
	}
	
	public void adicionarVertice(String v){
		Vertice estacao = new Vertice(v);
		graph.addVertex(estacao);
	}
	
	public Vertice obterVertice(String teste){
		String temp = teste;
    	Iterador passadorVertices = graph.vertices();
    	while(passadorVertices.temProximo()){
    		Vertice aux = (Vertice) passadorVertices.obterProximo();
    		if(aux.getEstacao().compareTo(temp) == 0){
    			return aux;
    		}
    	}
    	return null;
	}
	
	public void adicionarAresta(Vertice ida, Vertice vinda, double peso){
		String estacaoIda = ida.getEstacao();
		String estacaoVinda = vinda.getEstacao();
		//para a ida
		obterVertice(estacaoIda).addAdjacentes(vinda);
		//para a vinda
		obterVertice(estacaoVinda).addAdjacentes(ida);
		//adicionando o caminho
		graph.addAresta(ida, vinda, peso);
	}
	
	public Aresta obterAresta(Vertice ida, Vertice vinda){
		Iterador passadorArestas = graph.Arestas();
    	while(passadorArestas.temProximo()){
    		Aresta aux = (Aresta) passadorArestas.obterProximo();
    		if(aux.getIda().getEstacao().compareTo(ida.getEstacao()) == 0 && aux.getVinda().getEstacao().compareTo(vinda.getEstacao()) == 0){
    			return aux;
    		}
    	}
    	return null;
	}
	
	public void leituraDoArquivo() throws IOException, FileNotFoundException{
		String diretorio = "C:\\Users\\Usuário\\workspace\\SisMetroSP\\MapaMetro.txt";
		FileReader leitura = new FileReader(diretorio);
		BufferedReader leitor = new BufferedReader(leitura);
		String linha = leitor.readLine();
		String[] macabra;
		double peso;
		while(linha != null){
			macabra = linha.split(",");
			if(linha.contains("#"))
				leitor.readLine();
			else{
				//ocorre a atribuição da ida, vinda e o peso da viagem.
				Vertice ida = obterVertice(macabra[0]);
				Vertice vinda = obterVertice(macabra[1]);
				peso = Double.parseDouble(macabra[2]);
				//se não houver nenhuma estação previamente cadastrada.
				if(ida == null && vinda == null){
					adicionarVertice(macabra[0]);
					adicionarVertice(macabra[1]);
					adicionarAresta(obterVertice(macabra[0]), obterVertice(macabra[1]), peso);
					linha = leitor.readLine();
				//se a estação de chegada estiver cadastrada e a de saida não.
				}else if(ida != null && vinda == null){
					adicionarVertice(macabra[1]);
					adicionarAresta(obterVertice(macabra[0]), obterVertice(macabra[1]), peso);
					linha = leitor.readLine();
				//se a estação de saida não houver sido cadastrada anteriormente e de chegada já.
				}else if(ida == null && vinda != null){
					adicionarVertice(macabra[0]);
					adicionarAresta(obterVertice(macabra[0]), obterVertice(macabra[1]), peso);
					linha = leitor.readLine();
				//se o caminho for a volta de duas estações cadastradas.
				}else{
					adicionarAresta(obterVertice(macabra[0]), obterVertice(macabra[1]), peso);
					linha = leitor.readLine();
				}
			}
			
		}//termino do grafo
		leitor.close();
	}
}
