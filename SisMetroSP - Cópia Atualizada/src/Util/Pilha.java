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
        Node temp = head;// vc guarda a cabe�a
        head = new Node(data);//vc seta a nova cabe�a
        head.setNext(temp);//vc aponta esse novo n� para antiga cabe�a
        size++;
    }

    public T pull() {
       if(!estaVazia()){
           Node temp = head;//guarda a cabe�a
           head = head.getNext();//pega o proximo n�
           size--;
           return temp.getDado();//retorna o n� que estava na cabe�a
       }
       return null;
    }

    public T peek() {
        return estaVazia() ? null : head.getDado();//return true se head for null, se n�o, retorna o dado da cabe�a
    }

    public boolean estaVazia() {
        return head == null;
    }

    public int size(){
    	return this.size;
    }
}
