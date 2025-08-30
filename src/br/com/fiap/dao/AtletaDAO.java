package br.com.fiap.dao;

import br.com.fiap.model.Atleta;

public class AtletaDAO extends PessoaDAO<Atleta> {

    @Override
    public void editar(int codigo, Atleta atletaAtualizado) {
        Atleta atleta = armazenamento.get(codigo);
        if(atleta != null){
            atleta.setNome(atletaAtualizado.getNome());
            atleta.setIdade(atletaAtualizado.getIdade());
            atleta.setPosicao(atletaAtualizado.getPosicao());
            atleta.setTime(atletaAtualizado.getTime());
        } else System.out.println("Atleta não encontrado!");
    }
}
