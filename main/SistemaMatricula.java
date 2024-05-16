package main;

import entities.*;
import java.util.Scanner;

public class SistemaMatricula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Aluno.mostrarSaudacao();

            // Entrada de dados do usuário para criar um aluno
            System.out.print("Digite o nome do aluno: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o CPF do aluno: ");
            String cpf = scanner.nextLine();

            System.out.print("Digite o ID de matrícula do aluno: ");
            int matriculaId = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            System.out.print("Digite a série do aluno: ");
            String serie = scanner.nextLine();

            Aluno aluno = new Aluno(nome, cpf, matriculaId, serie);
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