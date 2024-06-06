package model;

/* A classe Pessoa define uma estrutura comum para qualquer tipo de pessoa no sistema, seja um aluno ou um responsável. Ela encapsula atributos comuns (nome, numeroContato, cpfResponsavel) e métodos (getNome, setNome, getNumeroContato, setNumeroContato, getCpfResponsavel, setCpfResponsavel). Além disso, ela declara um método abstrato (getIdentificacao) que deve ser implementado por qualquer classe concreta que herde de Pessoa. Isso permite que cada tipo de pessoa forneça sua própria implementação do método de identificação, promovendo a flexibilidade e a reutilização de código. */

public abstract class Pessoa {
    private String nome;
    private String numeroContato;
    private String cpfResponsavel;

    public Pessoa(String nome, String numeroContato, String cpfResponsavel) {
        this.nome = nome;
        this.numeroContato = numeroContato;
        this.cpfResponsavel = cpfResponsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroContato() {
        return numeroContato;
    }

    public void setNumeroContato(String numeroContato) {
        this.numeroContato = numeroContato;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }
    
    public abstract String getIdentificacao();
}