package main.com.sistema.arvore;

import java.util.ArrayList;
import java.util.List;

public class ArvoreAVL<K extends Comparable<K>, V> implements Arvore<K, V> {
    private NohAVL<K, V> raiz;

    private int altura(NohAVL<K, V> noh) {
        return (noh == null) ? 0 : noh.getAltura();
    }

    private int fatorBalanceamento(NohAVL<K, V> noh) {
        return (noh == null) ? 0 : altura(noh.getEsquerda()) - altura(noh.getDireita());
    }

    private void atualizarAltura(NohAVL<K, V> noh) {
        int novaAltura = 1 + Math.max(altura(noh.getEsquerda()), altura(noh.getDireita()));
        noh.setAltura(novaAltura);
    }

    private NohAVL<K, V> rotacaoSimplesEsquerda(NohAVL<K, V> nohAlvo) {
        NohAVL<K, V> nohFilhoDireito = nohAlvo.getDireita();
        NohAVL<K, V> nohNetoEsquerdo = nohFilhoDireito.getEsquerda();
        nohAlvo.setDireita(nohNetoEsquerdo);
        nohFilhoDireito.setEsquerda(nohAlvo);

        atualizarAltura(nohAlvo);
        atualizarAltura(nohFilhoDireito);

        return nohFilhoDireito;
    }

    private NohAVL<K, V> rotacaoSimplesDireita(NohAVL<K, V> nohAlvo) {
        NohAVL<K, V> nohFilhoEsquerdo = nohAlvo.getEsquerda();
        NohAVL<K, V> nohNetoDireito = nohFilhoEsquerdo.getDireita();
        nohAlvo.setEsquerda(nohNetoDireito);
        nohFilhoEsquerdo.setDireita(nohAlvo);

        atualizarAltura(nohAlvo);
        atualizarAltura(nohFilhoEsquerdo);

        return nohFilhoEsquerdo;
    }

    private NohAVL<K, V> rotacaoDuplaEsquerda(NohAVL<K, V> nohAlvo) {
        NohAVL<K, V> nohNovoFilhoDireito = rotacaoSimplesDireita(nohAlvo.getDireita());
        nohAlvo.setDireita(nohNovoFilhoDireito);
        NohAVL<K, V> nohNovoPai = rotacaoSimplesEsquerda(nohAlvo);

        return nohNovoPai;
    }

    private NohAVL<K, V> rotacaoDuplaDireita(NohAVL<K, V> nohAlvo) {
        NohAVL<K, V> nohNovoFilhoEsquerdo = rotacaoSimplesEsquerda(nohAlvo.getEsquerda());
        nohAlvo.setEsquerda(nohNovoFilhoEsquerdo);
        NohAVL<K, V> nohNovoPai = rotacaoSimplesDireita(nohAlvo);

        return nohNovoPai;
    }

    @Override
    public void inserir(K chave, V valor) {
        raiz = inserirRecursivo(raiz, chave, valor);
    }

    private NohAVL<K, V> inserirRecursivo(NohAVL<K, V> noh, K chave, V valor) {
        if (noh == null) {
            return new NohAVL<>(chave, valor);
        }

        if (chave.compareTo(noh.getChave()) < 0) {
            NohAVL<K, V> novoNoh = inserirRecursivo(noh.getEsquerda(), chave, valor);
            noh.setEsquerda(novoNoh);
        } else if (chave.compareTo(noh.getChave()) > 0) {
            NohAVL<K, V> novoNoh = inserirRecursivo(noh.getDireita(), chave, valor);
            noh.setDireita(novoNoh);
        } else {
            noh.setValor(valor);
            return noh;
        }

        atualizarAltura(noh);

        int fatorBalanceamento = fatorBalanceamento(noh);

        // Pesa mais para o lado esquerdo
        if(fatorBalanceamento > 1 && chave.compareTo(noh.getEsquerda().getChave()) < 0) {
            return rotacaoSimplesDireita(noh);
        }

        // Pesa mais para o lado direito
        if(fatorBalanceamento < -1 && chave.compareTo(noh.getDireita().getChave()) > 0) {
            return rotacaoSimplesEsquerda(noh);
        }

        if(fatorBalanceamento > 1 && chave.compareTo(noh.getEsquerda().getChave()) > 0) {
            return rotacaoDuplaDireita(noh);
        }

        if(fatorBalanceamento < -1 && chave.compareTo(noh.getDireita().getChave()) > 0) {
            return rotacaoDuplaEsquerda(noh);
        }

        return noh;

    }

    @Override
    public V buscar(K chave) {
        NohAVL<K, V> noh = buscarRecursivo(raiz, chave);
        V resultado = (noh == null) ? null : noh.getValor();
        return resultado;
    }

    private NohAVL<K, V> buscarRecursivo(NohAVL<K, V> noh, K chave) {
        if (noh == null || noh.getChave().equals(chave)) {
            return noh;
        }

        if (chave.compareTo(noh.getChave()) < 0) {
            return buscarRecursivo(noh.getEsquerda(), chave);
        } else {
            return buscarRecursivo(noh.getDireita(), chave);
        }
    }

    @Override
    public List<V> emOrdem() {
        List<V> resultadoOrdenado = new ArrayList<>();
        emOrdemRecursivo(raiz, resultadoOrdenado);
        return resultadoOrdenado;
    }
    
    private void emOrdemRecursivo(NohAVL<K, V> noh, List<V> lista) {
        if (noh != null) {
            emOrdemRecursivo(noh.getEsquerda(), lista);
            lista.add(noh.getValor());
            emOrdemRecursivo(noh.getDireita(), lista);
        }
    }
}
