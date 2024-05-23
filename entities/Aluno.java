package entities;

public class Aluno extends Pessoa implements Matriculavel {
    private int matriculaId;
    private String serie;  // Adicionando atributo série

    //construtor
    public Aluno(String nome, String responsavel, String endereco, String numero, int matriculaId, String serie) {
        super(nome, responsavel, endereco, numero);
        this.matriculaId = matriculaId;
        this.serie = serie;
    }

    //sobrescrevendo um método e não criando um novo (@override)
    @Override
    public void mostrarInformacoes() {
        System.out.println("Aluno(a): " + nome + ", Responsável: " + responsavel + ", Matrícula: " + matriculaId + ", Série: " + serie);
    }

    //sobrescrevendo um método e não criando um novo (@override)
    @Override
    public void matricular() {
        System.out.println("Aluno(a) " + nome + " matriculado(a) com sucesso na série " + serie + ".");
    }

    // static: significa que o método pode ser chamado sem que a classe seja instanciada em um objeto. Void: é o tipo de dado do retorno do método, void é usado quando o método não retorna nada
    public static void mostrarSaudacao() {
        System.out.println("Bem-vindo ao sistema de matrículas do Ensino Fundamental 1!");
    }

    public String getSerie() {
        return serie;
    }
}