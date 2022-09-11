package org.theledgerco.Entities.User;

import org.theledgerco.Entities.Loan.Loan;

import java.util.Hashtable;

public class Borrower implements Person {

    private int id;
    private String name;
    private Hashtable<String, Loan> loans;

    public Borrower(int id, String name) {
        this.id = id;
        this.name = name;
        loans = new Hashtable<>();
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    public Hashtable<String, Loan> getLoans() {
        return loans;
    }

    public Loan getLoan(String bankName) {
        if(loans.containsKey(bankName)){
            return loans.get(bankName);
        } else {
            return null;
        }
    }

    public void addLoan(String bankName, Loan loan){
        if(!loans.containsKey(bankName)) {
            loans.put(bankName, loan);
        }
    }
}
