package org.theledgerco.Handler;

import org.theledgerco.Entities.Bank.Bank;
import org.theledgerco.Entities.Loan.Loan;
import org.theledgerco.Entities.User.Borrower;

import java.util.Hashtable;

public class Handler {

    private int LOAN_ID = 0;
    private int USER_ID = 0;
    private int BANK_ID = 0;
    private Hashtable<String, Bank> banks;
    private Hashtable<String, Borrower> borrowers;

    public Handler() {
        banks = new Hashtable<>();
        borrowers = new Hashtable<>();
    }

    public void processLoan(String[] input){
//        Format - LOAN BANK_NAME BORROWER_NAME PRINCIPAL NO_OF_YEARS RATE_OF_INTEREST
//        Example- LOAN IDIDI Dale 10000 5 4 means a loan amount of 10000 is paid to Dale
//        by IDIDI for a tenure of 5 years at 4% rate of interest.

        String bankName = input[1];

        String customerName = input[2];

        double principalAmount = Double.parseDouble(input[3]);

        int tenure = Integer.parseInt(input[4]);

        float roi = Float.parseFloat(input[5]);

        Bank bank;

        if(banks.containsKey(bankName)){
            bank = banks.get(bankName);
        }else{
            bank = new Bank(bankName, BANK_ID);
            banks.put(bankName,bank);
            BANK_ID+=1;
        }

        Borrower borrower;

        if(borrowers.containsKey(customerName)){
            borrower = borrowers.get(customerName);
        }else{
            borrower = new Borrower(USER_ID,customerName);
            borrowers.put(customerName,borrower);
            USER_ID+=1;
        }

        Loan loan = new Loan(LOAN_ID, roi, tenure, principalAmount, bank);

        borrower.addLoan(bank.getName(),loan);

        LOAN_ID+=1;
    }
    public void processBalance(String[] input){
//        Input format - BALANCE BANK_NAME BORROWER_NAME EMI_NO
//        Example - BALANCE MBI Harry 12 means - print the amount paid including 12th EMI,
//        and EMIs remaining for user Harry against the lender MBI.

        String bankName = input[1];

        String customerName = input[2];

        int emiNo = Integer.parseInt(input[3]);

        Borrower borrower = borrowers.get(customerName);

        Loan loan = borrower.getLoan(bankName);

        String[] results = loan.getPaidAmountAndEmisRemaining(emiNo);

        System.out.println(bankName+" "+customerName+" "+results[0]+" "+results[1]);

    }
    public void processPayment(String[] input){
//        Format - PAYMENT BANK_NAME BORROWER_NAME LUMP_SUM_AMOUNT EMI_NO
//        Example - PAYMENT MBI Dale 1000 5 means a lump sum payment of 1000 was done
//        by Dale to MBI after 5 EMI payments.

        String bankName = input[1];

        String customerName = input[2];

        double lumpSumAmount = Double.parseDouble(input[3]);

        int emiNo = Integer.parseInt(input[4]);

        Borrower borrower = borrowers.get(customerName);

        Loan loan = borrower.getLoan(bankName);

        loan.makePayment(lumpSumAmount,emiNo);


    }
}
