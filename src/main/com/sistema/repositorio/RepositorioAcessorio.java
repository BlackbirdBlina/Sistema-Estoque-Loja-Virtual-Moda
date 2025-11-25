package main.com.sistema.repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import main.com.sistema.dominio.Acessorio;

public class RepositorioAcessorio implements Repositorio<Acessorio> {
    private final HashMap<Integer, Acessorio> map = new HashMap<>();

    @Override
    public void adicionar (Acessorio acessorio) {
        map.put(acessorio.getId(), acessorio);
    }

    @Override
    public Acessorio buscar (int id) {
        return map.get(id);
    }

    @Override
    public void remover (int id) {
        map.remove(id);
    }

    @Override
    public List<Acessorio> listar () {
        return new ArrayList<>(map.values());
    }

}
