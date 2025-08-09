package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== ���� ���� ===");
        String sa1 = bank.createSavingsAccount("ȫ�浿", 10000.0, 3.0);
        String ca1 = bank.createCheckingAccount("��ö��", 20000.0, 5000.0);
        String sa2 = bank.createSavingsAccount("�̿���", 30000.0, 2.0);

        System.out.println("\n=== ��� ���� ��� ===");
        bank.printAllAccounts();
        System.out.println("===================\n");

        System.out.println("=== �Ա�/��� �׽�Ʈ ===");
        try {
            bank.deposit(sa1, 5000.0);
            bank.withdraw(ca1, 3000.0);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        System.out.println("\n=== ���� ���� �׽�Ʈ ===");
        try {
            SavingsAccount hongAccount = (SavingsAccount) bank.findAccount(sa1);   
            double interest = hongAccount.getBalance() * (hongAccount.getInterestRate() / 100.0);
            bank.deposit(sa1, interest);
            System.out.printf("���� %.1f���� ����Ǿ����ϴ�. ���� �ܾ�: %.1f��\n", interest, hongAccount.getBalance());


        } catch (AccountNotFoundException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }


        System.out.println("\n=== ���� ��ü �׽�Ʈ ===");
        try {
            bank.transfer(sa2, ca1, 5000.0);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        System.out.println("\n=== ��� ���� ��� ===");
        bank.printAllAccounts();
        System.out.println("===================\n");

        // ���� �׽�Ʈ
        try {
            bank.withdraw(ca1, 6000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
        
        try {
            bank.withdraw(ca1, 6000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        try {
            bank.withdraw("AC9999", 1000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }
}