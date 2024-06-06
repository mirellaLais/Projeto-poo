package main;

/*Interface MenuInterface: Define os métodos que a classe Menu deve implementar.
Classe Menu: Implementa MenuInterface e define a lógica de matrícula, exibição e exclusão de alunos.
Método main: Cria uma instância de Menu e exibe o menu para interagir com o usuário.*/

import exception.AlunoNotFoundException;
import exception.CampoNuloOuVazioException;
import exception.DataInvalidaException;
import exception.IdadeInvalidaException;
import exception.NomeInvalidoException;

public interface MenuInterface {
    void realizarMatricula() throws CampoNuloOuVazioException, IdadeInvalidaException, NomeInvalidoException, DataInvalidaException;
    void exibirAlunosMatriculados();
    void excluirAluno() throws AlunoNotFoundException;
}
