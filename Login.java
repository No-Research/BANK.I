import java.io.File;
import java.util.Scanner;

public class Login {
    public Login(Scanner input, boolean isRunning, UserAccountsList accountsList, File BANK_ACCOUNTS) {
        String accID;
        String accPassword;
        int attempts = 0; // counter
        input.nextLine();
        do {
            System.out.println("\n==================================");
            System.out.println("LOGIN TO YOUR ACCOUNT");
            System.out.println("==================================");
            System.out.print("Account ID: ");
            accID = input.nextLine();
            System.out.print("Password: ");
            accPassword = input.nextLine();
            if (accountsList.validateAccount(accID, accPassword)) {
                System.out.println("\nLogin Sucessfully...");
                new MainMenu(input, isRunning, accountsList, accID, BANK_ACCOUNTS);
            } else {
                System.out.println("\nWrong Credentials...");
                attempts++;
            }
        } while (attempts != 3); // gives user only 3 attempts before redirecting them to start
        if (attempts == 3) {
            System.out.println("\nYou have run out of attempts\nRedirecting you to Menu...\n");
        }

    }
}
