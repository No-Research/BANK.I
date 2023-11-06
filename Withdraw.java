import java.util.Scanner;

public class Withdraw {
    public Withdraw(Scanner input, UserAccountsList accountsList, String accID) {
        input.nextLine();
        double amount;
        System.out.println("\n==================================");
        System.out.println("WITHDRAW MONEY ");
        System.out.println("==================================");
        System.out.print("Enter Amount to Withdraw: ");
        amount = input.nextDouble();
        accountsList.withdrawMoney(accID, amount);

    }
}
