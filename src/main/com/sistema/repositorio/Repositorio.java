package main.com.sistema.repositorio;

import java.util.List;

public interface Repositorio<T> {
    void adicionar (T produto);
    T buscar (int id);
    void remover (int id);
    List<T> listar ();
}
