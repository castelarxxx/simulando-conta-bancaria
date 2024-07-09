package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)

public class BankAccountTest {

    @Mock
    private PrintStream mockPrintStream;

    private PersonalAccount personalAccount;
    private BusinessAccount businessAccount;

    @Before
    public void setUp() {
        System.setOut(mockPrintStream);

        personalAccount = new PersonalAccount("Hilary Castelar", "Rua 123", 1000.0, "123.123.132-13");
        businessAccount = new BusinessAccount("Joao Alves", "Rua 12345", 10000.0, "72.227111/17237");
    }

    @Test
    public void depositAddMoneyToAccount() {
        personalAccount.deposit(500.0);
        businessAccount.deposit(300.0);

        assertEquals(1500.0, personalAccount.getBalance(), 0.01);
        assertEquals(10300.0, businessAccount.getBalance(), 0.01);
    }

    @Test
    public void withdrawMoneyFromTheAccount(){
        personalAccount.withdraw(500.0);
        businessAccount.withdraw(5000.0);

        assertEquals(500.0, personalAccount.getBalance(), 0.01);
        assertEquals(5000.0, businessAccount.getBalance(), 0.01);
    }

    @Test
    public void withdrawMoneyFromTheAccountInvalid(){
        personalAccount.withdraw(2000);
        businessAccount.withdraw(50000);

        assertEquals(1000, personalAccount.getBalance(), 0.01);
        assertEquals(10000, businessAccount.getBalance(), 0.01);
    }

   @Test
    public void testPrintStatement(){
        personalAccount.printStatement();
        verify(mockPrintStream).println("Extrato para: Hilary Castelar");
   }

}
