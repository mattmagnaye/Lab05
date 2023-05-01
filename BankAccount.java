/**
 * The BankAccount class represents a bank account with an account number, balance, and transaction history.
 * It provides methods to deposit, withdraw, and print a statement, and getters and setters for the balance.
 */
public class BankAccount {
    private String accountNumber;
    private double balance;
    private StringBuilder transactionHistory;

    private static int startingAccountNumber = 1000;

    /**
     * Constructs a BankAccount object with a balance of zero.
     */
    public BankAccount() {
        accountNumber = "ACCT#" + startingAccountNumber++;
        balance = 0;
        transactionHistory = new StringBuilder();
    }

    /**
     * Constructs a BankAccount object with the given initial balance.
     * @param balance the initial balance of the account
     */
    public BankAccount(double balance) {
        accountNumber = "ACCT#" + startingAccountNumber++;
        this.balance = balance;
        transactionHistory = new StringBuilder();
    }

    /**
     * Deposits the given amount into the account.
     * @param amount the amount to deposit
     * @throws IllegalArgumentException if the amount is negative
     */
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        balance += amount;
        transactionHistory.append("DEPOSIT: $").append(amount).append("\n");
    }

    /**
     * Withdraws the given amount from the account.
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if the amount is negative
     * @throws InsufficientFundsException if there are not enough funds in the account
     */
    public void withdraw(double amount) throws IllegalArgumentException, InsufficientFundsException {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        balance -= amount;
        transactionHistory.append("WITHDRAWAL: $").append(amount).append("\n");
    }

    /**
     * Prints the transaction history of the account.
     */
    public void printStatement() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Transaction History:");
        System.out.println(transactionHistory);
    }

    /**
     * Returns the current balance of the account.
     * @return the current balance of the account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the account to the given amount.
     * @param balance the new balance of the account
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
