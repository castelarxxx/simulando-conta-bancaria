package org.example;


import java.util.HashMap;
import java.util.Scanner;

public class BankSystem {

    private HashMap<String, BankAccount> accounts;
    private Scanner scanner;

    public BankSystem(HashMap<String, BankAccount> accounts, Scanner scanner ){
      this.accounts = accounts;
       this.scanner = scanner;
    }
    public static void main(String[] args) {
        HashMap<String, BankAccount> accounts = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        BankSystem banksystem = new BankSystem(accounts,  scanner);

        int option;

        do {
            System.out.println("Seja bem-vindo ao cubos Bank");
            System.out.println("1.Login");
            System.out.println("2. Criar Conta");
            System.out.println("3.Deletar Conta");
            System.out.println("0. Sair");
            System.out.println("Digite a Opção desejada: ");


            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Operação Inválida, tente novamente.");
            }

        } while(option != 0);

    }
}