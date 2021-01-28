package org.xpdojo.bank;

public class Account {

    protected int current_balance = 0;

    public void deposit(int amount) {
        current_balance += amount;
    }

    public boolean withdraw(int amount) {
        if (current_balance >= amount) {
            current_balance -= amount;
            return true;
        }

        return false;
    }

    public int balance() {
        return current_balance;
    }
}
