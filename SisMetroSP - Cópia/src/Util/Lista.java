package Util;

public class Lista<T> implements ILista<T> {
    int indice;
    private No head;
    private No tail;
    private int tamanho;
    
    private class No {
        private T dado;
        private No next; 
        public No(T dado){
            this.dado = dado;
        }

        public No getNext(){
            return next;
        }

        public void setNext(No next){
            this.next = next;
        }

        public T getDado(){
            return dado;
        }

        public void setDado(T dado){
            this.dado = dado;
        }
    
    }
    
    private No getNo (int indice){
        if(indice >= 0 && indice <= obterTamanho()){ 
           No n = head;
            for(int i = 0; i< indice; i++){
                n = n.getNext();
            }
            return n;
        }
        return null;
    }
    
    public void set (int indice, T dado){
        No n = getNo(indice);
        if(n != null) {
            n.setDado(dado);
        }
    }
    
    public T get (int indice) {
        No n = getNo(indice);
        if (n != null) {
            return n.getDado();
        }
        return null;
    }
    
    public boolean estaVazia(){
        if(obterTamanho() == 0){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean contem(T dado){
        for(No n = head; n != null; n.getNext()){
            if(n.getDado() != null && n.getDado().equals(dado)){
               return true;
            }
        }    
        return false;
    }
    
    public void add (T dado){
        if(estaVazia()) { //adiciona o primeiro item
            head = new No(dado);
        } else{
            No n = getNo(obterTamanho() - 1);
            n.setNext(new No(dado));
        }
        tamanho++;
    }
    
    public void inserirInicio (T dado){
        No temp = head;
        head = new No((T) dado);
        head.setNext(temp);
    }
    
    public void removerPeloIndice(int indice){
        if(indice == 0){                                                    //remove o primeiro
            head = head.getNext();
        } else if(indice > 0 && indice <= (obterTamanho() - 1)){            //remove do meio
            No prev = getNo(indice - 1);
            No remNo = prev.getNext();
            prev.setNext(remNo.getNext());
        }
        tamanho--;
    }
    
    public void removerObjeto(T dado){//remove os objetos que receber aqui
        No n = head;
        for(int i = 0; n != null; i++){
            if(n.getDado() != null && n.getDado().equals(dado)){
                removerPeloIndice(i);//aqui Ã¡ remove o tamanho
            }
            n = n.getNext();
        }
    }
    
    public int obterTamanho (){
        tamanho = 0;
        for(No n = head; n!= null; n = n.getNext()){
            tamanho++;
        }
        return tamanho;
    }
    
    public void inserirFinal (T dado) {//nao esta¡ sendo usado
        if(estaVazia()) { //adiciona o primeiro item
           head = tail = new No((T) dado);
        } else{
           tail.setNext(new No((T) dado));
           tail = tail.getNext();
        } 
        tamanho++;
    }
    
    public Iterador iterador (){
        return new Iterator();
    }
        
    public class Iterator implements Iterador{
        private int cur = 0;//cursor
        
        public boolean temProximo() {
            return getNo(cur) != null;//se encontrar, true, else false
        }
        
        public T obterProximo() {
            T dado = get(cur);//passa o no para o dado
            cur++;//incrementa o sursor
            return dado;
        }
    }
    
}
