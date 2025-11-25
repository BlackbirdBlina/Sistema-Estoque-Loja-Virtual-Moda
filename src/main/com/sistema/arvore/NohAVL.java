package main.com.sistema.arvore;

public class NohAVL<K, V> {
    private final K chave;
    private V valor;
    private NohAVL<K, V> esquerda;
    private NohAVL<K, V> direita;
    int altura;

    NohAVL(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.altura = 1;
    }

    public K getChave() {
        return chave;
    }

    public V getValor() {
        return valor;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int novaAltura){
        this.altura = novaAltura;
    }

    public NohAVL<K, V> getEsquerda() {
        return esquerda;
    }

    public NohAVL<K, V> getDireita() {
        return direita;
    }

    public void setEsquerda(NohAVL<K, V> noh) {
        this.esquerda = noh;
    }

    public void setDireita(NohAVL<K, V> noh) {
        this.direita = noh;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }
}
