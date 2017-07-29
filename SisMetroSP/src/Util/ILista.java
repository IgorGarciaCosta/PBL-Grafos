package Util;

public interface ILista<T> {
	    public boolean estaVazia();
	    public int obterTamanho();
	    public void inserirInicio(T o);
	    public void inserirFinal(T o);
	    public void removerPeloIndice(int index);
	    public void removerObjeto(T dado);
	    //public T removerInicio();
	    //public T removerFinal();
	    //public T recuperar(int index);
	    public Iterador iterador();
}
