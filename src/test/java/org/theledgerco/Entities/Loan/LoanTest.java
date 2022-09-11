package org.theledgerco.Entities.Loan;

import junit.framework.TestCase;
import org.theledgerco.Entities.Bank.Bank;

public class LoanTest extends TestCase {

    Loan loan = new Loan(1,1.0f,1,1000, new Bank("IDIDI",1));

    public void testGetLoanId() {
        assertEquals(1, loan.getLoanId());
    }

    public void testGetBank() {
        assertEquals("IDIDI", loan.getBank().getName());
    }

    public void testGetRoi() {
        assertEquals(1.0f, loan.getRoi());
    }

    public void testGetTenure() {
        assertEquals(1, loan.getTenure());
    }

    public void testGetPrincipleAmount() {
        assertEquals(1000.0, loan.getPrincipleAmount());
    }

    public void testGetEmi() {
        assertEquals(85.0,loan.getEmi());
    }

    public void testMakePayment() {
        loan.makePayment(100,1);
        assertTrue(loan.getLoanTable()[1]==185);
    }

    public void testGetPaidAmountAndEmisRemaining() {
        assertEquals("85",loan.getPaidAmountAndEmisRemaining(1)[0]);
        assertEquals("11",loan.getPaidAmountAndEmisRemaining(1)[1]);
    }
}