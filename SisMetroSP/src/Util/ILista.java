
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
