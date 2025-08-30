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
        info.append("Time: ").append(nome).append("\n");
        info.append("Treinador: ").append(treinador != null ? treinador.getNome() : "Não definido").append("\n");
        info.append("Atletas: \n");

        for (Atleta atleta : atletas) {
            info.append("  - ").append(atleta.getNome()).append(" (").append(atleta.getPosicao()).append(")\n");
        }
        return info.toString();
    }
}
