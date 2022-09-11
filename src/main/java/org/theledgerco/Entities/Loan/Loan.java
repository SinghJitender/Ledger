package org.theledgerco.Entities.Loan;

import org.theledgerco.Entities.Bank.Bank;

public class Loan {

    private int loanId;
    private float roi;
    private int tenure;
    private double principleAmount;
    private double emi;
    private int totalEmis;
    private double interest;
    private double repayAmount;
    private Bank bank;
    private double loanTable[];

    public Loan(int loanId, float roi, int tenure, double principleAmount, Bank bank) {
        this.loanId = loanId;
        this.roi = roi;
        this.tenure = tenure;
        this.principleAmount = principleAmount;
        this.bank = bank;

        totalEmis = tenure*12;

        interest = calculateInterest();

        repayAmount = interest+principleAmount;

        emi = calculateMonthlyEMI();

        setupLoanTable();

    }

    public double[] getLoanTable() {
        return loanTable;
    }

    public int getLoanId() {
        return loanId;
    }

    public Bank getBank() {
        return bank;
    }

    public float getRoi() {
        return roi;
    }

    public int getTenure() {
        return tenure;
    }

    public double getPrincipleAmount() {
        return principleAmount;
    }

    public double getEmi() {
        return emi;
    }

    private void setupLoanTable(){
        loanTable = new double[totalEmis+1];
        for(int month = 1;month<=totalEmis;month++){
            loanTable[month] = emi;
        }
    }

    private double calculateInterest(){
        return (principleAmount*tenure*roi)/100;
    }

    private double calculateMonthlyEMI(){
        return Math.ceil(repayAmount/totalEmis);
    }

    public void makePayment(double amount, int emiNo) {
        loanTable[emiNo] = loanTable[emiNo]+amount;
    }


    public String[] getPaidAmountAndEmisRemaining(int emiNo){
        double tempAmount = 0;
        for(int month = 0; month<=emiNo;month++){
            tempAmount+=loanTable[month];
        }
        return new String[]{(int)tempAmount+"", emiNo==0? ""+totalEmis:""+(int)Math.ceil((repayAmount-tempAmount)/emi)};
    }

}

