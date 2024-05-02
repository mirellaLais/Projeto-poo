package aplication;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
    
        System.out.println("Matricula Escolar");
        System.out.println("Por favor, insira as informações do aluno:");
        
        System.out.print("\nNome do aluno: ");
		String nome = sc.nextLine();

        System.out.print("Data de nascimento (DD/MM/AAAA): ");
        String dataNascimento = sc.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();

        System.out.print("Nome do responsável: ");
        String responsavel = sc.nextLine();

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        System.out.print("Telefone para contato: ");
        String telefone = sc.nextLine();

        System.out.print("Série desejada: ");
        int serie = sc.nextInt();
    
        System.out.println("\nProcessando matrícula...");

        System.out.println("\nMatrícula realizada com sucesso para o/a aluno(a) " + nome);
        System.out.println("Série: " + serie);
        System.out.println("Data de nascimento e idade: " + dataNascimento + ", " + idade + " anos");
        System.out.println("Endereço: " + endereco);
        System.out.println("Responsável: " + responsavel);
        System.out.println("Telefone de contato: " + telefone);   

    sc.close();

    }
}