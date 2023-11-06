import java.io.File;
import java.util.Scanner;

public class MainMenu {
    public MainMenu(Scanner input, boolean isRunning, UserAccountsList accountsList, String accID, File BANK_ACCOUNTS) {
        isRunning = true;
        do {
            // transaction menu for banksystem
            System.out.println("\n==================================");
            System.out.println("TRANSACTION MENU");
            System.out.println("==================================");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. User Information");
            System.out.println("5. Exit");
            System.out.print("\nChoose Option: ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    new CheckBalance(input, accountsList, accID);
                    break;
                case 2:
                    new Withdraw(input, accountsList, accID);
                    break;
                case 3:
                    new Deposit(input, accountsList, accID);
                    break;
                case 4:
                    new UserInformation(input, accountsList, accID);
                    break;
                case 5:
                    System.out.println("\nThankyou for using Bank System!");
                    isRunning = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nPlease Choose from 1-5 only...\n Please Try again...");
                    break;
            }
        } while (isRunning);
    }

}
