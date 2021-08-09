package org.perscholas;

public class CheckingAccount extends BankAccount {


    public CheckingAccount() {
    }

    public CheckingAccount(int id, int annualFee, int interestRate, int balance) {
        super(id, annualFee, interestRate, balance);
    }
}
