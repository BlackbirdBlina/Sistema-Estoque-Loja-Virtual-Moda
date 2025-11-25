package main.com.sistema.excecao;

public class NegocioException extends Exception {
    public NegocioException(String mensagem) {
        super(mensagem);
    }
}
