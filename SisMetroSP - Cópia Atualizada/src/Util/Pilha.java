package Util;

import Util.IPilha;

public class Pilha<T> implements IPilha<T>{
    private Node head;
    private int size;

    private class Node{
      private Node next; // proximo no
      private T dado;  //dado armazenado
      
        public Node(T data){
            this.dado = data;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public T getDado(){
            return dado;
        }
    
    }
    
    public void push(T data){
        Node temp = head;// vc guarda a cabeça
        head = new Node(data);//vc seta a nova cabeça
        head.setNext(temp);//vc aponta esse novo nó para antiga cabeça
        size++;
    }

    public T pull() {
       if(!estaVazia()){
           Node temp = head;//guarda a cabeça
           head = head.getNext();//pega o proximo nó
           size--;
           return temp.getDado();//retorna o nó que estava na cabeça
       }
       return null;
    }

    public T peek() {
        return estaVazia() ? null : head.getDado();//return true se head for null, se não, retorna o dado da cabeça
    }

    public boolean estaVazia() {
        return head == null;
    }

    public int size(){
    	return this.size;
    }
}
