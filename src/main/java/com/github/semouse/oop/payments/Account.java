package com.github.semouse.oop.payments;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.github.semouse.oop.payments.StandardAccountOperations.*;

public class Account {
    private final int id;
    private final List<Transaction> transactions;

    public Account(int id) {
        this.id = id;
        transactions = new ArrayList<>();
    }

    public Account(int id, List<Transaction> transactions) {
        this.id = id;
        this.transactions = transactions;
    }

    public void sendMoneyToAccount(Account accountTo, double moneyAmount) {
        if (accountTo == null || moneyAmount <= 0) {
            return;
        }
        transactions.add(new Transaction(this, accountTo, moneyAmount, MONEY_TRANSFER_SEND));
        accountTo.receiveMoney(this, moneyAmount);
    }

    private void receiveMoney(Account accountFrom, double moneyAmount) {
        if (accountFrom == null || moneyAmount <= 0) {
            return;
        }
        transactions.add(new Transaction(accountFrom, this, moneyAmount, MONEY_TRANSFER_RECEIVE));
    }

    public void withdrawMoney(double moneyAmount) {
        if (moneyAmount <= 0) {
            return;
        }
        transactions.add(new Transaction(this, null, moneyAmount, WITHDRAW));
    }

    public Transaction[] getTransactions() {
        return transactions.stream().filter(Objects::nonNull).toArray(Transaction[]::new);
    }

    public static class Transaction {
        private final Account accountFrom;
        private final Account accountTo;
        private final double moneyAmount;
        private final StandardAccountOperations operation;

        public Transaction(Account accountFrom, Account accountTo, double moneyAmount, StandardAccountOperations operation) {
            this.accountFrom = accountFrom;
            this.accountTo = accountTo;
            this.moneyAmount = moneyAmount;
            this.operation = operation;
        }

        public Account getAccountFrom() {
            return accountFrom;
        }

        public Account getAccountTo() {
            return accountTo;
        }

        public double getMoneyAmount() {
            return moneyAmount;
        }

        public StandardAccountOperations getOperation() {
            return operation;
        }
    }
}
