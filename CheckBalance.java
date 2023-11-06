
import java.util.Scanner;

public class CheckBalance {
    public CheckBalance(Scanner input, UserAccountsList accountsList, String accID) {
        input.nextLine();
        System.out.println("\n==================================");
        System.out.println("CHECK BALANCE ");
        System.out.println("==================================");
        System.out.println("Current Balance: " + accountsList.getAccBalance(accID));
        System.out.println("\nDo you want to do another transaction? (y/n): ");
        String option = input.nextLine();
        if (option == "N" || option == "n") {
            System.out.println("\nThankyou for using Bank System!");
            System.exit(0);
        }
    }
}
