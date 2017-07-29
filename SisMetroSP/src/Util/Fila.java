
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
package Util;

public class Fila<T> implements IFila<T> {//Fila generica
    private Node head, tail;
    private int tamanho;

    private class Node{
        private Node next;
        private T dado;
        
        public Node(T data){
            this.dado = data;
        }
        
        public Node getNext(){
            return this.next;
        }
        public void setNext(Node proximo){
            this.next = proximo;
        }
        
        public T getDado(){
            return this.dado;
        }
        @SuppressWarnings("unused")
		public void setDado(T data){
            this.dado = data;
        }
    }
    
    public void inserirFinal(T data) { //adiciona
        if(head == null){
            head = tail = new Node(data);//cria o tail e head apontando para o mesmo nó
        }else{
            Node temp = tail;//o temp guarda o tail
            tail = new Node(data);//tail vira um novo nó
            temp.setNext(tail);//temp aponta para o novo nó, a cauda, tail - head continua lá de boas
        }
        tamanho++;
    }

    public T removerInicio() {
        T retirado = null;
        if(! estaVazia()){//se head n for null
            retirado = head.getDado();
            if(head == tail){//se tiver um nó com tail e head apontados a ele
                head = tail = null; //tudo vira null, e o GC elimina o espaço n usado
            }else{
                head = head.getNext();//só faz apontar para o proximo
            }
        tamanho--;//se entrar no if excluira de qualquer jeito       
        }
        return retirado;
    }
    
    public T peek() {
        return estaVazia() ? null : head.getDado();
    }

    public boolean estaVazia() {
        return head == null;
    }

    public int obterTamanho() {
        return tamanho;
    }

   
}


