package com.ATM.Project.Java.in;



import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<>();
   private void access() {
    	System.out.print("Enter your customer Number: ");
    	setCustomerNumber(menuInput.nextInt());
    	 System.out.print("Enter your pin Number: ");
        setPinNumber(menuInput.nextInt());
    }

    public void getLogin() throws IOException {
        int x = 1;
           
        do {
        	
            try {
                data.put(952141, 99999);
                data.put(898989, 98898);
                System.out.println("Welcome to the ATM project ");
                System.out.print("Press 1 if you already have an account or Press 2 if you dont have an Account :");
                int user = menuInput.nextInt();
                if( user == 1) {
                	access();
                	
                }else {
                	System.out.println("To create an ATM account you have to provide 3 things a)'Customer Number' b)'Email' c)'Pin Number'");
                	System.out.print("Set your Customer Number: ");
                	setCustomerNumber(menuInput.nextInt());
                	System.out.print("Set your pin Number: ");
                    setPinNumber(menuInput.nextInt());
                    data.put(getCustomerNumber(),getPinNumber());
                    System.out.println("Your new account has been created");
                    
                    access();
                    
                }
                

            } catch (Exception e) {
                System.out.println("\n" + "Invalid Character(s). Only Numbers." + "\n");
                x = 2;
            }
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else
                System.out.println("\n" + "Wrong Customer Number or Pin Number " + "\n");
        } while (x == 1);
    }

    public void getAccountType() {
        System.out.println("Select the Account you want to access: ");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.print("Your Choice: ");
        int selection = menuInput.nextInt();
        switch (selection) {
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank you for using this Atm, Bye. " + "\n");
                break;

            default:
                System.out.println("\n" + "Invalid Choice" + "\n");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");
int selection = menuInput.nextInt();
switch (selection){
    case 1:
        System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
getAccountType();
break;
    case 2:
        getCheckingWithdrawInput();
        getAccountType();
        break;
    case 3:
        getCheckingDepositInput();
        getAccountType();
        break;
    case 4:
        System.out.println("Thank You for using ATM, bye. ");
        break;
    default:
        System.out.println("\n" + "Invalid Choice" + "\n");
        getChecking();

}
    }
    public void getSaving(){
        System.out.println("Saving Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");
        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for using ATM, Bye. ");

            default:
                System.out.println("\n" + "Invalid Input" + "\n");
                getSaving();

        }
    }
}



