
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserAccountsList {
    List<Accounts> accountsList = new ArrayList<>(); //has insertion order

    // ARRAYLIST METHODS
    public void addAccounts(String accID, String accPassword, String accFirstName,
            String accLastName, String accPhoneNumber,
            String accAddress, double accBalance) {

        Accounts userAccounts = new Accounts(accID, accPassword, accFirstName,
                accLastName, accPhoneNumber, accAddress, accBalance);
        accountsList.add(userAccounts);

        // store the accounts inside a file
        String fileName = "bankAccounts.txt";
        writeFile(fileName);
    }

    public void updateAccounts(String accID, double newBalance) {
        //Iterator itr = accountsList.iterator();
        //while(itr.hasNext()) {}

        // get index of the account to update
        int indexCounter = 0;
        for (Accounts userAccounts : accountsList) {
            if (accID.contains(userAccounts.getAccID())) {
                Accounts UpdatedUserAccounts = new Accounts(accID, userAccounts.getAccPassword(),
                        userAccounts.getAccFirstName(), userAccounts.getAccLastName(),
                        userAccounts.getAccPhoneNumber(), userAccounts.getAccAddress(),
                        newBalance);
                accountsList.set(indexCounter, UpdatedUserAccounts);
            }
            indexCounter++;
        }
        String fileName = "bankAccounts.txt";
        String tempFile = "bankAccounts1.txt";
        updateFile(fileName, tempFile);
    }

    public void displayAllAccounts() {
        System.out.println("DISPLAYING ALL ACCOUNTS");
        System.out.println("-----------------------------------");
        for (Accounts userAccounts : accountsList) {
            System.out.println("\nACCOUNT: " + userAccounts.getAccID());
            System.out.println("Password: " + userAccounts.getAccPassword());
            System.out.println("Name: " + userAccounts.getAccFirstName() + " " + userAccounts.getAccLastName());
            System.out.println("Phone Number: " + userAccounts.getAccPhoneNumber());
            System.out.println("Address: " + userAccounts.getAccAddress());
            System.out.println("BALANCE: " + userAccounts.getAccBalance());
        }
    }

    public void searchAccounts(String accID) {
        System.out.println("DISPLAYING INFORMATION FOR");
        System.out.println("-----------------------------------");
        for (Accounts userAccounts : accountsList) {
            if (accID.equals(userAccounts.getAccID())) {
                System.out.println("\nACCOUNT: " + userAccounts.getAccID());
                System.out.println("Password: " + userAccounts.getAccPassword());
                System.out.println("Name: " + userAccounts.getAccFirstName() + " " + userAccounts.getAccLastName());
                System.out.println("Phone Number: " + userAccounts.getAccPhoneNumber());
                System.out.println("Address: " + userAccounts.getAccAddress());
                System.out.println("BALANCE: " + userAccounts.getAccBalance());
                break;
            }
        }
    }

    public void depositMoney(String accID, double amount) {
        double BALANCE = 0;
        for (Accounts userAccounts : accountsList) {
            if (accID.equals(userAccounts.getAccID())) {
                if (amount < 200) {
                    System.out.println("\nYou cannont deposit less than 200.\nPlease try again...");
                } else {
                    BALANCE += userAccounts.getAccBalance();
                    BALANCE = BALANCE + amount;
                    // update list
                    updateAccounts(accID, BALANCE);
                    System.out.println("You have deposited " + amount + "\nNew Balance: " + BALANCE + "\n");
                }
            }
        }
    }

    public void withdrawMoney(String accID, double amount) {
        double BALANCE = 0;
        for (Accounts userAccounts : accountsList) {
            if (accID.equals(userAccounts.getAccID())) {
                if (amount > userAccounts.getAccBalance()) {
                    System.out.println("\nYou do not have enough Balance.\nPlease Try again...");
                } else if (amount < 200) {
                    System.out.println("\nYou cannont withdraw less than 200.\nPlease Try again...");
                } else {
                    BALANCE += userAccounts.getAccBalance();
                    BALANCE = BALANCE - amount;
                    // update list
                    updateAccounts(accID, BALANCE);
                    System.out.println("You have withdrawn " + amount + "\nNew Balance: " + BALANCE + "\n");
                }
            }
        }

    }

    public double getAccBalance(String accID) {
        double BALANCE = 0;
        for (Accounts userAccounts : accountsList) {
            if (accID.equals(userAccounts.getAccID())) {
                return BALANCE += userAccounts.getAccBalance();
            }
        }
        return BALANCE;
    }

    public boolean validateAccount(String accID, String accPassword) {
        readFile("bankAccounts.txt");
        boolean isValid = false;
        if (accountsList.isEmpty()) {
            return isValid;
        }
        for (Accounts userAccounts : accountsList) {
            if (accID.equals(userAccounts.getAccID()) && accPassword.equals(userAccounts.getAccPassword())) {
                return isValid = true;
            }
        }
        return isValid;
    }

    // FILE HANDLING METHODS
    public void createFile(String fileName) {
        try {
            File BANK_ACCOUNTS = new File(fileName);
            if (BANK_ACCOUNTS.createNewFile()) {
                System.out.println("File Created: " + BANK_ACCOUNTS.getName());
            } else {
                System.out.println("File already Created");
            }
        } catch (IOException e) {
            System.out.println("\nERROR OCCURED...");
        }
    }

    public void writeFile(String fileName) {
        try {
            FileWriter BANK_ACCOUNTS = new FileWriter(fileName, true); // Open the file in append mode
            for (Accounts userAccounts : accountsList) {
                BANK_ACCOUNTS.append(userAccounts.getAccID() + " " + userAccounts.getAccPassword() + " "
                        + userAccounts.getAccFirstName() + " " + userAccounts.getAccLastName() + " "
                        + userAccounts.getAccPhoneNumber() + " " + userAccounts.getAccAddress() + " "
                        + userAccounts.getAccBalance() + "\n");
            }
            BANK_ACCOUNTS.close(); // Close the file after writing all entries
        } catch (IOException e) {
            System.out.println("\nERROR OCCURRED...");
        }
    }

    public void updateFile(String fileName, String tempFile) {
        try {
            File BANK_ACCOUNTS = new File(fileName);
            File tempBANK_ACCOUNTS = new File(tempFile);
            createFile(tempFile);
            FileWriter writer = new FileWriter(tempFile, true); // Open the file in append mode
            for (Accounts userAccounts : accountsList) {
                writer.write(userAccounts.getAccID() + " " + userAccounts.getAccPassword() + " "
                        + userAccounts.getAccFirstName() + " " + userAccounts.getAccLastName() + " "
                        + userAccounts.getAccPhoneNumber() + " " + userAccounts.getAccAddress() + " "
                        + userAccounts.getAccBalance() + "\n");
            }
            BANK_ACCOUNTS.delete();
            tempBANK_ACCOUNTS.renameTo(BANK_ACCOUNTS);
            writer.close(); // Close the file after writing all entries
        } catch (IOException e) {
            System.out.println("\nERROR OCCURRED...");
        }
    }

    public void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if (data.length != 7) {
                    continue; // Skip this line and continue to the next one
                }
                // Assuming the data is in the correct format, create the Accounts object
                Accounts userAccount = new Accounts(data[0], data[1], data[2], data[3], data[4], data[5],
                        Double.parseDouble(data[6]));
                accountsList.add(userAccount);
            }
        } catch (IOException e) {
            System.out.println("\nERROR OCCURRED...");
            e.printStackTrace();
        }
    }
}
