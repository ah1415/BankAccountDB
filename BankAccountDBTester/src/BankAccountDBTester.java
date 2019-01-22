/**
 * @(#)BankAccountDBTester.java
 * BankAccountDBTester application
 * This program creates a Bank Account Database using an array
 * that allows the user to store up to ten bank accounts on it.
 * These bank accounts have an aggregate class, Owner, which have
 * additional information relating to the bank account. This file
 * is the tester file.
 * June 8, 2016
 * Austin Ho
 * @version 1.00 2016/6/8
 */
 
 import java.util.Scanner;
 import java.text.NumberFormat;
 
public class BankAccountDBTester {
    
    public static Scanner input = new Scanner(System.in);
    
    public static NumberFormat money = NumberFormat.getCurrencyInstance();
    
    public static void main(String[] args) {
    	
    	//Create Bank Account Database
    	BankAccountDB bankAccDB = new BankAccountDB();
    	
    	//Declare Variables
    	int accNum;
		double bal;
		String bank;
		double intRate;
		
		String name;
		int age;
		char gen;
		String add;
		double annInc;
		
		int choice;
		double calcNum;
		int slotNum;
		
		asteriskPrinter();
		System.out.println("Welcome to the Bank Account Database Program!");
		System.out.println("This program allows you to create, store, and modify up to ten bank accounts.");
		System.out.println("You can also remove bank accounts, or print them out. There is a calculate");
		System.out.println("function as well to see how long the accounts need to reach a certain value.");
		asteriskPrinter();
		System.out.println("Enter any key to continue: ");
		input.nextLine();
		
		do{
		
		//Main Menu
    	asteriskPrinter();
    	System.out.println("Main Menu");
    	System.out.println("1. Add");
    	System.out.println("2. Remove");
    	System.out.println("3. Update");
    	System.out.println("4. List Record Number");
    	System.out.println("5. List All");
    	System.out.println("6. Sort");
    	System.out.println("7. Calculate");
    	System.out.println("8. Exit");
    	
    	//Get User Input
    	choice = userChoice(8);
    	
    	if(choice == 1) {
    		
    		//Get Account Number
    		do{
    			System.out.println("Enter the bank account number (8 digits): ");
    			accNum = input.nextInt();
    		} while(accNum < 10000000 || accNum > 99999999);
    		
    		//Get Account Balance
    		do{
    			System.out.println("Enter the account balance: ");
    			bal = input.nextDouble();
    		}while(bal < 0);
    		
    		//Get Bank
    		System.out.println("Enter the bank of this account: ");
    		input.nextLine();
    		bank = input.nextLine();
    		
    		//Get Interest Rate
    		do{
    			System.out.println("Enter the interest rate of the account: ");
    			intRate = input.nextDouble();
    		}while(intRate < 0 || intRate >100);
    		
    		//Get Account Holder Name
    		System.out.println("Enter the account holder's name (Last Then First Name): ");
    			input.nextLine();
    			name = input.nextLine();
    		
    		//Get Account Holder Age
    		do{
    			System.out.println("Enter the account holder's age: ");
    			age = input.nextInt();
    		}while (age < 14 || age > 120);
    		
    		//Get Acount Holder Gender
    		System.out.println("Enter the account holder's gender( M for Male, F for Female): ");
    		gen = input.next(".").charAt(0);
    		
    		//Get Account Holder Gender
    		System.out.println("Enter the account holder's address (Street, City, Province, Country): ");
    		input.nextLine();
    		add = input.nextLine();
    		
    		//Get Account Holder Annual Income
    		do{
    		System.out.println("Enter the account holder's annual income: ");
    		annInc = input.nextDouble();
    		}while (annInc < 0);
    		
    		//Add Bank Account
    		bankAccDB.add(accNum, bal, bank, intRate, name, age, gen, add, annInc);	
    	}
    	else if(choice == 2) {
    		
    		//Get Bank Account to Remove
    		do{
    			System.out.print("Which bank account would you like to remove? Slot ");
    			choice = input.nextInt();
    		}while(choice < 0 || choice > 10);
    		
    		//Remove Bank Account
    		bankAccDB.remove(choice);
    	}
    	else if(choice == 3) {
    		System.out.println("Which slot would you like to update? ");
    		slotNum = userChoice(10);
    		
    		System.out.println("What would you like to update about the account? ");
    		System.out.println("1. Balance");
    		System.out.println("2. Interest Rate");
    		System.out.println("3. Age");
    		System.out.println("4. Address");
    		System.out.println("5. Annual Income");
    		choice = userChoice(5);
    		
    		if (choice == 1){
    			do{
    			System.out.println("Enter the new balance: ");
    			bal = input.nextDouble();
    			}while(bal < 0);
    			
    			bankAccDB.update(slotNum, choice, bal);
    		}
    		else if (choice == 2){
    			do{
    			System.out.println("Enter the new interest rate: ");
    			intRate = input.nextDouble();
    			}while(intRate < 0 || intRate > 100);
    			
    			bankAccDB.update(slotNum, choice, intRate);
    		}
    		else if (choice == 3){
    			do{
    			System.out.println("Enter the new age: ");
    			age = input.nextInt();
    			}while(age < 14 || age > 120);
    			bankAccDB.update(slotNum, age);
    		}
    		else if (choice == 4){
    			System.out.println("Enter the new address: ");
    			input.nextLine();
    			add = input.nextLine();
    			bankAccDB.update(slotNum, add);
    		}
    		else if (choice == 5){
    			do{
    			System.out.println("Enter the new annual income: ");
    			annInc = input.nextDouble();
    			}while(annInc < 0);
    			bankAccDB.update(slotNum, choice, annInc);
    		}
    		
    	}
    	else if(choice == 4) {
    		
    		//Get Bank Account to View
    		do{
    			System.out.print("Which bank account would you like to view? Slot ");
    			slotNum = input.nextInt();
    		}while(slotNum < 0 || slotNum > 10);
    		
    		//View Bank Account
    		bankAccDB.listRecordNum(slotNum);
    	}
    	else if(choice == 5) {
    		
    		//Print Out All Bank Accounts
    		bankAccDB.listAll();
    	}
    	else if(choice == 6) {
    		
    		System.out.println("1. Sort By Owner Name.");
    		System.out.println("2. Sort By Account Number.");
    		System.out.println("3. Sort By Balance.");
    		
    		choice = userChoice(3);
    		
    		bankAccDB.sort(choice);
    		
    	}
    	else if(choice == 7) {
    		
    		//Get User Choice
    		System.out.println("1. Calculate for one bank account.");
    		System.out.println("2. Calculate for all bank accounts.");
    		System.out.println("3. Calculate fastest bank account.");
    		choice = userChoice(3);
    		
    		//Get Value
    		System.out.println("Enter the value to calculate until: ");
    		calcNum = input.nextDouble();
    		
    		if(choice == 1){
    			//Get Bank Account to Calculate and Prints Years to Reach Value
    			do{
    			System.out.print("Which bank account would you like to calculate? Slot ");
    			slotNum = input.nextInt();
    			}while (slotNum < 0 || slotNum > 10);
    			
    			//Checks if Slot is Null
    			if(bankAccDB.bankAcc[slotNum - 1] != null){
    				//Outputs Years to Reach
    				System.out.println("Bank " + slotNum + " will reach " + calcNum + " in " + bankAccDB.bankAcc[slotNum - 1].calculator(calcNum) + " years.");
    			}
    			else
    				System.out.println("There was no account stored in that slot.");
    		}
    		else if(choice == 2){
    			//Calculates and Prints All of the Bank Account Times to Reach Value
    			
    			System.out.println(bankAccDB.allCalculate(calcNum));
    		}	
    		else if (choice == 3){
    			//Find Fastest Bank Account
    			slotNum = bankAccDB.fCalculate(calcNum);
    			if(slotNum != -1)
    				//Print Length to Reach Value
    				System.out.println("Bank " + slotNum + " will reach " + calcNum + " the fastest in " + bankAccDB.bankAcc[slotNum - 1].calculator(calcNum) + " years.");
    			else if(slotNum == -1)
    				System.out.println("There were no bank accounts stored in the database.");
    		}
    	}
    	
    	else if(choice == 8) {
    		//Exit Program
    		System.out.println("Thank you for using the Bank Account Database.");
    		System.exit(0);
    	}
    	
		}while (true);
    }
    
    public static int userChoice(int upperLimit){
    	
    	//Declare Variables
    	int choice;
    	
    	//Prints Asterisks
    	asteriskPrinter();
    	
    	//Get Valid User Input and Return Choice
    	do
    	{
    		System.out.print("What would you like to select? ");
    		choice = input.nextInt();
    		
    	}while(choice < 1 || choice > upperLimit);
    	
    	//Prints Asterisks
    	asteriskPrinter();
    	
    	return choice;
    		
    }
    
	public static void asteriskPrinter(){
    	
    	
    	System.out.println();
    	
    	//Prints a line of aterisks
    	for (int i = 1; i <=80; i++){
    		System.out.print("*");
    	}
    	
    	System.out.println();
    }
}
