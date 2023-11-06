import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initializing parameters
        boolean isRunning = true;
        Scanner input = new Scanner(System.in);
        UserAccountsList accountsList = new UserAccountsList();
        File BANK_ACCOUNTS = new File("bankAccounts");
        // start the program
        new StartMenu(input, isRunning, accountsList, BANK_ACCOUNTS);
        // created by ME HAHAHAH
    }
}