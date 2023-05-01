import java.util.Scanner;

/**
 * The Application class provides a user interface for interacting with a BankAccount object.
 * It allows the user to deposit, withdraw, and print a statement, and handles exceptions when necessary.
 */
public class Application {
    private BankAccount bankAccount;

    /**
     * Constructs an Application object with a BankAccount object.
     */
    public Application() {
        bankAccount = new BankAccount();
    }

    /**
     * Prompts the user for the amount to deposit and calls the deposit method of the bankAccount object.
     */
    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        try {
            bankAccount.deposit(amount);
           
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Prompts the user for the amount to withdraw and calls the withdraw method of the bankAccount object.
     */
    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        try {
            bankAccount.withdraw(amount);
        } catch (IllegalArgumentException | InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Calls the printStatement method of the bankAccount object.
     */
    public void printStatement() {
        bankAccount.printStatement();
    }

    /**
     * Displays a menu to the user with the options to deposit, withdraw, or print a statement.
     * Handles exceptions when the user enters an incorrect type of input.
     */
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Print Statement");
            System.out.println("4. Quit");

            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine(); // clear input buffer
                System.out.println("Error: Invalid input");
                continue;
            }

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    printStatement();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Error: Invalid choice");
                    break;
            }
        }
    }

    /**
     * The main method creates an Application object and calls its menu method.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Application application = new Application();
        application.menu();
    }
}
