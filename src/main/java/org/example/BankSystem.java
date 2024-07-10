package org.example;


import java.util.HashMap;
import java.util.Scanner;

public class BankSystem {

    private HashMap<String, BankAccount> accountsDataBase;
    private Scanner scanner;

    public BankSystem(HashMap<String, BankAccount> accounts, Scanner scanner ){
      this.accountsDataBase = accounts;
       this.scanner = scanner;
    }

    public void createAccount(){
        System.out.println("Criando uma nova conta");
        System.out.println("Digite o nome do cliente: ");
        String name = scanner.nextLine();

        System.out.println("Digite o endereço de cobrança: ");
        String address = scanner.nextLine();

        System.out.println("Digite o saldo inicial: ");
        double balance = scanner.nextDouble();


        System.out.println("Digite uma senha: ");
        String password = scanner.nextLine();

        System.out.println("Digite o tipo da conta (1 para pessoa física, 2 para jurídica: ");
        int accountType = scanner.nextInt();
        scanner.nextLine();

        if(accountType == 1){
            System.out.println("Digite o cpf: ");
            String cpf = scanner.nextLine();
            PersonalAccount personalAccount = new PersonalAccount(name, address, balance, password,  cpf);
            accountsDataBase.put(cpf, personalAccount);
            System.out.println("Conta pessoal criada com sucesso");

        } else if (accountType == 2){
            System.out.println("Digite o cnpj: ");
            String cnpj = scanner.nextLine();
            BusinessAccount businessAccount = new BusinessAccount(name, address, balance, password,  cnpj);
            accountsDataBase.put(cnpj, businessAccount);
            System.out.println("Conta jurídica criada com sucesso");
        } else {
            System.out.println("Operação Inválida");
        }
    }

    public void login(String indentifier, String password){
        if (accountsDataBase.containsKey(indentifier)){
            BankAccount bankAccount = accountsDataBase.get(indentifier);
           boolean passwordMatch= bankAccount.verifyPassword(password);

           if (passwordMatch){
               System.out.println("Usuário logado com sucesso. Bem vindo(a)" + bankAccount.getCustomerName());


           }
        } else{
            System.out.println("Conta não encontrada");
        }
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