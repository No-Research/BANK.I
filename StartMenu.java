import java.io.File;
import java.util.Scanner;

public class StartMenu {
    public StartMenu(Scanner input, boolean isRunning, UserAccountsList accountsList, File BANK_ACCOUNTS) {
        isRunning = true;
        do {
            System.out.println("\n==================================");
            System.out.println("Welcome To Banking System");
            System.out.println("==================================");
            System.out.println("1. Login");
            System.out.println("2. Sign-Up");
            System.out.println("3. Exit");
            System.out.print("\nChoose an Option: ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    new Login(input, isRunning, accountsList, BANK_ACCOUNTS);
                    break;
                case 2:
                    new SignUp(input, isRunning, accountsList, BANK_ACCOUNTS);
                    break;
                case 3:
                    System.out.println("\nThank You for using Banking System!");
                    isRunning = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input...\nPlease choose between 1-3.");
                    break;
            }
        } while (isRunning);
        input.close();
    }
}
