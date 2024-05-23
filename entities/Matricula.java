package entities;

public class Matricula {
    private Aluno aluno;

    public Matricula(Aluno aluno) {
        this.aluno = aluno;
    }

    public void exibirDetalhes() {
        System.out.println("Aluno(a) " + aluno.nome + " matriculado(a) na Série " + aluno.getSerie()+ " com sucesso!");
    }
}