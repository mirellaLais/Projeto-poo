package main;

import entities.*;
import java.util.Scanner;

public class SistemaMatricula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Aluno.mostrarSaudacao();

            // Entrada de dados do usuário para criar um aluno
            System.out.print("Digite o nome do(a) aluno(a): ");
            String nome = scanner.nextLine();

            System.out.print("Digite o nome do responsável: ");
            String responsavel = scanner.nextLine();

            System.out.print("Digite o telefone para contato: ");
            String numero = scanner.nextLine();

            System.out.print("Digite o endereço: ");
            String endereco = scanner.nextLine();

            System.out.print("Digite a série desejada: ");
            String serie = scanner.nextLine();

            System.out.print("Digite o ID de matrícula do aluno: ");
            int matriculaId = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

             // Criação do objeto Aluno usando o construtor definido
            Aluno aluno = new Aluno(nome, responsavel, numero, endereco, matriculaId, serie);
            //uso do objeto aluno
            aluno.mostrarInformacoes();
            aluno.matricular();

            Matricula matricula = new Matricula(aluno);
            matricula.exibirDetalhes();

        } catch (Exception e) {
            System.out.println("Ocorreu um erro no sistema de matrículas: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}