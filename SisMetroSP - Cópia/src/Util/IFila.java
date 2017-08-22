package Util;

public interface IFila<T> {
    public void inserirFinal(T objeto);
    public T removerInicio();
    public T peek(); 
    public int obterTamanho();
	public boolean estaVazia();     
}
