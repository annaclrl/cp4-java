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
        String timeNome = (time != null) ? time.getNome() : "Sem time";
        return String.format("Treinador: \n | Idade:  \n | Títulos: \n | Time: ",
                getNome(), getIdade(), titulos, timeNome);
    }
}
