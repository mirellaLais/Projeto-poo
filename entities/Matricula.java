package entities;

public class Matricula {
    private Aluno aluno;

    public Matricula(Aluno aluno) {
        this.aluno = aluno;
    }

    public void exibirDetalhes() {
        System.out.println("Matrícula do Aluno: " + aluno.nome + " na Série: " + aluno.getSerie());
    }
}