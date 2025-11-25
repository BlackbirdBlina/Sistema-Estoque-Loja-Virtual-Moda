package main.com.sistema.dominio;

import main.com.sistema.annotation.Etiqueta;

@Etiqueta(marca = "Veste bem", paisOrigem = "Brasil")
public class Roupa extends Produto {
    private final String tamanho;
    private final String material;
    private final String cor;

    public Roupa(
        int id, String nome, double preco, String categoria,
        String tamanho, String material, String cor
        ) {
        super(id, nome, preco, categoria);
        this.tamanho = tamanho;
        this.material = material;
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getMaterial() {
        return material;
    }

    public String getCor() {
        return cor;
    }
}
