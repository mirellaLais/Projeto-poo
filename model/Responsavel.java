package model;

public class Responsavel extends Pessoa {
    public Responsavel(String nome) {
        super(nome);
    }

    @Override
    public String getIdentificacao() {
        return "Responsável: " + getNome();
    }

    @Override
    public String toString() {
        return "Responsavel{" +
                "nome='" + getNome() + '\'' +
                '}';
    }
}