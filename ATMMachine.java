package ATM;

import java.util.Scanner;

class ATM {
    float balance;
    int pin = 5674;
    Scanner sc = new Scanner(System.in);  // Create a single Scanner object

    public void checkpin() {
        System.out.println("Enter your pin:");
        int enteredpin = sc.nextInt();  // Use the shared Scanner object
        if (enteredpin == pin) {
            menu();
        } else {
            System.out.println("Enter a valid pin");
            checkpin();  // Optionally, allow re-entering the PIN
        }
    }

    public void menu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");
        System.out.println("Enter your choice:");

        int choice = sc.nextInt();  // Use the shared Scanner object
        switch (choice) {
            case 1:
                checkbalance();
                break;
            case 2:
                withdrawmoney();
                break;
            case 3:
                depositmoney();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Enter a valid choice");
                menu();  // Re-prompt the menu if invalid choice
        }
    }

    public void checkbalance() {
        System.out.println("Balance: " + balance);
        menu();
    }

    public void withdrawmoney() {
        System.out.println("Enter the amount to withdraw:");
        float amount = sc.nextFloat();  // Use the shared Scanner object
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawn successfully");
        }
        menu();
    }

    public void depositmoney() {
        System.out.println("Enter the amount to deposit:");
        float amount = sc.nextFloat();  // Use the shared Scanner object
        balance += amount;
        System.out.println("Money deposited successfully");
        menu();
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        ATM obj1 = new ATM();
        obj1.checkpin();
    }
}
