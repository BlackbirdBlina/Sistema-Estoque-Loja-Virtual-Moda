package main.com.sistema.repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import main.com.sistema.annotation.InfoAutor;
import main.com.sistema.dominio.Roupa;

@InfoAutor(nome = "Sabrina Venceslau", data = "21/11/2025")
public class RepositorioRoupa implements Repositorio<Roupa> {
    private final HashMap<Integer, Roupa> map = new HashMap<>();

    @Override
    public void adicionar (Roupa roupa) {
        map.put(roupa.getId(), roupa);
    }

    @Override
    public Roupa buscar (int id) {
        return map.get(id);
    }

    @Override
    public void remover (int id) {
        map.remove(id);
    }

    @Override
    public List<Roupa> listar () {
        return new ArrayList<>(map.values());
    }

}
