package model;

/* Herança: Responsavel herda de Pessoa, portanto, ele possui todos os campos (nome, numeroContato, cpfResponsavel) e métodos (getNome, setNome, getNumeroContato, setNumeroContato, getCpfResponsavel, setCpfResponsavel) da classe Pessoa.
Construtor: O construtor de Responsavel inicializa esses campos chamando o construtor da superclasse.
Método getIdentificacao: Implementa o método abstrato da superclasse para fornecer uma identificação específica para o responsável. */

public class Responsavel extends Pessoa {
    public Responsavel(String nome, String numeroContato, String cpfResponsavel) {
        super(nome, numeroContato, cpfResponsavel);
    }

/*utilizado no imprimir ficha
 * Com essas melhorias, a saída das informações do responsável fica mais clara e fácil de ler. Essa abordagem ajuda a garantir que os dados são apresentados de maneira organizada, o que pode ser especialmente útil em um sistema que exibe informações detalhadas sobre pessoas.*/
    @Override
    public String getIdentificacao() {
        return "Responsável: " + getNome() + "\n" +
               "Número para contato do Responsável: " + getNumeroContato() + "\n" +
               "CPF do responsável: " + getCpfResponsavel();
    }
}