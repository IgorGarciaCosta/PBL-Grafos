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
            head = tail = new Node(data);//cria o tail e head apontando para o mesmo n�
        }else{
            Node temp = tail;//o temp guarda o tail
            tail = new Node(data);//tail vira um novo n�
            temp.setNext(tail);//temp aponta para o novo n�, a cauda, tail - head continua l� de boas
        }
        tamanho++;
    }

    public T removerInicio() {
        T retirado = null;
        if(! estaVazia()){//se head n for null
            retirado = head.getDado();
            if(head == tail){//se tiver um n� com tail e head apontados a ele
                head = tail = null; //tudo vira null, e o GC elimina o espa�o n usado
            }else{
                head = head.getNext();//s� faz apontar para o proximo
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


