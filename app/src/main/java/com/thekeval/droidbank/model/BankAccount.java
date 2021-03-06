package com.thekeval.droidbank.model;

public class BankAccount {
    protected String accountNo;
    protected double accountBalance;

    public BankAccount(String accountNo, double accountBalance) {
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    // region getters & setters
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    // endregion

    public double addBalance(double amountToAdd) {
        accountBalance += amountToAdd;
        return accountBalance;
    }

    public double deductBalance(double amountToDeduct) {
        accountBalance -= amountToDeduct;
        return accountBalance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNo='" + accountNo + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
