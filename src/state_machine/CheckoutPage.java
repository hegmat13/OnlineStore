package state_machine;

import java.util.Scanner;
import online_store_group_project.*;

public class CheckoutPage extends Page{

	private int Identifier = 9;   
	 
	 
	public void nextPage(PageState pageState) {
	Scanner reader = new Scanner(System.in);
	
    
	while(true) {	
	System.out.println("Your order total is: $" + pageState.getCost());	
	System.out.println("Would you like to pay with Bitcoin, CreditCard, or DebitCard?:"); 
	
	String input = reader.nextLine();
	
	
	
	if (input.equals("home")) {
	pageState.setPage(new HomePage());	
	return;
	}
	
	else {
		if (input.equals("back")) {
		pageState.setPage(pageState.getPreviouspage());	
		return;
		}
		
		else { 
	    if(input.equals("Bitcoin")) {
	    pageState.setPaymentState(2);
	    	
	    System.out.println("Enter the wallet number:"); 
	    input = reader.nextLine();
	    pageState.setBitcoinAddress(input);
	    
	    
	    System.out.println("Enter Shipping Address:");
	    input = reader.nextLine();
	    pageState.setShippingAddress(input); 
	       
    	pageState.setPreviousPage(this);
    	pageState.setPage(new PaymentVerification());	
    	return; 
	    }
	    
	    else if(input.equals("CreditCard")) {
	    pageState.setPaymentState(0);
	    System.out.println("Enter the card number:"); 
	    input = reader.nextLine();
	    pageState.setCardNumber(input);
	    
	    
	    System.out.println("Enter Shipping Address:");
	    input = reader.nextLine();
	    pageState.setShippingAddress(input); 
	    
    	pageState.setPreviousPage(this);
    	pageState.setPage(new PaymentVerification());	
    	return; 
	    }
	    
	    else if(input.equals("DebitCard")) {
	    pageState.setPaymentState(1);
	    System.out.println("Enter the card number:"); 
	    input = reader.nextLine();
	    pageState.setCardNumber(input);
	    
	    
	    System.out.println("Enter Shipping Address:");
	    input = reader.nextLine();
	    pageState.setShippingAddress(input); 
	    
    	pageState.setPreviousPage(this);
    	pageState.setPage(new PaymentVerification());	
    	return; 
	    }
	    
	    else {
	    System.out.println(input + " is not a valid option. Try again.");	
	    }	
	   } 
	  }
	}
 }
	
	
	
	public int getIdentifier() {
		return Identifier; 
	}
	
	
	
	
}
