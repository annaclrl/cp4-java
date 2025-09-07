package br.com.fiap.model;

import java.util.ArrayList;
import java.util.List;

public class Time {
    private String nome;
    private List<Atleta> atletas;
    private Treinador treinador;

    public Time(String nome) {
        this.nome = nome;
        this.atletas = new ArrayList<>();
        this.treinador = null;
    }

    public String getNome() {
        return nome;
    }

    public List<Atleta> getAtletas() {
        return atletas;
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public void addAtleta(Atleta atleta) {
        atletas.add(atleta);
        atleta.setTime(this);
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
        treinador.setTime(this);
    }

    public String exibeInformacoes() {
        StringBuilder info = new StringBuilder();
        info.append("Time: ").append(getNome())
                .append(" | Treinador: ")
                .append(getTreinador() != null ? getTreinador().getNome() : "Não definido")
                .append(" | Atletas: ");

        if (getAtletas() != null && !getAtletas().isEmpty()) {
            for (Atleta atleta : getAtletas()) {
                info.append(atleta.getNome())
                        .append(" (").append(atleta.getPosicao()).append("), ");
            }
            // remove a última vírgula e espaço
            info.setLength(info.length() - 2);
        } else {
            info.append("Nenhum atleta cadastrado");
        }

        return info.toString();
    }

}