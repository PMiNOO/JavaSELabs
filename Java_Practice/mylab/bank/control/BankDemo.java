package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== 계좌 생성 ===");
        String sa1 = bank.createSavingsAccount("홍길동", 10000.0, 3.0);
        String ca1 = bank.createCheckingAccount("김철수", 20000.0, 5000.0);
        String sa2 = bank.createSavingsAccount("이영희", 30000.0, 2.0);

        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.printAllAccounts();
        System.out.println("===================\n");

        System.out.println("=== 입금/출금 테스트 ===");
        try {
            bank.deposit(sa1, 5000.0);
            bank.withdraw(ca1, 3000.0);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 이자 적용 테스트 ===");
        try {
            SavingsAccount hongAccount = (SavingsAccount) bank.findAccount(sa1);   
            double interest = hongAccount.getBalance() * (hongAccount.getInterestRate() / 100.0);
            bank.deposit(sa1, interest);
            System.out.printf("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원\n", interest, hongAccount.getBalance());


        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }


        System.out.println("\n=== 계좌 이체 테스트 ===");
        try {
            bank.transfer(sa2, ca1, 5000.0);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.printAllAccounts();
        System.out.println("===================\n");

        // 예외 테스트
        try {
            bank.withdraw(ca1, 6000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        
        try {
            bank.withdraw(ca1, 6000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.withdraw("AC9999", 1000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}