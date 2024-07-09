package org.example;


import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {
    private String customerName;
    private String billingAddress;
    private Double balance;
    private List<String> transactions;

    public BankAccount(String customerName, String billingAddress, Double initialBalance){
        this.customerName = customerName;
        this.billingAddress = billingAddress;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        this.transactions.add("Saldo Inicial" + initialBalance);

    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Depósito" + amount);
        } else{
            transactions.add("Falha na tentatativa de Depósito:" + amount);
        }
    }

    public void printStatement(){
        System.out.println("Extrato para: " + customerName);

        for (String transaction : transactions){
            System.out.println(transaction);
        }
        System.out.println("Saldo Atual" + balance);
    }

    public double getBalance() {
        return this.balance;
    }

    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            transactions.add("Saque" + amount);
        } else {
            transactions.add("Falha na tentativa de saque: " + amount);
        }
    }

    public abstract String getAccountDetails();

}
