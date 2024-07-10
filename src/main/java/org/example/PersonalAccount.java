package org.example;

public class PersonalAccount extends BankAccount{
    private String cpf;

    public PersonalAccount(String customerName, String billingAddress, Double initialBalance,String cpf, String password){

        super(customerName,billingAddress, initialBalance, password);
        this.cpf = cpf;
    }

    @Override
    public String getAccountDetails(){
        return "Personal Account [CPF:" + this.cpf + "]" ;
    }
}
