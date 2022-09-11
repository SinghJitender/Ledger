package org.theledgerco.Entities.User;

import junit.framework.TestCase;
import org.theledgerco.Entities.Bank.Bank;
import org.theledgerco.Entities.Loan.Loan;

public class BorrowerTest extends TestCase {

    Borrower borrower = new Borrower(1,"Jitender");

    public void testId() {
        assertEquals(1,borrower.id());
    }

    public void testName() {
        assertEquals("Jitender",borrower.name());
    }

    public void testGetLoans() {
        assertEquals(0,borrower.getLoans().size());
    }

    public void testGetLoan() {
        assertEquals(null,borrower.getLoan("IDIDI"));
    }

    public void testAddLoan() {
        Loan loan = new Loan(1,1.0f,1,100,new Bank("IDIDI",1));
        borrower.addLoan("IDIDI", loan);
        assertEquals(loan,borrower.getLoan("IDIDI"));

    }
}