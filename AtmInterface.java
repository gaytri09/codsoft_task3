import java.util.*;
class BankAccount{
    double balance;
    public BankAccount(double balance){
        this.balance=balance;
    }
    //Using deposit method for deposting the amount
    public boolean deposit(double amount){
        if(amount>0){
            this.balance+=amount;
            return true;
        }else{
            System.out.println("Invalid amount for deposit.");
            return false;
        }
    }
    //Using withdraw method for the withdrawal of money
    public boolean withdraw(double amount){
        if(amount>0 && amount<=this.balance){
            this.balance-=amount;
            return true;
        }else{
            System.out.println("Insufficient balance for the withdrawal.");
            return false;
        }
    }
    //Using checkbalance method for the  remaining balance of account
    public double checkBalance(){
        return this.balance;
    }
}
class Atm{
    // creating reference 
    private BankAccount bankAccount;
    private Scanner sc;

    public Atm(BankAccount bankAccount){
        this.bankAccount=bankAccount;
        this.sc=new Scanner(System.in);
    }
    //Using displayOptions method for the options available to choose for the customer 
    public void displayOptions() {
        System.out.println("ATM Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. WithDraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }
    //Method used to take input from user as deposit amount.
    public void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = sc.nextDouble();
        if (bankAccount.deposit(amount)) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit failed.");
        }
    }
    //Method is used to take input from user as withdrawal amount.
    public void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = sc.nextDouble();
        if (bankAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed.");
        }
    }
    //Method is used fro returning the balance.
    public void checkBalance() {
        double balance = bankAccount.checkBalance(); 
        System.out.println("Your balance is: " + balance);
    }
    //This method is used for the user interaction with the system.
    public void start() {
        while (true) {
            displayOptions ();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);
        Atm atm = new Atm(bankAccount);
        atm.start();
    }
}


