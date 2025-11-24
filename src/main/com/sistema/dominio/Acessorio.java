package main.com.sistema.dominio;

public class Acessorio extends Produto {
    private final String material;
    private final String cor;

    public Acessorio (
        int id, String nome, double preco,
        String categoria, String material, String cor
        ) {
        super(id, nome, preco, categoria);
        this.material = material;
        this.cor = cor;
    }

    public String getMaterial() {
        return material;
    }

    public String getCor() {
        return cor;
    }
}
