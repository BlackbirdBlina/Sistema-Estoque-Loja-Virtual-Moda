package main.com.sistema.arvore;

import java.util.List;

public interface Arvore<K, V> {
    void inserir(K chave, V valor);
    V buscar(K chave);
    List<V> emOrdem();
}

