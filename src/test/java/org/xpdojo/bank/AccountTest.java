package org.xpdojo.bank;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void newAccountsHaveABalance() {
        Account account = new Account();
        assertThat(account.balance()).isEqualTo(0);
    }

    @Test
    public void depositAnAmount() {
        Account account = new Account();
        account.deposit(100);
        assertThat(account.balance()).isEqualTo(100);
    }

    @Test
    public void depositMultipleAmounts() {
        Account account = new Account();
        account.deposit(100);
        account.deposit(200);
        assertThat(account.balance()).isEqualTo(300);
    }

    @Test
    public void withdrawExactBalance() {
        Account account = new Account();
        account.deposit(100);
        boolean retValue = account.withdraw(100);
        assertThat(retValue).isEqualTo(true);
    }

    @Test
    public void withdrawSafeAmount() {
        Account account = new Account();
        account.deposit(100);
        boolean retValue = account.withdraw(100);
        assertThat(retValue).isEqualTo(true);
    }

    @Test
    public void withdrawOverage() {
        Account account = new Account();
        account.deposit(100);
        boolean retValue = account.withdraw(200);
        assertThat(retValue).isEqualTo(false);
    }

    @Test
    public void transferExactBalance() {
        Account source = new Account();
        Account target = new Account();
        source.deposit(100);
        boolean retValue = source.transfer(100, target);
        assertThat(retValue).isTrue();
        assertThat(source.balance()).isEqualTo(0);
        assertThat(target.balance()).isEqualTo(100);
    }

    @Test
    public void transferSafeBalance() {
        Account source = new Account();
        Account target = new Account();
        source.deposit(100);
        boolean retValue = source.transfer(100, target);
        assertThat(retValue).isTrue();
        assertThat(source.balance()).isEqualTo(0);
        assertThat(target.balance()).isEqualTo(100);
    }

    @Test
    public void transferOverage() {
        Account source = new Account();
        Account target = new Account();
        source.deposit(100);
        boolean retValue = source.transfer(200, target);
        assertThat(retValue).isFalse();
        assertThat(source.balance()).isEqualTo(100);
        assertThat(target.balance()).isEqualTo(0);
    }
}
