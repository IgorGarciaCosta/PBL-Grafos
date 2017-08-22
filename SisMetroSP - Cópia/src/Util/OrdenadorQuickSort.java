package Util;

import Model.Vertice;

public class OrdenadorQuickSort {
	
	Vertice vertices[];//vetor
	int tamanho;//comprimento

	    
    public void sort(Vertice vetor[]) {
        if (vetor == null || vetor.length == 0) {//se estiver vazia, retorna nulo
            return;
        }else 
	        this.vertices = vetor;//vetor vertices recebe as palavras
	        this.tamanho = vetor.length;//tamanho recebe o comprimento de words
	        quickSort(0, tamanho - 1);//manda 0 e o comprimento pra o metodo
	}

    void quickSort(int menorIndice, int maiorIndice) {
        int i = menorIndice;
        int j = maiorIndice;
        Vertice pivot = this.vertices[menorIndice + (maiorIndice - menorIndice) / 2];
        //o pivot recebe um Vertice na posição proxima ao meio
        
        while (i <= j) {
            while (this.vertices[i].getEstacao().compareTo(pivot.getEstacao()) < 0) {
                i++;
            }

            while (this.vertices[j].getEstacao().compareTo(pivot.getEstacao()) > 0) {
                j--;
            }

            if (i <= j) {
                trocarvertices(i, j);
                i++;
                j--;
            }
        }
        
        //enquanto n ordenar, troque
        if (menorIndice < j) {
            quickSort(menorIndice, j);
        }
        if (i < maiorIndice) {
            quickSort(i, maiorIndice);
        }
    }

    void trocarvertices(int i, int j) {
        String temp = this.vertices[i].getEstacao();
        this.vertices[i] = this.vertices[j];
        this.vertices[j].setEstacao(temp);
    }
    
}
