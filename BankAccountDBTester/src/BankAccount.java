/**
 * @(#)BankAccount.java
 * This is the Bank Account file. This file contains the
 * BankAccount class where all the variables and methods
 * for it are located. This is also where the Owner
 * aggregate object is instantiated.
 * June 8, 2016
 * Austin Ho
 * @version 1.00 2016/6/8
 */


public class BankAccount {
	
	//Declare Variables
	private int accountNumber;
	private double balance;
	private String bank;
	private double interestRate;
	private Owner holder;
	
    public BankAccount(int accNum, double bal, String name, double intRate, String owner, int age, char sex, String loc, double annInc) {
    	
    	accountNumber = accNum;
    	balance = bal;
    	bank = name;
    	interestRate = intRate;
    	holder = new Owner(owner, age, sex, loc, annInc);
    	
    }
    
    public int getAccNum(){
    	
    	return accountNumber;
    }
    
    public double getBalance(){
    	
    	return balance;
    }
    
    public String getHolderName(){
    	
    	return holder.getName();
    }
    
    public void setBalance(double nBalance){
    	
    	balance = nBalance;
    	
    }
    
    public void setIntRate(double nIntRate){
    	
    	interestRate = nIntRate;
    	
    }
    public void setOwnerAge(int nAge){
    	holder.setAge(nAge);
    }
    public void setOwnerAddress(String nAddress){
    	holder.setAddress(nAddress);
    }
    public void setOwnerAnnualIncome(double nAnnualIncome){
    	holder.setAnnualIncome(nAnnualIncome);
    }
    
    public int calculator(double value){
    	
    	//Calculates How Long It Takes the Bank Account to Reach a Certain Value
    	int count = 0;
    	double sum = balance;
    	while (sum < value){
    		sum = (sum + holder.getAnnualIncome()) * interestRate;
    		count ++;
    	}
    	return count;
    }
    
    public String toString(){
    	String str;
    	str = "Account Number: " + accountNumber + "\n"
    		+ "Balance: " + balance + "\n"
    		+ "Bank: " + bank + "\n" 
    		+ "Interest Rate: " + interestRate + "\n"
    		+ holder.toString();
    	return str;
    }
}