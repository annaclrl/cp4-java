package br.com.fiap.model;

public class Atleta extends Pessoa {
    private String posicao;
    private Time time;

    public Atleta(String nome, int idade, String posicao) {
        super(nome, idade);
        this.posicao = posicao;
        this.time = null;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String exibeInformacoes() {
        String timeNome = (time != null) ? time.getNome() : "Sem time";
        return String.format("Atleta: \n | Idade:  \n | Posição: \n | Time: ",
                getNome(), getIdade(), posicao, timeNome);
    }
}