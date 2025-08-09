package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println(String.format("%.1f원이 입금되었습니다. 현재 잔액: %.1f원", amount, this.balance));
        }
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > this.balance) {
            throw new InsufficientBalanceException("잔액이 부족합니다.");
        }
        this.balance -= amount;
        System.out.println(String.format("%.1f원이 출금되었습니다. 현재 잔액: %.1f원", amount, this.balance));
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원", accountNumber, ownerName, balance);
    }
}