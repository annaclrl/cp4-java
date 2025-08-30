package br.com.fiap.dao;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class TimeDAO {

    private Map<Integer, Time> times = new HashMap<>();
    private int nextId = 1;

    public void cadastrar(Time time) {
        times.put(nextId++, time);
    }

    public Map<Integer, Time> listar() {
        return new HashMap<>(times);
    }

    public Time pesquisarPorCodigo(int codigo) {
        return times.get(codigo);
    }

    public void remover(int codigo) {
        times.remove(codigo);
    }

    public void editar(int codigo, Time timeAtualizado) {
        if(times.containsKey(codigo)) {
            times.put(codigo, timeAtualizado);
        } else System.out.println("Time não encontrado!");
    }
}

