/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_200395613;

import java.util.ArrayList;


/**
 *
 * @author shaiz
 */


public class Account {
    
    //3 instance variables with accessibility to their class only.

    private String accountNumber;
  
    private String accountName; 
      
    private double accountBalance;

    //Default Constructor
    public Account() {}

    //constructor with 3 different parameters which passes the values to the instance variables
    public Account(String accountName, String accountNumber, double accountBalance) {
       
       setAccountName(accountName);// Assigns the  accountName to the setAccountName- the parameter passed in the tester fie
       setAccountNumber(accountNumber);// Assigns the  accountNumber to the setAccountName- the parameter passed in the tester fie
       setAccountBalance(accountBalance);// Assigns the  accountBalance to the setAccountName- the parameter passed in the tester fie
    }

    public String getAccountName() {
        //When the if condition runs the accountName is not entered or is null, it returns boolean false 
        //else it returns the passed accountName through the Tester file.
        if(accountName==null)
            return "";
        return accountName;
    }
    
    //Checks whether if the accountName entered meets the accountName criteria of alphabets and  hyphens only,+ 2 chars minimum.
    public boolean setAccountName(String accountName) {
        
        boolean check=true;
        
        //checks the aplhabets and hyphens only present in the accountName 
        if(!isOnlyAlphaAndHyphen(accountName))
            check=false;
        
        //checks if accountName is atleast having 2 chars
        if(!isMinimum2Chars(accountName))
            check=false;
        
        //if none of the cases above are true, it runs this if condition which returns the eligible accountName.
        if(check)
        {
            this.accountName=accountName;
            return true;
        }
        return false;
    }

//getter and setter for accountNumber
    
    //When the if condition runs the accountNumber is not entered or is null, it returns boolean false 
   //else it returns the passed accountNumber through the Tester file.
    public String getAccountNumber() {     
        if(accountNumber==null)
            return "";
        return accountNumber;
    }
       
   //sets the value of accountNumber by meeting the eligibke criteria, 
   // if it does not meet, it returns boolean false. 
    public boolean setAccountNumber(String accountNumber) {

            if(accountNumber.matches("[0-9]+")&&(accountNumber.length()>=7))
            {
                this.accountNumber = accountNumber;
                return true;
                
            }
            else if(accountNumber.contains("^[a-zA-Z]+")){
                
                return false;
                
            }
          
            else{
		return false;
            }
    }

    //getter and setter for accountBalance
    
    //simply returns the accountBalance entered in the Tester File.
    public double getAccountBalance() {
        return accountBalance;
    }
//This only accepts numbers with 2 decimal places
    //The function isOnly2Decimal is defined below at the end
    //Sets the accountBalance only if the number/s are upto 2 decimal places only
    //else returns boolean false.
    public boolean setAccountBalance(double bal_value) {
        boolean initialReturn=true;
        if(!isOnly2Decimal(bal_value))
            initialReturn=false;
        if(initialReturn)
        {
            this.accountBalance=bal_value;
            return true;
        }
        return false;
    }
   
    
    //Checks if the object of Account class stays same intially and later on.
    @Override
    public boolean equals(Object obj) {
        //This function just checks the objects, that are they equal or not
        if (obj instanceof Account)
        {           //This checks the account object by compring its account number
            return getAccountNumber().equals(((Account)obj).getAccountNumber()); 
        }
        else
            return false;
    }
//Override toString() contains the summary of the Account in a String.
    @Override
    public String toString() {
        return "Your Account Number is: "+accountNumber+", Account Name is: "+accountName+"and Account Balance is: "+accountBalance+"Thank you for visiting our branch.";
    }
    
    //Actual functionality for checking AccountName is done here.
    
    //checks if accountName is having only hyphens and alphabets.
    //else returns boolean false
     public boolean isOnlyAlphaAndHyphen(String accountName) {
        for (int i = 0; i < accountName.length(); i++) {
            if (!Character.isAlphabetic(accountName.charAt(i))&&accountName.charAt(i)!='-')
                return false;
        }
        return true;
    }
     
     //checks if accountName is of minimum 2 characters. 
     //else returns boolean fak]lse
    public boolean isMinimum2Chars(String accountName) {
        if(accountName.length()<2)
            return false;
        return true;
    }
   
  //Actual functionality for checking accountBalance if it is upto 2 decimal places only!!
    public boolean isOnly2Decimal(double balAccount) {
        double bal = balAccount*100;
        int balTwo=(int)bal;
        if(bal!=balTwo)
            return false;        
        return true;
    }

}