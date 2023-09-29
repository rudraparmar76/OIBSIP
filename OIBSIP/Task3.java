import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        int withdrawnAmount, depositedAmount;

        UBankAcc obj = new UBankAcc();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.print("\n");

            System.out.println("========WELCOME TO HDFC ATM SERVICES========");
            System.out.println("==1.WITHDRAW");
            System.out.println("==2.DEPOSIT");
            System.out.println("==3.BALANCE");
            System.out.println("==0.EXIT");
            System.out.print("\n");
            System.out.println("==ENTER THE CHOICE TO BE PERFORMED:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("==ENTER THE AMOUNT TO BE WITHDRAWN:");
                    withdrawnAmount = sc.nextInt();
                    obj.amountWithdrawn(withdrawnAmount);
                    break;
                case 2:
                    System.out.println("==ENTER THE AMOUNT TO BE DEPOSITED:");
                    depositedAmount = sc.nextInt();
                    obj.amountDeposit(depositedAmount);
                    break;
                case 3:
                    obj.displayBalance();
                    break;
                case 0:
                    System.out.println("==THANK YOU :) FOR VISITING HDFC ATM SERVICE");
                    System.exit(0);
                    break;
                default:
                    System.out.println("==INVALID CHOICE!");
            }

        } while (choice != 0);
        sc.close();
    }
}

class UBankAcc {
    private int balance = 50000;
    private List<Transaction> transactions = new ArrayList<>();
    // Displaying current balance

    public void displayBalance() {
        System.out.println("==CURRENT BALANCE: " + balance);
        System.out.print("\n");
    }

    // Withdraw Function
    public void amountWithdrawn(int withdrawnAmount) {
        System.out.print("\n");

        System.out.println("==WITHDRAWING AMOUNT:" + withdrawnAmount);
        if (balance >= withdrawnAmount) {
            balance -= withdrawnAmount;
            transactions.add(new Transaction(TransactionType.WITHDRAW, withdrawnAmount, balance));

            System.out.println("==PLEASE COLLECT YOUR MONEY");
            System.out.print("\n");
            System.out.println("==WITHDRAWL SUCCESSFUL");
            System.out.print("\n");
            displayBalance();

        } else {
            System.out.println("==SORRY! INSUFFICIENT FUNDS");
            System.out.print("\n");

        }
    }

    public void amountDeposit(int depositedAmount) {
        System.out.println("==Depositing AMOUNT:" + depositedAmount);
        balance += depositedAmount;
        transactions.add(new Transaction(TransactionType.DEPOSIT, depositedAmount, balance));

        System.out.println("==AMOUNT DEPOSITED SUCCESFULLY!");
        System.out.print("\n");
        displayBalance();

    }
}

enum TransactionType { // Constants
    WITHDRAW,
    DEPOSIT
}

class Transaction {
    private TransactionType type;
    private int amount;
    private int updatedBalance;

    public Transaction(TransactionType type, int amount, int updatedBalance) {
        this.type = type;
        this.amount = amount;
        this.updatedBalance = updatedBalance;
    }

    public TransactionType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public int getUpdatedBalance() {
        return updatedBalance;
    }
}
