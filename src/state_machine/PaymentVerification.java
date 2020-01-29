package state_machine;

import java.util.Scanner;

public class PaymentVerification extends Page {

	private int Identifier = 11;   
	
	 
	public void nextPage(PageState pageState) {
	Scanner reader = new Scanner(System.in);
	
    
	while(true) {	
		if(pageState.getPaymentState() == 2) { //Bitcoin 
		 if((pageState.getBitcoinAddress().length() > 26) && (pageState.getBitcoinAddress().length() < 35)) {
			 System.out.println("Your Payment Info is Confirmed.");
		   
		    pageState.setPage(new OrderConfirmationPage());	
		    return; 			 
		 }
		}
		
		else if(pageState.getPaymentState() == 1 || pageState.getPaymentState() == 0) { //Credit or Debit 
		 if(pageState.getCardNumber().length() == 16) {
			 System.out.println("Your Payment Info is Confirmed.");
			 
		    pageState.setPage(new OrderConfirmationPage());	
		    return; 
		 }
		}
		
			System.out.println("Payment Info is invalid. Pleasse try again.");
	    	pageState.setPage(new CheckoutPage());	
	    	return; 
		 }
	  }
 
	
	
	
	public int getIdentifier() {
		return Identifier; 
	}
	
	
}
