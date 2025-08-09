package mylab.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100.0);
        balance += interest;
        System.out.println(String.format("���� %.1f���� ����Ǿ����ϴ�. ���� �ܾ�: %.1f��", interest, balance));
    }
    
    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return String.format("%s, ������: %.1f%%", super.toString(), interestRate);
    }
}