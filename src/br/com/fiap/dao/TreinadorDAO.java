package br.com.fiap.dao;

import br.com.fiap.model.Treinador;

public class TreinadorDAO extends PessoaDAO<Treinador> {

    @Override
    public void editar(int codigo, Treinador treinadorAtualizado) {
        Treinador treinador = armazenamento.get(codigo);
        if(treinador != null){
            treinador.setNome(treinadorAtualizado.getNome());
            treinador.setIdade(treinadorAtualizado.getIdade());
            treinador.setTitulos(treinadorAtualizado.getTitulos());
            treinador.setTime(treinadorAtualizado.getTime());
        } else System.out.println("Treinador não encontrado!");
    }
}

