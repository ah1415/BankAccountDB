/**
 * @(#)BankAccountDB.java
 * This file is the Bank Account Database file.
 * This is where the Bank Account array is created
 * and the methods to modify the array is.
 * June 8, 2016
 * Austin Ho
 * @version 1.00 2016/6/8
 */


public class BankAccountDB {
	
	//Declare Bank Account Array
	BankAccount[] bankAcc;
	
    public BankAccountDB() {
    	bankAcc = new BankAccount[10];
    }
    
    public void add(int accNum, double bal, String name, double intRate, String owner, int age, char sex, String loc, double annInc){
    	
    	boolean check = false;
    	
    	for(int i = 0; i <= bankAcc.length; i++){
    		
    		//Finds an empty element in the array and creates a new bank account
    		if (bankAcc[i] == null){
    		
    			bankAcc[i] = new BankAccount(accNum, bal, name, intRate, owner, age, sex, loc, annInc);
    			System.out.println("Bank Account " + bankAcc[i].getAccNum() + " was created in slot " + (i + 1) + ".");
    			check = true;
    			break;
    		}
    		
    	}
    	
    	//If there are no array elements available
    	if (check == false)
    		System.out.println("All Bank Accounts are full. Remove an account before creating a new one.");
    			
    }
    
    public void remove(int choice){
    	
    	//Removes selected account
    	if (bankAcc[choice-1] != null){
    		System.out.println("Bank Account " + bankAcc[choice-1].getAccNum() + " in slot " + choice + " was removed.");
    		bankAcc[choice-1] = null;
    	}
    	//If there was no account stored in the slot
    	else
    		System.out.println("There was no account stored in that slot.");
    }
    
    public void update(int slotNum, int choice, double value){
    	
    	if (choice == 1){
    		bankAcc[slotNum - 1].setBalance(value);
    		System.out.println("Balance was updated for slot " + slotNum);
    	}
    	else if(choice == 2){
    		bankAcc[slotNum - 1].setIntRate(value);
    		System.out.println("Interest rate was updated for slot " + slotNum);
    	}
    	else if(choice == 5){
    		bankAcc[slotNum - 1].setOwnerAnnualIncome(value);
    		System.out.println("Interest rate was updated for slot " + slotNum);
    	}
    }
    
    public void update(int slotNum, String add){
    	bankAcc[slotNum - 1].setOwnerAddress(add);
    	System.out.println("Address was updated for slot " + slotNum);
    }
    
    public void update(int slotNum, int age){
    	bankAcc[slotNum - 1].setOwnerAge(age);
    	System.out.println("Age was updated for slot " + slotNum);
    }
    
    public void listRecordNum(int choice){
    	
    	//Prints out selected bank account
    	if (bankAcc[choice-1] != null){
    		System.out.println(bankAcc[choice - 1].toString());
    	}
    	//If there was no account stored in the slot
    	else
    		System.out.println("There was no account stored in that slot.");
    }
    
    public void listAll(){
    	
    	//Prints Out All Elements of the Database That Are Not Null
    	for(int i = 1; i <= 10; i ++){
    		
    		if(bankAcc[i-1] != null)
    		System.out.println("Slot " + i + ".\n" + bankAcc[i-1].toString());
       	}
    }
    
    public void sort(int choice){
    	
    	//Declare Variables
    	int count = 0;
    	
    	//Counts the Number of Bank Accounts Made
    	for(int i = 0; i < bankAcc.length; i ++){
    		if (bankAcc[i] != null)
    			count ++;
    	}
    	
    	//If there are no bank accounts
    	if(count == 0)
    		System.out.println("There were no bank accounts to sort.");
    		
    	else{
    		
    		//Rearranges Array Elements So All Created Bank Accounts Are First And Null Values Are Last
	    	for(int i = 0; i < count; i ++){
		    		
		    	if (bankAcc[i] == null)
		    		for(int j = (bankAcc.length - 1); j > -1; j --){
		    			if (bankAcc[j] != null){
		    				bankAcc[i] = bankAcc[j];
		    				bankAcc[j] = null;
		    				break;
		    			}
		    		}
		    }
    		
	    	if (choice == 1){ //Sorts By Owner Name
	    		
	    		int k = 0;
		    	boolean exchangeMade = true;
		    	
		    	//Sorts the Elements of the Array By Name
		    	while((k < count - 1) && exchangeMade){
		    		exchangeMade = false;
		    		k++;
		    		for(int j = 0; j < count - k; j ++){
		    			if(bankAcc[j].getHolderName().compareToIgnoreCase(bankAcc[j+1].getHolderName()) < 0){
		    				BankAccount temp = bankAcc[j];
		    				bankAcc[j] = bankAcc[j+1];
		    				bankAcc[j+1] = temp;
		    				exchangeMade = true;
		    			}
		    		}
		    	}
		    	System.out.println("The bank accounts were sorted by owner name.");
		    	
	    	}	
	    	else if(choice == 2){ // Sorts By Account Number
	    
	    		int k = 0;
		    	boolean exchangeMade = true;
		    	
		    	//Sorts the Elements of the Array By Acount Number
		    	while((k < count - 1) && exchangeMade){
		    		exchangeMade = false;
		    		k++;
		    		for(int j = 0; j < count - k; j ++){
		    			if(bankAcc[j].getAccNum() > bankAcc[j+1].getAccNum()){
		    				BankAccount temp = bankAcc[j];
		    				bankAcc[j] = bankAcc[j+1];
		    				bankAcc[j+1] = temp;
		    				exchangeMade = true;
		    			}
		    		}
		    	}
		    	System.out.println("The bank accounts were sorted by account number.");
	    	}
	    	
	    	else if(choice ==3){ //Sorts By Balance
	    	
	    		
	    		int k = 0;
		    	boolean exchangeMade = true;
		    	
		    	//Sorts the Elements of the Array By Balance
		    	while((k < count - 1) && exchangeMade){
		    		exchangeMade = false;
		    		k++;
		    		for(int j = 0; j < count - k; j ++){
		    			if(bankAcc[j].getBalance() > bankAcc[j+1].getBalance()){
		    				BankAccount temp = bankAcc[j];
		    				bankAcc[j] = bankAcc[j+1];
		    				bankAcc[j+1] = temp;
		    				exchangeMade = true;
		    			}
		    		}
		    	}
		    	System.out.println("The bank accounts were sorted by balance.");
	    	}
    	}
    	
    }
    
    
    public String allCalculate(double amount){
    	
    	String banks = "";
    	
    	//Builds a String With the Bank Slot and Years to Reach Value
    	for(int i = 0; i < bankAcc.length; i ++){
    		if(bankAcc[i] != null)
    			banks += "Slot " + (i + 1) + "Years: " + bankAcc[i].calculator(amount) + "\n";
    	}
    	//If There Were No Banks
    	if(banks.equals(""))
    		banks = "There were no bank accounts stored in the database.";
    		
    	return banks;
    }
    
    public int fCalculate(double amount){
    	
    	
    	int num = -1;
    	int lowYears = Integer.MAX_VALUE;
    	
    	//Determines Which Bank Account Takes the Least Amount of Years to Reach the Specified Value
    	for(int i = 0; i < bankAcc.length; i ++){
    		
    		if(bankAcc[i] != null){
    			if (bankAcc[i].calculator(amount) < lowYears){
    				lowYears = bankAcc[i].calculator(amount);
    				num = i + 1;
    			}
    		}
    	}
    	return num;		
    		
    }
    
    
}