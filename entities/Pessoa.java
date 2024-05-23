package entities;

public abstract class Pessoa {
    protected String nome;
    protected String responsavel;
    protected String endereco;
    protected String numero;

    public Pessoa(String nome, String responsavel, String endereco, String numero) {
        this.nome = nome;
        this.responsavel = responsavel;
        this.endereco = endereco;
        this.numero = numero;
    }

    public abstract void mostrarInformacoes();
}