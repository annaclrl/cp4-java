package br.com.fiap.dao;

import br.com.fiap.model.Time;
import java.util.HashMap;
import java.util.Map;

public class TimeDAO {
    ;
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

    public Time pesquisarPorNome(String nome) {
        String nomeBusca = nome.trim();
        for (Time time : times.values()) {
            if (time.getNome().trim().equalsIgnoreCase(nomeBusca)) {
                return time;
            }
        }
        return null;
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