/**
 * @(#)Owner.java
 * This is the Owner class file. This is where the
 * variables and methods for the aggregate class
 * Owner is located.
 * June 8, 2016
 * Austin Ho
 * @version 1.00 2016/6/8
 */


public class Owner {

	//Declare Variables
	private String name;
	private int age;
	private char gender;
	private String address;
	private double annualIncome;
	
    public Owner(String nm, int yrs, char sex, String loc, double anIn) {
    	
    	name = nm;
    	age = yrs;
    	gender = sex;
    	address = loc;
    	annualIncome = anIn;
    	
    }
    
    public String getName(){
    	return name;
    }
    
    public double getAnnualIncome(){
    	
    	return annualIncome;
    	
    }
    public void setAge(int nAge){
    	age = nAge;
    }
    public void setAddress(String nAddress){
    	address = nAddress;
    }
    public void setAnnualIncome(double nAnnualIncome){
    	annualIncome = nAnnualIncome;
    }
    
    
    public String toString(){
    	
    	String str;
    	str = "Owner: " + name + "\n"
    	 	+ "Age: " + age + "\n"
    	 	+ "Gender: " + gender + "\n"
    	 	+ "Address: " + address + "\n"
    	 	+ "Annual Income: " + annualIncome;
		
		return str;
    }
    
}