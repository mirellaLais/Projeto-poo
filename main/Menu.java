package main;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import model.Aluno;
import model.Responsavel;

public class Menu {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;
        List<Aluno> alunos = new ArrayList<>();

        do {
            System.out.println("Sistema de Matricula da Escola Municipal Iracema Nogueira Rabelo");
            System.out.println("Menu:");
            System.out.println("1. Realizar Matricula");
            System.out.println("2. Exibir Alunos Matriculados");
            System.out.println("3. Excluir");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (escolha) {
                case 1:
                    System.out.println("Realizar Matricula");

                    System.out.print("Nome do Aluno: ");
                    String nome = scanner.nextLine();

                    System.out.print("Série: ");
                    String serie = scanner.nextLine();

                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha

                    System.out.print("Data de nascimento: ");
                    String dataNascimento = scanner.nextLine();

                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();

                    System.out.print("Nome do Responsável: ");
                    String nomeResponsavel = scanner.nextLine();
                    Responsavel responsavel = new Responsavel(nomeResponsavel);

                    // Criar instância de Aluno e adicionar à lista
                    Aluno aluno = new Aluno(nome, serie, idade, dataNascimento, endereco, responsavel);
                    alunos.add(aluno);

                    System.out.println("Aluno matriculado com sucesso!");
                    break;

                case 2:
                    // Exibir alunos matriculados
                    Collections.sort(alunos, (a1, a2) -> a1.getNome().compareToIgnoreCase(a2.getNome()));
                    System.out.println("#### RELATORIO DE ALUNOS #####");
                    for (Aluno a : alunos) {
                        a.imprimirFicha();
                    }
                    break;

                case 3:
                    // Excluir aluno
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
                        System.out.println("Aluno não encontrado.");
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
}
