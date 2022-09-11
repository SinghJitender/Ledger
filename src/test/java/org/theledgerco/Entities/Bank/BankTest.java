package org.theledgerco.Entities.Bank;

import junit.framework.TestCase;

public class BankTest extends TestCase {

    Bank bank  = new Bank("IDIDI",1);;

    public void testTestGetName() {
        assertEquals(bank.getName(),"IDIDI");
    }

    public void testGetId() {
        assertEquals(bank.getId(),1);

    }
}