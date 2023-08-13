import java.util.Scanner;

class bankaccount {
    private double balance;

    public bankaccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }
}

class ATM {
    private bankaccount bankAccount;

    public ATM(bankaccount account) {
        this.bankAccount = account;
    }

    public void DisplayMenu() {
        System.out.println("\n------ ATM Interface ------");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void PerformTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.println("Balance: $" + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmount = scanner.nextDouble();
                bankAccount.withdraw(withdrawAmount);
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: $");
        double initialBalance = scanner.nextDouble();

        bankaccount bankAccount = new bankaccount(initialBalance);
        ATM atm = new ATM(bankAccount);

        while (true) {
            atm.DisplayMenu();
            int choice = scanner.nextInt();
            atm.PerformTransaction(choice, scanner);
        }
    }
}
