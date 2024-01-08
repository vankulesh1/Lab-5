package org.example;

import java.util.List;
import java.util.ArrayList;


//Реалізуйте клас Bank,
//який зберігає колекцію об'єктів BankAccount


public class Bank {
    private List<BankAccount> accounts = new ArrayList<>();
//створити акаунт
public BankAccount createAccount(String accountName, double initialDeposit) {
    int accountNumber = generateAccountNumber();
    BankAccount account = new BankAccount(accountNumber, accountName, initialDeposit);
    accounts.add(account);
    return account;
}

//пошук
public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
    for (BankAccount account : accounts) {
        if (account.getAccountNumber() == accountNumber) {
            return account;
        }
    }
    throw new AccountNotFoundException("Рахунок #" + accountNumber + " не знайдено.");
}
///перевод коштів
    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws AccountNotFoundException, NegativeAmountException, InsufficientFundsException {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
//генерація номера - унікального номера акаунта
    private int generateAccountNumber() {

        return accounts.size() + 1;
    }


}
