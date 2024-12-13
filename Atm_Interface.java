import java.util.Scanner;

public class Atm_Interface{
    private double balance;

    public Atm_Interface() {
        this.balance = 0.0; 
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Please select an option: ");
    }

    public void balanceCheck() {
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    public void moneyDeposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("You have successfully deposited: $%.2f%n", amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdrawMoney(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("You have successfully withdrawn: $%.2f%n", amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Atm_Interface obj = new Atm_Interface();
        int option;

        do {
            obj.displayMenu();
            option = sc.nextInt();

            switch (option) {
                case 1:
                    obj.balanceCheck();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    obj.moneyDeposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    obj.withdrawMoney(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println(); 
        } while (option != 4);

        sc.close();
    }
}