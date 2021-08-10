package org.perscholas;

import java.util.ArrayList;

public class Accounts {
    ArrayList<BankAccount> accounts;

    public Accounts() {
        this.accounts = new ArrayList<BankAccount>();
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "accounts=" + accounts +
                '}';
    }
}
