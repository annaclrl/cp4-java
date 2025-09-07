package br.com.fiap.model;

public class Treinador extends Pessoa {
    private Time time;
    private int titulos;

    public Treinador(String nome, int idade, int titulos) {
        super(nome, idade);
        this.titulos = titulos;
        this.time = null;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getTitulos() {
        return titulos;
    }

    public void setTitulos(int titulos) {
        this.titulos = titulos;
    }

    @Override
    public String exibeInformacoes() {
        return "Treinador: " + getNome() +
                " | Idade: " + getIdade() +
                " | Títulos: " + titulos +
                " | Time: " + (time != null ? time.getNome() : "Sem time");
    }
}
