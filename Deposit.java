import java.util.Scanner;

public class Deposit {
    public Deposit(Scanner input, UserAccountsList accountsList, String accID) {
        input.nextLine();
        double amount;
        System.out.println("\n==================================");
        System.out.println("DEPOSIT MONEY ");
        System.out.println("==================================");
        System.out.print("Enter Amount to Deposit: ");
        amount = input.nextDouble();
        accountsList.depositMoney(accID, amount);
    }
}
