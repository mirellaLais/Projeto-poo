package entities;

public class Aluno extends Pessoa implements Matriculavel {
    private int matriculaId;
    private String serie;  // Adicionando atributo série

    public Aluno(String nome, String cpf, int matriculaId, String serie) {
        super(nome, cpf);
        this.matriculaId = matriculaId;
        this.serie = serie;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Aluno: " + nome + ", CPF: " + cpf + ", Matrícula: " + matriculaId + ", Série: " + serie);
    }

    @Override
    public void matricular() {
        System.out.println("Aluno " + nome + " matriculado com sucesso na série " + serie + ".");
    }

    public static void mostrarSaudacao() {
        System.out.println("Bem-vindo ao sistema de matrículas do Ensino Fundamental 1!");
    }

    public String getSerie() {
        return serie;
    }
}