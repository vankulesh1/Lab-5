package org.example;

public class BankAccount {
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = initialDeposit;
    }
    // отримання номера аккаунту
    public int getAccountNumber() {
        return accountNumber;
    }
    //Реалізуйте методи deposit(double amount), withdraw(double amount), getBalance() та getAccountSummary()
    public void deposit(double amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Сума внесення не може бути від'ємною.");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws NegativeAmountException, InsufficientFundsException {
        if (amount < 0) {
            throw new NegativeAmountException("Сума зняття не може бути від'ємною.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Недостатньо коштів на рахунку.");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountSummary() {
        return "Рахунок #" + accountNumber + ": " + accountName + ", Баланс: $" + balance;
    }
}
