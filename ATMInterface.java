import java.util.Scanner;

class BankAccount
 {
    private double balance;

    public BankAccount(double initialBalance)
    {
        this.balance = initialBalance;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else 
        {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount)
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else if (amount > balance)
        {
            System.out.println("Insufficient funds!");
        } else
        {
            System.out.println("Invalid withdrawal amount!");
        }
    }
}

class ATM 
{
    private BankAccount account;

    public ATM(BankAccount account) 
    {
        this.account = account;
    }

    public void start() 
 {
        Scanner scanner = new Scanner(System.in);
        while (true) 
  {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice)
        {
                case 1:
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Exiting... Thank you for using the ATM!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

public class ATMInterface 
{
    public static void main(String[] args) 
    {
        BankAccount account = new BankAccount(1000.0); // Initialize account with a balance of $1000
        ATM atm = new ATM(account);
        atm.start();
    }
}