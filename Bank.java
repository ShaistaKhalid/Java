/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_200395613;

import java.util.*;

/**
 *
 * @author shaiz
 */

public class Bank {
    
    //3 instance variables with accessibility to their class only.
    private String bankName;
    private BranchLocations branchLocation;
    
    //Pre-defined bank branch locations entered into an enum
    public static enum BranchLocations {WINNIPEG,NOVASCOTIA,LONDON};
    
    //Array list to store all the accounts created
    ArrayList<Account> accountList=new ArrayList<>();
   
    
    //Default Constructor 
    public Bank() {}
    
    //Checks the bank name and branch location following the conditions
    public Bank(String bankName, String branchLocation) {
         boolean check=true;
        
        //Checks if the BankName has only alphabets.
        if(!isOnlyAlphabets(bankName))
            check=false;
        
        //Checks if bankName has atleast 5 characters.
        if(!isMinimum5Chars(bankName))
            check=false;
        
        //checks the correct branchLocation. returns false if location does not match the enum values. 
        if(!checkBranch(branchLocation))
            check=false;  
        
        //if bankName fulfills all the above criteria, it returns the bankName  
        if(check)
        {
            this.bankName=bankName;
            this.branchLocation=BranchLocations.valueOf(branchLocation.toUpperCase());
        }
        //else if bankName is not entered returns null
        else{
            this.bankName=null;
            this.branchLocation=null;
        }
        
    }
       

    //checks the bankName alphabet condition and accept lowercase and uppercase for branchLocations  
    public Bank(String bankName, BranchLocations branchLocation) {
        
         if((bankName.matches("^[a-zA-Z]*$")&& bankName.length()>=5)){
             if((BranchLocations.WINNIPEG.toString().equalsIgnoreCase(branchLocation.toString()))||(BranchLocations.NOVASCOTIA.toString().equalsIgnoreCase(branchLocation.toString()))||(BranchLocations.LONDON.toString().equalsIgnoreCase(branchLocation.toString()))){
            
                this.bankName=bankName;
		 this.branchLocation=branchLocation;
             }
            }
        //else returns the null value 
        else{
            this.bankName=null;
            this.branchLocation=null;
        }
    }
   
    //get the bankName through getter method
    public String getBankName() {
        if(bankName==null)
            return "";
        return bankName;
    }
      
    //Sets the bankName by checking its alphabetical condition and minimum length criteria
    //else returns false
    public boolean setBankName(String bankName) {
         if((bankName.matches("^[a-zA-Z]*$")&& bankName.length()>=5)){
                this.bankName = bankName;
		return true;
            }      
       
        return false;
    }
    
    //sets the branchLocaton by comparing it with the enum values of branchLocation
    //else returns false.
    public boolean setBranchLocation(String branchLocation) {
           
             boolean check=true;
        if(!checkBranch(branchLocation))
            check=false;        
        if(check)
        {
            this.branchLocation=BranchLocations.valueOf(branchLocation.toUpperCase());
            return true;
        }
        return false;
    }
    //getter method to return the branchLocation as a string
    public String getBranchLocation() {
        return branchLocation.toString();
    }
        
    //sets the branchLocation by checking if it is in string fromat or no        
    public boolean setBranchLocation(BranchLocations branchLocation) {
        
              boolean check=true;
        if(!checkBranch(branchLocation.toString()))
            check=false;        
        //and if all conditions are met, it returns bollean value true
        if(check)
        {
            this.branchLocation=branchLocation;
            return true;
        }
        //else returns false
        return false;
    }
    
    //Actual functionality for checking if the bankName meets the eligibility of alphabet criteria 
       public boolean isOnlyAlphabets(String bankName) {
        for (int i = 0; i < bankName.length(); i++) {
            if (!Character.isAlphabetic(bankName.charAt(i)))
                return false;
        }
        return true;
    }
       //Actual functionality for checking if the bankName has atleast 5 characters.
       //else returns false
      public boolean isMinimum5Chars(String bankName) {
        if(bankName.length()<5)
            return false;
        return true;
    }
      
      //Actual functionality for accepting either upperCase or lowerCase for branchName
       public boolean checkBranch(String branchLocation) {
        if(BranchLocations.WINNIPEG.toString().equalsIgnoreCase(branchLocation))
            return true;
        if(BranchLocations.NOVASCOTIA.toString().equalsIgnoreCase(branchLocation))
            return true;
        if(BranchLocations.LONDON.toString().equalsIgnoreCase(branchLocation))
            return true;
        return false;
    }
    
    //getter method for returning the accountNumber
    public Account getAccountByNumber(String accountNumber) {
        for(Account account:accountList){
            if(account.getAccountNumber().equals(accountNumber))
                return account;
        }
        return new Account();
    }
   
    
    //method to add account in th arrayList
    public boolean addAccount(Account account) {
        if(accountList.contains(account))
            return false;
        accountList.add(account);
        return true;
    }
    
    //Adds information to the Account class threough its object which contains 3 parameters
    public boolean addAccount(String accountName, String accountNumber, double accountBalance) {
       Account account=new Account(accountName, accountNumber, accountBalance);
        if(accountList.contains(account))
            return false;
        accountList.add(account);
        return true;
    }
    // For loop method to view the accounts by entering the account number in a string format
    public Account viewAccount(String accountNumber) {
        for(Account account:accountList){
            if(account.getAccountNumber().equals(accountNumber))
                return account;
        }
        return new Account();
    }
    
    //This method gets the value from arrayList and display it.
    public Account viewAccount(int index) {
        if(index<accountList.size()&&index>=0)
            return accountList.get(index);
        return new Account();
    }
    
    //Modifies the account by confirming the accountNumber and accountName 
   //else it returns false
    public boolean modifyAccount(String accountNumber, String accountName) {
        for(Account account:accountList){
            if(account.getAccountNumber().equals(accountNumber))
            {
               return account.setAccountName(accountName);  
            }
        }
        return false;
    }
    
    //Modifies the account by confirming the accountNumber and the accountBalance
    //else returns the boolean false.
    public boolean modifyAccount(String accountNumber, double accountBalance) {
        for(Account account:accountList){
            if(account.getAccountNumber().equals(accountNumber))
            {
                return account.setAccountBalance(accountBalance);         
            }
        }
        return false;
    }
    
    //Modifies the account by checking all three parameters of accountNAme, accountBalance and accountNumber at once
    //else it returns boolean false.
    public boolean modifyAccount(String accountNumber, String accountName, double accountBalance) {
        for(Account account:accountList){
            if(account.getAccountNumber().equals(accountNumber))
            {
                boolean ret= account.setAccountName(accountName); 
            if(ret)
            {
                return account.setAccountBalance(accountBalance);         
            }
            }
        }
        return false;
    }

    //Modifies the account by setting the accountName to its specified index value in the arrayList
    //else it returns the boolean false
    public boolean modifyAccount(int index, String accountName) {
        if(index<accountList.size()&&index>=0)
        {
           Account account=accountList.get(index);
            return account.setAccountName(accountName);            
        }
        return false;
    }
    
    //Modifies the account by setting the accountBalance to its specified index value in the arrayList
    //else it returns the boolean false
    public boolean modifyAccount(int index, double accountBalance) {
        if(index<accountList.size()&&index>=0)
        {
            Account account=accountList.get(index);
            return account.setAccountBalance(accountBalance);            
        }
        return false;
    }
    
    //Modifies the account by setting the accountName and accountBalance to its specified index value in the arrayList
    //else it returns the boolean false
    public boolean modifyAccount(int index, String accountName, double accountBalance) {
        if(index<accountList.size()&&index>=0)
        {
            Account account=accountList.get(index);
            boolean value= account.setAccountName(accountName); 
            if(value)
            {
                return account.setAccountBalance(accountBalance);         
            }
        }
        return false;
    }
    
    //Deletes the account by passing just the accountNumber
    //if accountNumber does not match to the stored accountNumber, it returns false
    public boolean deleteAccount(String accountNumber) {
        for(Account account:accountList){
            if(account.getAccountNumber().equals(accountNumber))
            {
                accountList.remove(account);
                return true;
            }
        }
        return false;
    }
    
    //Checks for the index value of target accountNumber in the arrayList to remove that array value from the list permanentally.
    //else if target accountNumber does not match with the list number, it returns boolean false.
    public boolean deleteAccount(int index) {
        if(index<accountList.size()&&index>=0)
        {
            accountList.remove(index);
            return true;
        }
        return false;
    }
 
    
}

