import java.util.*;

class ATM {

    public  final String USER_ID = "varshith";
    public  final String PASSWORD = "9684";
    ArrayList <String> Trh=new ArrayList<String>();
    public double balance=0.0;
    Scanner sc = new Scanner(System.in);
}

class TransactionHistory extends ATM 
{
    public void showTransactionHistory()
    {
        int n=1;
        if(Trh.isEmpty())
        {
            System.out.println(" No transaction history yet");
        }
        else{
            System.out.println("Your transaction history is below");
            for(String j:Trh)
           {
            System.out.println("["+n+"]"+" "+j);
            n=n+1;
           }


        }
    }

}

class Withdraw extends TransactionHistory {
 
     void withdrawAmount() {
        System.out.println("Enter the amount to withdraw: ");
        double wd = sc.nextDouble();
        System.out.println("Withdrawing amount...");

        if (wd < balance) {
            double c = balance - wd;
            System.out.println("Withdrawal successful...");
            System.out.println("Remaining Balance: " + c);
            Trh.add(wd+" rs"+" debited from your account...");
        } else {
            System.out.println("Insufficient Funds");
        }
        
    }
}

class Deposit extends Withdraw{
 
    public void depositAmount() {
        System.out.println("Enter the amount to deposit: ");
        double amount = sc.nextDouble();
        balance = balance + amount;
        System.out.println("Depositing amount...");
        System.out.println("Deposit successful...");
        System.out.println("Updated Balance: " + balance);
        Trh.add(amount+" rs"+" credited to your account...");
    }
}
class Transfer extends Deposit
{

    public void transferAmount()
     {
        System.out.println("Enter the amount to transfer: ");
        double amount = sc.nextDouble();

        if (amount <= balance) {
            System.out.println("Enter the recipient's account number: ");
            String rac = sc.next();
            System.out.println("Transfer successful to the account number..." + rac);
            balance=balance-amount;
            System.out.println("Remaining Balance: " +balance);
            Trh.add(amount+" rs"+"debited from your account...");
        } 
        else
        {
            System.out.println("Insufficient Funds");
        }
    }
    public void work() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("********************");
            System.out.println("Welcome to the ATM!");
            System.out.println("********************");

            
                System.out.print("Enter your User ID: ");
                String ud = sc.nextLine();
                System.out.print("Enter your Password: ");
                String password = sc.nextLine();
                if (ud.equals(USER_ID) && password.equals(PASSWORD)) {
                    System.out.println("Authentication successful....");
                    System.out.println("***************************");
                    while (true) {
                        showMenu();
                        int choice = sc.nextInt();

                        switch (choice) {
                            case 1:
                                   showTransactionHistory();
                                   break;
                            case 2:
                                   withdrawAmount();
                                   break;
                            case 3:
                                    transferAmount();
                                    break;
                            case 4:
                                    depositAmount();
                                    break;
                            case 5:
                                System.out.println("Thank you for using the ATM. Goodbye!");
                                return;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    }
                } else {
                    System.out.println("Authentication failed. Please try again.");
                }
        }
        }

    public void showMenu() 
    {
        System.out.println("***************************");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Deposit");
        System.out.println("5. Exit");
        System.out.println("***************************");
        System.out.print("Enter your choice: ");
    }
}



public class Bank {
    public static void main(String[] args) {
        Transfer obj = new Transfer();
        obj.work();
    }
}