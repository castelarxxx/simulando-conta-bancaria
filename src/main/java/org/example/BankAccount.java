package org.example;


import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {
    private String customerName;
    private String billingAddress;
    private Double balance;
    private String password;
    private List<String> transactions;

    public BankAccount(String customerName, String billingAddress, Double initialBalance, String password){
        this.customerName = customerName;
        this.billingAddress = billingAddress;
        this.password = password;
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

    public String getCustomerName(){
        return this.customerName;
    }

    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            transactions.add("Saque" + amount);
        } else {
            transactions.add("Falha na tentativa de saque: " + amount);
        }
    }

    public boolean verifyPassword(String typedPassword){
        if (typedPassword.equals(password)){
          return true;
        } else {
            return false;
        }
    }

    public abstract String getAccountDetails();

}
