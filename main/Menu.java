package main;

import java.util.List;
import java.util.Scanner;

import exception.AlunoNotFoundException;
import exception.CampoNuloOuVazioException;
import exception.DataInvalidaException;
import exception.IdadeInvalidaException;
import exception.NomeInvalidoException;

import java.util.ArrayList;
import java.util.Collections;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import model.Aluno;
import model.Responsavel;

public class Menu implements MenuInterface {
    private Scanner scanner;
    private List<Aluno> alunos;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.alunos = new ArrayList<>();
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibirMenu();
    }

    public void exibirMenu() {
        int escolha = 0;

        do {
            System.out.println("Sistema de Matricula da Escola Municipal Iracema Nogueira Rabelo");
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. Realizar Matricula");
            System.out.println("2. Exibir Alunos Matriculados");
            System.out.println("3. Excluir");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                String escolhaStr = scanner.nextLine();
                if (!escolhaStr.isEmpty()) {
                    escolha = Integer.parseInt(escolhaStr);
                } else {
                    System.out.println("Entrada inválida. Digite um número.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
                continue;
            }

            switch (escolha) {
                case 1:
                    try {
                        realizarMatricula();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    exibirAlunosMatriculados();
                    break;
                case 3:
                    try {
                        excluirAluno();
                    } catch (AlunoNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (escolha != 4);

        scanner.close();
    }

    @Override
    public void realizarMatricula() throws CampoNuloOuVazioException, IdadeInvalidaException, NomeInvalidoException, DataInvalidaException {
        boolean dadosValidos = false;
        while (!dadosValidos) {
            System.out.println("#### Realizar Matricula ####");
            System.out.println();
            System.out.println("Dados do Aluno:");

            System.out.print("Nome do Aluno: ");
            String nome = scanner.nextLine();

            System.out.print("Série: ");
            String serie = scanner.nextLine();

            System.out.print("Idade: ");
            String idadeStr = scanner.nextLine();

            System.out.print("Data de nascimento: ");
            String dataNascimento = scanner.nextLine();

            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();

            System.out.println("Dados do Responsável:");

            System.out.print("Nome do Responsável: ");
            String nomeResponsavel = scanner.nextLine();

            System.out.println("CPF do Responsável: ");
            String cpfResponsavel = scanner.nextLine();

            System.out.println("Telefone para contato do responsável: ");
            String numeroContato = scanner.nextLine();

            if (nome.isEmpty() || serie.isEmpty() || idadeStr.isEmpty() || dataNascimento.isEmpty() || endereco.isEmpty()) {
                throw new CampoNuloOuVazioException(nome.isEmpty() ? "nome" : serie.isEmpty() ? "serie" : idadeStr.isEmpty() ? "idade" : dataNascimento.isEmpty() ? "dataNascimento" : "endereco");
            }

            int idade;
            try {
                idade = Integer.parseInt(idadeStr);
                if (idade < 0) {
                    throw new IdadeInvalidaException("Idade Inválida, A idade deve ser um número não negativo.");
                }
            } catch (NumberFormatException e) {
                throw new IdadeInvalidaException("Idade Inválida, Digite apenas números.");
            }

            Responsavel responsavel = new Responsavel(nomeResponsavel, cpfResponsavel, numeroContato);
            Aluno aluno = new Aluno(nome, serie, idade, dataNascimento, endereco, responsavel);

            if (!nome.matches("^[a-zA-Z\\s]+$")) {
                throw new NomeInvalidoException();
            }

            try {
                LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                throw new DataInvalidaException();
            }

            alunos.add(aluno);
            System.out.println("Aluno matriculado com sucesso!");
            dadosValidos = true;
        }
    }

    @Override
    public void exibirAlunosMatriculados() {
        Collections.sort(alunos, (a1, a2) -> a1.getNome().compareToIgnoreCase(a2.getNome()));
        System.out.println("#### RELATÓRIO DE ALUNOS #####");
        for (Aluno a : alunos) {
            a.imprimirFicha();
            System.out.println(a.getResponsavel().getIdentificacao());
            System.out.println();
        }
    }

    @Override
    public void excluirAluno() throws AlunoNotFoundException {
        System.out.print("Nome do Aluno para excluir: ");
        String nomeParaExcluir = scanner.nextLine();
        Aluno alunoParaExcluir = null;

        for (Aluno a : alunos) {
            if (a.getNome().equalsIgnoreCase(nomeParaExcluir)) {
                alunoParaExcluir = a;
                break;
            }
        }

        if (alunoParaExcluir != null) {
            alunos.remove(alunoParaExcluir);
            System.out.println("Aluno removido com sucesso!");
        } else {
            throw new AlunoNotFoundException("Aluno não encontrado");
        }
    }
}