import java.util.Scanner;

public class UserInformation {
    public UserInformation(Scanner input, UserAccountsList accountsList, String accID) {
        input.nextLine();
        System.out.println("\n==================================");
        System.out.println("USER INFORMATION");
        System.out.println("==================================");
        accountsList.searchAccounts(accID);
        System.out.println("\nDo you want to do another transaction? (y/n): ");
        String option = input.nextLine();
        if (option == "N" || option == "n") {
            System.out.println("\nThankyou for using Bank System!");
            System.exit(0);
        }
    }
}
