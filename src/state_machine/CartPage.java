package state_machine;

import java.util.ArrayList;
import java.util.Scanner;

import online_store_group_project.Item;

public class CartPage extends Page {

	private int Identifier = 8;   
	
	 
	public void nextPage(PageState pageState) {
    ArrayList<Item> cart = pageState.getCart(); 
	Scanner reader = new Scanner(System.in);
	double cost = 0; 
	
    
	while(true) {
	System.out.println("These are all the items in your cart with prices:");
	System.out.println("cart:");
	pageState.getStore().PrintCart(cart);
	System.out.println("Total cost: $" + pageState.getCost());
	
	System.out.println("Do you want to checkout ('checkout')  continue shopping ('continue')");
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
		if(input.equals("checkout")) {
			
			pageState.setPreviousPage(this);
			pageState.setPage(new CheckoutPage());	
			return; 	
		}
		else if(input.equals("continue")) {
			
			pageState.setPreviousPage(this);
			pageState.setPage(new HomePage());	
			return; 	
		}
		
		else {
		System.out.println("Invalid Entry. Please Try Again");	 	
		}
		} 
	  }
	}
 }
	
	
	
	public int getIdentifier() {
		return Identifier; 
	}
	
	
	
	
}
