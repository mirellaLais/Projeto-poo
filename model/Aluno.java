package model;

public class Aluno {
    private String nome;
    private String serie;
    private int idade;
    private String dataNascimento;
    private String endereco;
    private Responsavel responsavel;

    public Aluno(String nome, String serie, int idade, String dataNascimento, String endereco, Responsavel responsavel) {
        this.nome = nome;
        this.serie = serie;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.responsavel = responsavel;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public String getNome() {
        return nome;
    }

    public void imprimirFicha() {
        System.out.println("Nome: " + nome);
        System.out.println("Série: " + serie);
        System.out.println("Idade: " + idade);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Endereço: " + endereco);
        System.out.println("Responsável: " + responsavel.getNome());
    }
}