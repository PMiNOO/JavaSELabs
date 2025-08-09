package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
        super(accountNumber, ownerName, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException(String.format("��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: %.1f��", withdrawalLimit));
        }
        super.withdraw(amount);
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    @Override
    public String toString() {
        return String.format("%s, ��� �ѵ�: %.1f��", super.toString(), withdrawalLimit);
    }
}