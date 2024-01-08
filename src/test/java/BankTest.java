import org.example.Bank;
import org.example.BankAccount;
import org.example.AccountNotFoundException;
import org.example.NegativeAmountException;
import org.example.InsufficientFundsException;
import org.junit.Test;
import static org.junit.Assert.*;

// Тестовий клас для перевірки роботи банківської системи
public class BankTest {
    public static void main(String[] args) {
        try {
            Bank bank = new Bank();

            BankAccount account1 = bank.createAccount("John Doe", 1000);
            BankAccount account2 = bank.createAccount("Jane Doe", 500);

            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());

            account1.withdraw(200);
            account2.deposit(200);

            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());

            bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 300);

            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}