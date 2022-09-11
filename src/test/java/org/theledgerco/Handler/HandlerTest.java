package org.theledgerco.Handler;

import junit.framework.TestCase;

public class HandlerTest extends TestCase {

    Handler handler = new Handler();

    public void testProcessLoan() {
        handler.processLoan(new String[]{"LOAN","IDIDI", "Dale", "10000", "5" ,"4"});
    }

    public void testProcessBalance() {
        handler.processLoan(new String[]{"LOAN","IDIDI", "Dale", "10000", "5" ,"4"});
        handler.processBalance(new String[]{"BALANCE","IDIDI","Dale","5"});
    }

    public void testProcessPayment() {
        handler.processLoan(new String[]{"LOAN","IDIDI", "Dale", "10000", "5" ,"4"});
        handler.processPayment(new String[]{"PAYMENT","IDIDI","Dale","7000","12"});
    }
}