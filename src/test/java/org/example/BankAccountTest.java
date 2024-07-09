package org.example;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    private PersonalAccount personalAccount;

    @Before

    public void setUp(){
        personalAccount = new PersonalAccount("Hilary Castelar", "Rua 123", 1000.0 ,"123.123.132-13");
    }

    @Test
    public void depositAddMoneyToAccount(){
        personalAccount.deposit(500);

        assertEquals(1500, personalAccount.getBalance(), 0.01);
    }

}