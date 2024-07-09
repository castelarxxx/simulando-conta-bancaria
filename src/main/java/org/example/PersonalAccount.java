package org.example;

public class PersonalAccount extends BankAccount{
    private String cpf;

    public PersonalAccount(String customerName, String billingAddress, Double initialBalance,String cpf){

        super(customerName,billingAddress, initialBalance);
        this.cpf = cpf;
    }

}
