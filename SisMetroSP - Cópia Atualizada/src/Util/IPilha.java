package Util;

public interface IPilha<T> {
    public boolean estaVazia();
    public T pull();
    public void push(T data);
    public T peek();
    public int size();
}

