public class Accounts {

    private String accID;
    private String accPassword;
    private String accFirstName;
    private String accLastName;
    private String accPhoneNumber;
    private String accAddress;
    private double accBalance;

    Accounts(String accID, String accPassword, String accFirstName,
            String accLastName, String accPhoneNumber,
            String accAddress, double accBalance) {
        this.accID = accID;
        this.accPassword = accPassword;
        this.accFirstName = accFirstName;
        this.accLastName = accLastName;
        this.accPhoneNumber = accPhoneNumber;
        this.accAddress = accAddress;
        this.accBalance = accBalance;
    }

    // getters
    public String getAccID() {
        return accID;
    }

    public String getAccPassword() {
        return accPassword;
    }

    public String getAccFirstName() {
        return accFirstName;
    }

    public String getAccLastName() {
        return accLastName;
    }

    public String getAccPhoneNumber() {
        return accPhoneNumber;
    }

    public String getAccAddress() {
        return accAddress;
    }

    public double getAccBalance() {
        return accBalance;
    }
}