package org.example;

public class Main {
    public static void main(String[] args) {
        // Створення об'єкту
        Bank bank = new Bank();

        // Створення рахунку
        BankAccount firstaccount = bank.createAccount("Jonson", 1000);
        BankAccount secondtaccount = bank.createAccount("Makron", 1500);

        // Виведення інформації про рахунки
        System.out.println(firstaccount.getAccountSummary());
        System.out.println(secondtaccount.getAccountSummary());

        // Переведення грошей з одного рахунку на другий
        try {
            bank.transferMoney(firstaccount.getAccountNumber(), secondtaccount.getAccountNumber(), 300);
            System.out.println("Кошти успішно переведено.");
        } catch (AccountNotFoundException | NegativeAmountException | InsufficientFundsException e) {
            System.err.println("Відбулась помилка переведення коштів: " + e.getMessage());
        }

        // Виведення оновленої інформації про рахунки
        System.out.println(firstaccount.getAccountSummary());
        System.out.println(secondtaccount.getAccountSummary());
    }
}