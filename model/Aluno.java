package model;

import java.util.Date;

public class Aluno {
    private String nome;
    private int serie;
    private int idade;
    private String endereco;
    private Date dataNascimento;
    private Responsavel responsavel;
    private String numeroMatricula;

    public Aluno(String nome, int serie, int idade, String endereco, Date dataNascimento, Responsavel responsavel) {
        this.nome = nome;
        this.serie = serie;
        this.idade = idade;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.responsavel = responsavel;
        this.numeroMatricula = Util.generateMatriculaNumber();
    }

    // Getters e Setters
    // toString method override
}