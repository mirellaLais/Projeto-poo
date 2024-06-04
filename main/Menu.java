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

public class Menu {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;
        List<Aluno> alunos = new ArrayList<>();

        escolha = 0;

        do {
            System.out.println("Sistema de Matricula da Escola Municipal Iracema Nogueira Rabelo");
            System.out.println("Menu:");
            System.out.println("1. Realizar Matricula");
            System.out.println("2. Exibir Alunos Matriculados");
            System.out.println("3. Excluir");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
               
                String escolhaStr = scanner.nextLine(); // Lê a escolha como string
                if (!escolhaStr.isEmpty()) { // Verifica se a string não está vazia
                    escolha = Integer.parseInt(escolhaStr); // Converte para inteiro
                } else {
                    System.out.println("Entrada inválida. Digite um número.");
                    continue; // Volta para o menu
                }
            } catch (NumberFormatException e) { // Captura erro de conversão
                System.out.println("Entrada inválida. Digite um número.");
                continue; // Volta para o menu
            } 
        

        
            switch (escolha) {
                case 1:
                // Loop para garantir que os dados foram escritos corretamente
                boolean dadosvalidos = false;
                   while (!dadosvalidos) {

                    try{
                    System.out.println("Realizar Matricula");

                    System.out.print("Nome do Aluno: ");
                    String nome = scanner.nextLine();

                    System.out.print("Série: ");
                    String serie = scanner.nextLine();

                    System.out.print("Idade: ");
                    String idadeStr = scanner.nextLine();// Consumir a nova linha

                    System.out.print("Data de nascimento: ");
                    String dataNascimento = scanner.nextLine();

                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();

                    System.out.print("Nome do Responsável: ");
                    String nomeResponsavel = scanner.nextLine();
                    
                    // Validação se os dados estão vazios ou não
                    if (nome.isEmpty() || serie.isEmpty() || idadeStr.isEmpty() || dataNascimento.isEmpty() || endereco.isEmpty()) {
                        throw new CampoNuloOuVazioException(nome.isEmpty() ? "nome" : serie.isEmpty() ? "serie" : idadeStr.isEmpty() ? "idade" : dataNascimento.isEmpty() ? "dataNascimento" : "endereco");
                    }
                    
                    //Converção da idade para int
                    int idade;
                    try {
                        idade = Integer.parseInt(idadeStr);
                        if (idade < 0) {
                            throw new IdadeInvalidaException("Idade Inválida, A idade deve ser um número não negativo.");
                        }
                    } catch (NumberFormatException  e) {
                        throw new IdadeInvalidaException("Idade Inválida, Digite apenas numeros.");
                    }
                    
                    Responsavel responsavel = new Responsavel(nomeResponsavel);
                    
                    // Criar instância de Aluno e adicionar à lista
                    Aluno aluno = new Aluno(nome, serie, idade, dataNascimento, endereco, responsavel);
                    alunos.add(aluno);
                    
                    // Verifica se foram usadas letras no nome
                    if (!nome.matches("^[a-zA-Z\\s]+$")) {
                        throw new NomeInvalidoException();
                    }
                    // Verifica se o formado da data de nascimento esta correta
                    try {
                        LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    } catch (DateTimeParseException  e) {
                        throw new DataInvalidaException();
                    }
                    
                    System.out.println("Aluno matriculado com sucesso!");
                    dadosvalidos = true;
                
                    // Executa as exceções
                    } catch (CampoNuloOuVazioException e) {
                    System.out.println(e.getMessage());
                    } catch (IdadeInvalidaException e) {
                        System.out.println(e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Idade inválida. Digite apenas números.");
                    } catch (NomeInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
                    catch (DataInvalidaException e) {
                        System.out.println(e.getMessage());
                    }
                }
                    break; // Retorna ao menu principal
                        

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

                    try { 
                        if (alunoParaExcluir != null) {
                            alunos.remove(alunoParaExcluir);
                            System.out.println("Aluno removido com sucesso!");
                    } else {
                        throw new AlunoNotFoundException("Aluno não encontrado");
                    } 
                 } catch (AlunoNotFoundException e){
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
}
