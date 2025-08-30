package br.com.fiap.dao;

import br.com.fiap.model.Pessoa;
import java.util.HashMap;
import java.util.Map;

public abstract class PessoaDAO<T extends Pessoa> {

    protected Map<Integer, T> armazenamento = new HashMap<>();
    protected int nextId = 1;

    public void cadastrar(T pessoa) {
        armazenamento.put(nextId++, pessoa);
    }

    public Map<Integer, T> listar() {
        return new HashMap<>(armazenamento);
    }

    public T pesquisarPorCodigo(int codigo) {
        return armazenamento.get(codigo);
    }

    public void remover(int codigo) {
        armazenamento.remove(codigo);
    }

    public T pesquisarPorNome(String nome) {
        for (T pessoa : armazenamento.values()) {
            if (pessoa.getNome().equalsIgnoreCase(nome)) return pessoa;
        }
        return null;
    }

    public abstract void editar(int codigo, T pessoaAtualizada);
}

