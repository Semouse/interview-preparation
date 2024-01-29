package com.github.semouse.oop.payments;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    private static final int ACCOUNT_ID_FROM = 1;
    private static final int ACCOUNT_ID_TO = 2;
    private static final double MONEY_AMOUNT = 250;
    private Account account;

    @BeforeEach
    public void init() {
        account = new Account(1, new ArrayList<>());
    }

    @Test
    void shouldNotSendMoneyToAccountIfAccountToIsNull() {
        account.sendMoneyToAccount(null, MONEY_AMOUNT);
        assertEquals(0, account.getTransactions().length);
    }

    @Test
    void shouldNotSendMoneyToAccountIfMoneyIsZero() {
        account.sendMoneyToAccount(new Account(ACCOUNT_ID_TO), 0);
        assertEquals(0, account.getTransactions().length);
    }

    @Test
    void shouldCreateTransactionWhenMoneySent() {
        Account accountTo = new Account(ACCOUNT_ID_TO);
        account.sendMoneyToAccount(accountTo, MONEY_AMOUNT);

        Account.Transaction createdTransaction = account.getTransactions()[0];

        assertEquals(account, createdTransaction.getAccountFrom());
        assertEquals(accountTo, createdTransaction.getAccountTo());
        assertEquals(MONEY_AMOUNT, createdTransaction.getMoneyAmount(), 0.01);
        assertEquals(StandardAccountOperations.MONEY_TRANSFER_SEND, createdTransaction.getOperation());
    }

    @Test
    void shouldCreateTransactionWhenMoneyReceived() {
        Account accountTo = new Account(ACCOUNT_ID_TO);
        account.sendMoneyToAccount(accountTo, MONEY_AMOUNT);

        Account.Transaction createdTransaction = accountTo.getTransactions()[0];

        assertEquals(account, createdTransaction.getAccountFrom());
        assertEquals(accountTo, createdTransaction.getAccountTo());
        assertEquals(MONEY_AMOUNT, createdTransaction.getMoneyAmount(), 0.01);
        assertEquals(StandardAccountOperations.MONEY_TRANSFER_RECEIVE, createdTransaction.getOperation());
    }

    @Test
    void shouldCreateTransactionWhenWithdrawMoney() {
        account.withdrawMoney(MONEY_AMOUNT);

        Account.Transaction createdTransaction = account.getTransactions()[0];

        assertEquals(account, createdTransaction.getAccountFrom());
        assertEquals(MONEY_AMOUNT, createdTransaction.getMoneyAmount(), 0.01);
        assertEquals(StandardAccountOperations.WITHDRAW, createdTransaction.getOperation());

    }
}