import java.io.File;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class SignUp {
    public SignUp(Scanner input, boolean isRunning, UserAccountsList accountsList, File BANK_ACCOUNTS) {
        input.nextLine();
        System.out.println("\n==================================");
        System.out.println("CREATE NEW ACCOUNT");
        System.out.println("==================================");
        System.out.print("First Name: ");
        String accFirstName = input.nextLine();
        System.out.print("Last Name: ");
        String accLastName = input.nextLine();
        System.out.print("Phone No: ");
        String accPhoneNumber = input.nextLine();
        System.out.print("Current Address: ");
        String accAddress = input.nextLine();

        Set<String> existingAccountNumbers = new HashSet<>();
        String accID = GenerateAccID(existingAccountNumbers);
        // generate a unique ID for each user
        System.out.println("Account ID: " + accID);

        String accPassword;
        String accConfirmPassword;
        do {
            System.out.println("\nCreate a Password(Minimum of 8 characters):");
            accPassword = input.nextLine();
            if (accPassword.length() < 8) {
                System.out.println("\nMinimun Character is 8\n Please Try Again...\n");
            }

        } while (accPassword.length() < 8);

        do {
            System.out.println("Confirm PassWord: ");
            accConfirmPassword = input.nextLine();
            if (accPassword.equals(accConfirmPassword)) {
                System.out.println("Password Created Successfully...");
            } else {
                System.out.println("Passwords Do not Match");
            }
        } while (!accPassword.equals(accConfirmPassword));

        double accBalance;
        do {
            System.out.println("\nTo Complete Registration you must Deposit minimun of 2000");
            System.out.print("Deposit Amount: ");
            accBalance = input.nextDouble();

            // check if account balance meets the requirements
            if (accBalance < 2000) {
                System.out.println("Sorry the minimum amount is Php2000\n Please Try again...");
            } else if (accBalance >= 2000) {
                System.out.println("\nAmount Successfully Deposited\n");
            }
        } while (accBalance < 2000);

        // adds to accountsList
        accountsList.addAccounts(accID, accPassword, accFirstName, accLastName, accPhoneNumber, accAddress, accBalance);
        System.out.println("Please Proceed to login\n");
        new Login(input, isRunning, accountsList, BANK_ACCOUNTS);

    }

    public String GenerateAccID(Set<String> existingAccountNumbers) {
        // generate a unique account ID
        Random random = new Random();
        String generatedID = "";

        do {
            generatedID = "";
            for (int i = 0; i < 7; i++) {
                int id = random.nextInt(10);
                generatedID += Integer.toString(id);
            }
        } while (existingAccountNumbers.contains(generatedID));

        existingAccountNumbers.add(generatedID);

        return generatedID;
    }

    public boolean isAccIDValid(String accID, String[] ID) {
        for (String id : ID) {
            if (id.equals(accID)) {
                return true; // Match found, the account number is valid
            }
        }
        return false; // No match found, the account number is invalid
    }

}
