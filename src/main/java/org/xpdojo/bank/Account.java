package org.xpdojo.bank;

public class Account {

    protected int current_balance = 0;

    public void deposit(int amount) {
        current_balance += amount;
    }

    public int balance() {
        return current_balance;
    }
}
