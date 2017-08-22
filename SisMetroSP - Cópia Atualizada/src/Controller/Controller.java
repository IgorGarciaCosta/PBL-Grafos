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
import Model.Grafo;
import Model.Vertice;
import Util.Dijkistra;
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
	public Grafo graph;
	
	public Controller() {
		graph = new Grafo();
	}
	
	public void adicionarVertice(String v){
		graph.addVertice(v);
	}
	
	public Vertice obterVertice(String teste){
		String temp = teste;
    	Iterador passadorVertices = graph.vertices();
    	while(passadorVertices.temProximo()){
    		String aux = (String) passadorVertices.obterProximo();
    		if(aux.compareTo(temp) == 0){
    			return new Vertice(aux);
    		}
    	}
    	return null;
	}
	
	public void adicionarAresta(String ida, String vinda, double peso){
		//adicionando o caminho
		graph.addAresta(ida, vinda, peso);
	}
	
	public Double obterAresta(Vertice ida, Vertice vinda){
		return graph.getAresta(ida.getEstacao(), vinda.getEstacao());
		//retorna a aresta q tem as duas.
	}
	
	public Dijkistra carregarDijkistra(){
		return new Dijkistra(this.graph);
	}
	
	public void leituraDoArquivo() throws IOException, FileNotFoundException{
		String diretorio = "C:\\Users\\Usuário\\workspace\\SisMetroSP\\MapaMetro.txt";
		FileReader leitura = new FileReader(diretorio);
		BufferedReader leitor = new BufferedReader(leitura);
		String linha = leitor.readLine();
		String[] macabra;
		char a = ' ';
		double peso;
		while(linha != null){
			a = linha.charAt(0);
			if(a == 35){
				linha = leitor.readLine();
			}
			else if(a != 35){
				macabra = linha.split(",");
				String ida = (macabra[0]);
				String vinda =  (macabra[1]);
				peso = Double.parseDouble(macabra[2]);
				//se não houver nenhuma estação previamente cadastrada.
				if(obterVertice(macabra[0]) == null && obterVertice(macabra[1]) == null){
					adicionarVertice(ida);
					adicionarVertice(vinda);
					adicionarAresta(macabra[0], macabra[1], peso);
					linha = leitor.readLine();
				//se a estação de chegada estiver cadastrada e a de saida não.
				}else if(obterVertice(macabra[0]) != null && obterVertice(macabra[1]) == null){
					adicionarVertice(vinda);
					adicionarAresta(macabra[0], macabra[1], peso);
					linha = leitor.readLine();
				//se a estação de saida não houver sido cadastrada anteriormente e de chegada já.
				}else if(obterVertice(macabra[0]) == null && obterVertice(macabra[1]) != null){
					adicionarVertice(ida);
					adicionarAresta(macabra[0], macabra[1], peso);
					linha = leitor.readLine();
				//se o caminho for a volta de duas estações cadastradas.
				}else{
					adicionarAresta(macabra[0], macabra[1], peso);
					linha = leitor.readLine();
				}
			}
		}//termino do grafo
		leitor.close();
	}
	
	/*coloque o diretorio das coordenadas e ve se funfa, kkkk
		public void leituraDeCoordenadas() throws IOException{
		String diretorio = "AQUI E COM iGOR";
		FileReader leitura = new FileReader(diretorio);
		BufferedReader leitor = new BufferedReader(leitura);
		String linha = leitor.readLine();
		String[] macabra;
		int x, y;
		Vertice v;
		
		while(linha != null){
			macabra = linha.split(",");
			v = new Vertice(macabra[0]);
			x = Integer.parseInt(macabra[1]);
			y = Integer.parseInt(macabra[2]);
			v.setCoordenadas(x, y);
			graph.adicionarSetDeVertices(v);
			linha = leitor.readLine();
		}//termino da leitura
		leitor.close();
	}//leitura de coordenadas
	*/
}
