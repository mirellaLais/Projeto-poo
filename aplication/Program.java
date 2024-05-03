package aplication;
import java.util.Scanner;

import entities.Aluno;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
    
        System.out.println("Matricula Escolar");
        System.out.println("Por favor, insira as informações do aluno:");
        
        System.out.print("\nNome do aluno (Completo): ");
		String nome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.print("Data de nascimento (DD/MM/AAAA): ");
        String dataNascimento = sc.nextLine();

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        System.out.print("Nome do responsável: ");
        String responsavel = sc.nextLine();

        System.out.print("Telefone para contato: ");  
        String telefone = sc.nextLine();

        System.out.print("Série desejada: ");
        int serie = sc.nextInt();
    
        System.out.println("\nProcessando matrícula...");

        Aluno Aluno = new Aluno(nome, dataNascimento, responsavel, endereco, telefone, idade, serie);

        System.out.println("\nMatrícula realizada com sucesso para o/a aluno(a) " + Aluno.getNome());
        System.out.println("Série: " + Aluno.getSerie(serie));
        System.out.println("Data de nascimento e idade: " + Aluno.getDataNascimento() + ", " + Aluno.getIdade(idade) + " anos");
        System.out.println("Endereço: " + Aluno.getEndereco());
        System.out.println("Responsável: " + Aluno.getResponsavel());
        System.out.println("Telefone de contato: " + Aluno.getTelefone());   
    
    sc.close();

    }
}