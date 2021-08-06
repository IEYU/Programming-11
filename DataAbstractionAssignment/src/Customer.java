import org.w3c.dom.ls.LSOutput;

import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<Deposit>();
    private ArrayList<Withdraw> withdraws = new ArrayList<Withdraw>();
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        //create default constructor
        this.name = "John";
        this.accountNumber = 0;
        this.checkBalance = 0;
        this.savingBalance = 0;
    }

    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
    }

    //requires: double (amount of money to deposit), Date, String (which account to deposit)
    //modifies: this
    //effects: create and add a new deposit object to the deposits arraylist and deposits an amount of money
    //into checking or saving balance depends on user's choice
    public double deposit(double amt, Date date, String account){
        //your code here
        if (account.equals(CHECKING)){
            deposits.add(new Deposit(amt, date, CHECKING));
            checkBalance += amt;
        }
        else if (account.equals(SAVING)){
            deposits.add(new Deposit(amt, date, SAVING));
            savingBalance += amt;
        }
        //deposits.toString();
        return 0;
    }

    //requires: double (amount of money to withdraw), Date, String (which account to withdraw from)
    //modifies: this
    //effects: create and add a new withdraw object to the withdraws arraylist and withdraw an amount of money
    //from the checking or saving account depends on user's choice if it doesn't exceed the overdraft limit
    public double withdraw(double amt, Date date, String account){
        //your code here
        if (account.equals(CHECKING) && checkOverdraft(amt, CHECKING) == false){
            withdraws.add(new Withdraw(amt, date, CHECKING));
            checkBalance -= amt;
        }
        else if (account.equals(SAVING) && checkOverdraft(amt, SAVING) == false){
            withdraws.add(new Withdraw(amt, date, SAVING));
            savingBalance -= amt;
        }
        return 0;
    }

    //requires: double (amount of money to withdraw), String (which account to withdraw from)
    //modifies: nothing
    //effects: check if withdrawing an amount of money exceeds the overdraft limit
    private boolean checkOverdraft(double amt, String account){
        //your code here
        if (account.equals(CHECKING)){
            if ((checkBalance - amt) < OVERDRAFT){
                return true;
            }
        }
        else if (account.equals(SAVING)){
            if ((savingBalance - amt) < OVERDRAFT){
                return true;
            }
        }
        return false;
    }

    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    //getters and setters
    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(ArrayList<Deposit> deposits) {
        this.deposits = deposits;
    }

    public ArrayList<Withdraw> getWithdraws() {
        return withdraws;
    }

    public void setWithdraws(ArrayList<Withdraw> withdraws) {
        this.withdraws = withdraws;
    }

    public double getCheckBalance() {
        return checkBalance;
    }

    public void setCheckBalance(double checkBalance) {
        this.checkBalance = checkBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }
}
